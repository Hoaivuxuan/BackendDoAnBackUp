package com.duy.BackendDoAn.services;

import com.duy.BackendDoAn.dtos.CarDTO;
import com.duy.BackendDoAn.dtos.MotorDTO;
import com.duy.BackendDoAn.dtos.VehicleDTO;
import com.duy.BackendDoAn.models.*;
import com.duy.BackendDoAn.repositories.*;
import com.duy.BackendDoAn.responses.CarResponse;
import com.duy.BackendDoAn.responses.MotorResponse;
import com.duy.BackendDoAn.responses.vehicles.VehicleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;

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
                .stake(carDTO.getStake())
                .image_url(carDTO.getImageUrl())
                .vehicle_type(carDTO.getType())
                .description(carDTO.getDescription())
                .seat_amount(carDTO.getSeatAmount())
                .luggage_amount(carDTO.getLuggageAmount())
                .fuel_type(carDTO.getFuelType())
                .transmission_type(carDTO.getTransmission())
                .trunk_capacity(carDTO.getTrunk())
                .build();

        Car savedCar = carRepository.save(newCar);

        // Tạo liên kết giữa Car và RentalFacility
        VehicleRentalFacility vehicleRentalFacility = VehicleRentalFacility.builder()
                .vehicle(savedCar)
                .rentalFacility(facility)
                .price(carDTO.getPricePerHour())
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
                .stake(motorDTO.getStake())
                .image_url(motorDTO.getImageUrl())
                .vehicle_type(motorDTO.getType())
                .description(motorDTO.getDescription())
                .seat_amount(motorDTO.getSeatAmount())
                .luggage_amount(motorDTO.getLuggageAmount())
                .type_of_motor(motorDTO.getTypeOfMotor())
                .handle_bar_type(motorDTO.getHandleBarType())
                .fuel_type(motorDTO.getFuelType())
                .engine(motorDTO.getEngine())
                .build();
        Motor savedMotor = motorRepository.save(newMotor);

        // Tạo liên kết giữa Motor và RentalFacility
        VehicleRentalFacility vehicleRentalFacility = VehicleRentalFacility.builder()
                .vehicle(savedMotor)
                .rentalFacility(facility)
                .price(motorDTO.getPricePerHour())
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

    public Vehicle updateCar(long id, VehicleDTO vehicleDTO) throws Exception {
        Vehicle car = getVehicleById(id);
        if (car instanceof Car existingCar) {
            RentalFacility rentalFacility = rentalFacilityRepository.findById(vehicleDTO.getFacility())
                    .orElseThrow(() -> new Exception("Facility not exist"));

            if (vehicleDTO.getName() != null && !vehicleDTO.getName().isEmpty()) {
                existingCar.setName(vehicleDTO.getName());
            }
            if (vehicleDTO.getDescription() != null && !vehicleDTO.getDescription().isEmpty()) {
                existingCar.setDescription(vehicleDTO.getDescription());
            }
            if (vehicleDTO.getSeatAmount() > 0) {
                existingCar.setSeat_amount(vehicleDTO.getSeatAmount());
            }
            if (vehicleDTO.getLuggageAmount() >= 0) {
                existingCar.setLuggage_amount(vehicleDTO.getLuggageAmount());
            }
            if (vehicleDTO.getFuelType() != null && !vehicleDTO.getFuelType().isEmpty()) {
                existingCar.setFuel_type(vehicleDTO.getFuelType());
            }
            if (vehicleDTO.getTransmission() != null && !vehicleDTO.getTransmission().isEmpty()) {
                existingCar.setTransmission_type(vehicleDTO.getTransmission());
            }
            if (vehicleDTO.getTrunk() > 0) {
                existingCar.setTrunk_capacity(vehicleDTO.getTrunk());
            }
            Car savedCar = carRepository.save(existingCar);
            VehicleRentalFacility vehicleRentalFacility = VehicleRentalFacility.builder()
                    .vehicle(savedCar)
                    .rentalFacility(rentalFacility)
                    .price(vehicleDTO.getPricePerHour())
                    .build();
            savedCar.setVehicleRentalFacilities(Collections.singletonList(vehicleRentalFacility));
            return carRepository.findById(savedCar.getId()).orElseThrow(() -> new Exception("Vehicle not found")); // Trả về kiểu Vehicle thay vì Car
        } else {
            throw new Exception("Car not found or invalid vehicle type");
        }
    }


    public Vehicle updateMotor(long id, VehicleDTO motorDTO) throws Exception {
        Object motor = getVehicleById(id);
        if(motor instanceof Motor existingMotor){
            RentalFacility rentalFacility = rentalFacilityRepository.findById(motorDTO.getFacility()).orElseThrow(()-> new Exception("Facility not exist"));
            if(motorDTO.getName() != null && !motorDTO.getName().isEmpty()){
                existingMotor.setName(motorDTO.getName());
            }
            if(motorDTO.getDescription() != null && !motorDTO.getDescription().isEmpty()){
                existingMotor.setDescription(motorDTO.getDescription());
            }
            if(motorDTO.getSeatAmount() > 0){
                existingMotor.setSeat_amount(motorDTO.getSeatAmount());
            }
            if(motorDTO.getLuggageAmount() >= 0){
                existingMotor.setLuggage_amount(motorDTO.getLuggageAmount());
            }
            if(motorDTO.getFuelType() != null && !motorDTO.getFuelType().isEmpty()){
                existingMotor.setFuel_type(motorDTO.getFuelType());
            }
            if(motorDTO.getTypeOfMotor() != null && !motorDTO.getTypeOfMotor().isEmpty()){
                existingMotor.setType_of_motor(motorDTO.getTypeOfMotor());
            }
            if(motorDTO.getHandleBarType() != null && !motorDTO.getHandleBarType().isEmpty()){
                existingMotor.setHandle_bar_type(motorDTO.getHandleBarType());
            }
            if(motorDTO.getEngine() >= 0){
                existingMotor.setEngine(motorDTO.getEngine());
            }
            Motor savedMotor = motorRepository.save(existingMotor);
            VehicleRentalFacility vehicleRentalFacility = VehicleRentalFacility.builder()
                    .vehicle(savedMotor)
                    .rentalFacility(rentalFacility)
                    .price(motorDTO.getPricePerHour())
                    .build();
            savedMotor.setVehicleRentalFacilities(Collections.singletonList(vehicleRentalFacility));
            return motorRepository.findById(savedMotor.getId()).orElseThrow(() -> new Exception("Vehicle not found"));
        }
        else return null;
    }

    public void deleteVehicleById(Long id) throws Exception {
        Vehicle vehicle = getVehicleById(id);
        if("CAR".equals(vehicle.getVehicle_type())) {
            carRepository.deleteById(id);
        }
        else if ("MOTOR".equals(vehicle.getVehicle_type())) {
            motorRepository.deleteById(id);
        }
        vehicleRepository.deleteById(id);
    }
}
