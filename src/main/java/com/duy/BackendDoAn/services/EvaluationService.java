package com.duy.BackendDoAn.services;

import com.duy.BackendDoAn.components.JwtTokenUtil;
import com.duy.BackendDoAn.dtos.EvaluationDTO;
import com.duy.BackendDoAn.models.Evaluation;
import com.duy.BackendDoAn.models.Hotel;
import com.duy.BackendDoAn.models.User;
import com.duy.BackendDoAn.repositories.EvaluationRepository;
import com.duy.BackendDoAn.repositories.HotelRepository;
import com.duy.BackendDoAn.repositories.UserRepository;
import com.duy.BackendDoAn.responses.EvaluationResponse;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EvaluationService {

    private final EvaluationRepository evaluationRepository;
    private final UserRepository userRepository;
    private final HotelRepository hotelRepository;
    private final JwtTokenUtil jwtTokenUtil;

    public List<EvaluationResponse> getAllEvaluation(long id){
        List<Evaluation> evaluations = evaluationRepository.findByHotelId(id);
        return evaluations.stream().map(EvaluationResponse::fromEvaluation).collect(Collectors.toList());
    }

    public Evaluation postNewEvaluation(String token, EvaluationDTO evaluationDTO) throws Exception {
        String email = jwtTokenUtil.extractEmail(token);
        Optional<User> optionalUser = userRepository.findByEmail(email);
        User user = optionalUser.orElseThrow(() -> new Exception("User not found"));
        Optional<Hotel> optionalHotel = hotelRepository.findById(evaluationDTO.getHotel());
        Hotel hotel = optionalHotel.orElseThrow(()-> new Exception("Hotel not found"));
        Evaluation evaluation = Evaluation.builder()
                .rating(evaluationDTO.getRating())
                .comment(evaluationDTO.getComment())
                .evaluation_date(LocalDate.now())
                .hotel(hotel)
                .user(user)
                .build();
        return evaluation;
    }
}
