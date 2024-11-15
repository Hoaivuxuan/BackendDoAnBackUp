package com.duy.BackendDoAn.services;

import com.duy.BackendDoAn.dtos.ReviewDTO;
import com.duy.BackendDoAn.models.Hotel;
import com.duy.BackendDoAn.models.ReviewHotel;
import com.duy.BackendDoAn.models.User;
import com.duy.BackendDoAn.repositories.HotelRepository;
import com.duy.BackendDoAn.repositories.ReviewHotelRepository;
import com.duy.BackendDoAn.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ReviewHotelService {
    private final ReviewHotelRepository reviewHotelRepository;
    private final HotelRepository hotelRepository;
    private final UserRepository userRepository;
    public ReviewHotel postNewReview(ReviewDTO reviewDTO) throws Exception {
        Hotel hotel = hotelRepository.findById(reviewDTO.getHotel()).orElseThrow(()-> new Exception("Hotel not found"));
        User user = userRepository.findById(reviewDTO.getUser()).orElseThrow(()-> new Exception("User not found"));
        ReviewHotel reviewHotel = ReviewHotel.builder()
                .rating(reviewDTO.getRating())
                .comment(reviewDTO.getComment())
                .review_date(LocalDate.now())
                .hotel(hotel)
                .user(user)
                .build();
        return reviewHotelRepository.save(reviewHotel);
    }

}
