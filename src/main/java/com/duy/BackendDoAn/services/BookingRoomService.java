package com.duy.BackendDoAn.services;

import com.duy.BackendDoAn.components.JwtTokenUtil;
import com.duy.BackendDoAn.dtos.BookedRoomDTO;
import com.duy.BackendDoAn.dtos.BookingRoomDTO;
import com.duy.BackendDoAn.models.BookedRoom;
import com.duy.BackendDoAn.models.BookingRoom;
import com.duy.BackendDoAn.models.User;
import com.duy.BackendDoAn.models.Room;
import com.duy.BackendDoAn.repositories.BookedRoomRepository;
import com.duy.BackendDoAn.repositories.BookingRoomRepository;
import com.duy.BackendDoAn.repositories.RoomRepository;
import com.duy.BackendDoAn.repositories.UserRepository;
import com.duy.BackendDoAn.responses.BookingRoomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BookingRoomService {
    private final UserRepository userRepository;
    private final BookingRoomRepository bookingRoomRepository;
    private final RoomRepository roomRepository;
    private final BookedRoomRepository bookedRoomRepository;
    private final JwtTokenUtil jwtTokenUtil;
    public BookingRoom createBooking (BookingRoomDTO bookingRoomDTO) throws Exception {
        User user = userRepository.findById(bookingRoomDTO.getUser()).orElseThrow(()-> new Exception("User not found"));
        BookingRoom newBookingRoom = BookingRoom.builder()
                .booking_date(LocalDate.now())
                .check_in_date(bookingRoomDTO.getCheckInDate())
                .check_out_date(bookingRoomDTO.getCheckOutDate())
                .status(bookingRoomDTO.getStatus())
                .user(user)
                .build();
        Float total = 0F;
        long days = ChronoUnit.DAYS.between(newBookingRoom.getCheck_out_date(), newBookingRoom.getCheck_in_date());
        List<BookedRoom> instanceBookedRoom = new ArrayList<>();
        for (BookedRoomDTO bookedRoomDTO : bookingRoomDTO.getBookedRooms()){
            Room room = roomRepository.findById(bookedRoomDTO.getRoom()).orElseThrow(()-> new Exception("Room not found"));
            BookedRoom bookedRoom = BookedRoom.builder()
                    .amount(bookedRoomDTO.getAmount())
                    .price_per(bookedRoomDTO.getAmount() * room.getPrice_per_day() * days)
                    .room(room)
                    .bookingRoom(newBookingRoom)
                    .build();
            instanceBookedRoom.add(bookedRoom);
            if(room.getAvailable_room() - bookedRoom.getAmount() >= 0){
                room.setAvailable_room(room.getAvailable_room() - bookedRoom.getAmount());
            }
            roomRepository.save(room);
            total += bookedRoom.getPrice_per();
        }
        newBookingRoom.setTotal_price(total);
        newBookingRoom.setBookedRooms(instanceBookedRoom);
        bookingRoomRepository.save(newBookingRoom);
        bookedRoomRepository.saveAll(instanceBookedRoom);
        return newBookingRoom;
    }


    public Page<BookingRoomResponse> getAllBookingRoom(String token, PageRequest pageRequest) throws Exception {
        if (jwtTokenUtil.isTokenExpired(token)) {
            throw new Exception("Token is expired!");
        }
        String email = jwtTokenUtil.extractEmail(token);
        Optional<User> optionalUser = userRepository.findByEmail(email);
        User user = optionalUser.orElseThrow(() -> new Exception("User not found"));
        if(user.getRole().equals("ADMIN")) {
            Page<BookingRoom> bookingRoomPage = bookingRoomRepository.findAll(pageRequest);
            return bookingRoomPage.map(BookingRoomResponse::fromBookingRoom);
        } else if (user.getRole().equals("USER")) {
            Page<BookingRoom> bookingRoomPage = bookingRoomRepository.findByUser(user, pageRequest);
            return bookingRoomPage.map(BookingRoomResponse::fromBookingRoom);
        }
        return null;
    }

    public BookingRoom getBookingById(long id){
        return bookingRoomRepository.findById(id).orElseThrow(()-> new RuntimeException("Booking not found"));
    }

    public void deleteBookingRoom(long id) throws Exception {
        BookingRoom bookingRoom = bookingRoomRepository.findById(id).orElseThrow(()-> new Exception("Booking not found"));
        if(bookingRoom!= null){
            bookingRoom.setStatus("CANCELLED");
            bookingRoomRepository.save(bookingRoom);
        }
    }

    public BookingRoom updateStatusBooking(long id, BookingRoomDTO bookingRoomDTO) throws Exception {
        BookingRoom bookingRoom = bookingRoomRepository.findById(id).orElseThrow(()-> new Exception("Booking not found"));
        Set<String> validStatuses = Set.of("CONFIRMED", "WAITING", "REFUSED");
        if(!validStatuses.contains(bookingRoomDTO.getStatus().toUpperCase())){
            throw new Exception("Status not found");
        }
        bookingRoom.setStatus(bookingRoomDTO.getStatus());
        return bookingRoomRepository.save(bookingRoom);
    }
}
