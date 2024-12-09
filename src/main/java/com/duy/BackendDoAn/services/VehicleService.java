package com.duy.BackendDoAn.services;

import com.duy.BackendDoAn.dtos.UpdateVehicleDTO;
import com.duy.BackendDoAn.dtos.VehicleDTO;
import com.duy.BackendDoAn.models.*;
import com.duy.BackendDoAn.repositories.*;
import com.duy.BackendDoAn.responses.vehicles.VehicleResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehicleService {
    public final RentalFacilityRepository rentalFacilityRepository;
    public final VehicleRepository vehicleRepository;
    public final CarRepository carRepository;
    public final MotorRepository motorRepository;
    public final VehicleRentalFacilityRepository vehicleRentalFacilityRepository;

    public Vehicle addCar(VehicleDTO carDTO) throws Exception {
        RentalFacility facility = rentalFacilityRepository.findById(carDTO.getFacility())
                .orElseThrow(() -> new Exception("Rental Facility doesn't exist"));

        Car newCar = Car.builder()
                .name(carDTO.getName())
                .brand(carDTO.getBrand())
                .year(carDTO.getYear())
                .vehicle_type(carDTO.getType())
                .transmission_type(carDTO.getTransmissionType())
                .baggage_capacity(carDTO.getBaggageCapacity())
                .seats(carDTO.getSeats())
                .fuel(carDTO.getFuel())
                .engine(carDTO.getEngine())
                .build();

        Car savedCar = carRepository.save(newCar);

        // Tạo liên kết giữa Car và RentalFacility
        VehicleRentalFacility vehicleRentalFacility = VehicleRentalFacility.builder()
                .vehicle(savedCar)
                .rentalFacility(facility)
                .price(carDTO.getPrice())
                .stake(carDTO.getStake())
                .availableVehicle(carDTO.getAvailableVehicle())
                .build();

        vehicleRentalFacilityRepository.save(vehicleRentalFacility);
        savedCar.setVehicleRentalFacilities(Collections.singletonList(vehicleRentalFacility));
        return carRepository.findById(savedCar.getId()).orElseThrow(() -> new Exception("Vehicle not found"));  // Trả về đối tượng Vehicle chung
    }


    public Vehicle addMotor(VehicleDTO motorDTO) throws Exception {
        RentalFacility facility = rentalFacilityRepository.findById(motorDTO.getFacility())
                .orElseThrow(() -> new Exception("Rental Facility doesn't exist"));

        Motor newMotor = Motor.builder()
                .name(motorDTO.getName())
                .brand(motorDTO.getBrand())
                .year(motorDTO.getYear())
                .vehicle_type(motorDTO.getType())
                .capacity(motorDTO.getCapacity())
                .fuel(motorDTO.getFuel())
                .engine(motorDTO.getEngine())
                .build();
        Motor savedMotor = motorRepository.save(newMotor);

        // Tạo liên kết giữa Motor và RentalFacility
        VehicleRentalFacility vehicleRentalFacility = VehicleRentalFacility.builder()
                .vehicle(savedMotor)
                .rentalFacility(facility)
                .price(motorDTO.getPrice())
                .availableVehicle(motorDTO.getAvailableVehicle())
                .build();

        vehicleRentalFacilityRepository.save(vehicleRentalFacility);
        savedMotor.setVehicleRentalFacilities(Collections.singletonList(vehicleRentalFacility));
        return motorRepository.findById(savedMotor.getId()).orElseThrow(() -> new Exception("Vehicle not found"));   // Trả về đối tượng Vehicle chung
    }


    public Page<VehicleResponse> getAllVehicle(String type, String location, LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime, PageRequest pageRequest) {
        Page<Vehicle> vehiclePage;
        vehiclePage = vehicleRepository.searchVehicle(type, location, startDate, endDate, startTime, endTime, pageRequest);
        return vehiclePage.map(VehicleResponse::fromVehicle);
    }

    public Vehicle getVehicleById(Long id) throws Exception {
        return vehicleRepository.findById(id).orElseThrow(() -> new Exception("Vehicle not found"));
    }

    public VehicleResponse getSpecificVehicleById(Long id) throws Exception {
        Vehicle vehicle = getVehicleById(id);
        return VehicleResponse.fromVehicle(vehicle);
    }

    public Vehicle updateCar(long id, UpdateVehicleDTO vehicleDTO) throws Exception {
        Vehicle car = getVehicleById(id);
        RentalFacility rentalFacility = rentalFacilityRepository.findById(vehicleDTO.getFacility())
                .orElseThrow(() -> new Exception("Rental facility not found!!"));
        VehicleRentalFacility vehicleRentalFacility = vehicleRentalFacilityRepository
                .findById(vehicleDTO.getRentalVehicle())
                .orElseThrow(() -> new Exception("Rental Vehicle not found!!"));

        if (car instanceof Car existingCar) {

            if (vehicleDTO.getName() != null && !vehicleDTO.getName().isEmpty()) {
                existingCar.setName(vehicleDTO.getName());
            }
            if (vehicleDTO.getBrand() != null && !vehicleDTO.getBrand().isEmpty()) {
                existingCar.setBrand(vehicleDTO.getBrand());
            }
            if (vehicleDTO.getYear() != null && vehicleDTO.getYear() > 0) {
                existingCar.setYear(vehicleDTO.getYear());
            }
            if (vehicleDTO.getSeats() != null && vehicleDTO.getSeats() > 0) {
                existingCar.setSeats(vehicleDTO.getSeats());
            }
            if (vehicleDTO.getBaggageCapacity() != null && vehicleDTO.getBaggageCapacity() >= 0) {
                existingCar.setBaggage_capacity(vehicleDTO.getBaggageCapacity());
            }
            if (vehicleDTO.getFuel() != null && !vehicleDTO.getFuel().isEmpty()) {
                existingCar.setFuel(vehicleDTO.getFuel());
            }
            if (vehicleDTO.getTransmissionType() != null && !vehicleDTO.getTransmissionType().isEmpty()) {
                existingCar.setTransmission_type(vehicleDTO.getTransmissionType());
            }
            if (vehicleDTO.getEngine() != null && !vehicleDTO.getEngine().isEmpty()) {
                existingCar.setEngine(vehicleDTO.getEngine());
            }
            Car savedCar = carRepository.save(existingCar);

            vehicleRentalFacility.setRentalFacility(rentalFacility);
            vehicleRentalFacility.setVehicle(savedCar);
            vehicleRentalFacility.setStake(vehicleDTO.getStake());
            vehicleRentalFacility.setAvailableVehicle(vehicleDTO.getAvailableVehicle());
            vehicleRentalFacility.setPrice(vehicleDTO.getPrice());

            vehicleRentalFacilityRepository.save(vehicleRentalFacility);
            return savedCar;
        } else {
            throw new Exception("Car not found or invalid vehicle type");
        }
    }


    public Vehicle updateMotor(long id, UpdateVehicleDTO motorDTO) throws Exception {
        Vehicle motor = getVehicleById(id);
        RentalFacility rentalFacility = rentalFacilityRepository.findById(motorDTO.getFacility())
                .orElseThrow(() -> new Exception("Rental facility not found!!"));
        VehicleRentalFacility vehicleRentalFacility = vehicleRentalFacilityRepository.findById(motorDTO.getRentalVehicle())
                .orElseThrow(() -> new Exception("Rental vehicle not found!!"));
        if (motor instanceof Motor existingMotor) {
            if (motorDTO.getName() != null && !motorDTO.getName().isEmpty()) {
                existingMotor.setName(motorDTO.getName());
            }
            if (motorDTO.getBrand() != null && !motorDTO.getBrand().isEmpty()) {
                existingMotor.setBrand(motorDTO.getBrand());
            }
            if (motorDTO.getYear() != null && motorDTO.getYear() > 0) {
                existingMotor.setYear(motorDTO.getYear());
            }
            if (motorDTO.getCapacity() != null && !motorDTO.getCapacity().isEmpty()) {
                existingMotor.setCapacity(motorDTO.getCapacity());
            }
            if (motorDTO.getFuel() != null && !motorDTO.getFuel().isEmpty()) {
                existingMotor.setFuel(motorDTO.getFuel());
            }
            if (motorDTO.getEngine() != null && !motorDTO.getEngine().isEmpty()) {
                existingMotor.setEngine(motorDTO.getEngine());
            }
            Motor savedMotor = motorRepository.save(existingMotor);
            vehicleRentalFacility = VehicleRentalFacility.builder()
                    .vehicle(savedMotor)
                    .rentalFacility(rentalFacility)
                    .price(motorDTO.getPrice())
                    .availableVehicle(motorDTO.getAvailableVehicle())
                    .build();
            vehicleRentalFacilityRepository.save(vehicleRentalFacility);
            return savedMotor;
        } else return null;
    }

    @Transactional
    public void deleteVehicleById(Long id) {
        Optional<VehicleRentalFacility> vehicleRentalFacility = vehicleRentalFacilityRepository.findById(id);
        vehicleRentalFacility.ifPresent(vehicleRentalFacilityRepository::delete);
    }
}
