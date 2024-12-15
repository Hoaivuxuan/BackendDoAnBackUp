package com.duy.BackendDoAn.repositories;

import com.duy.BackendDoAn.models.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
    List<Evaluation> findByHotelId(@Param("hotelId") Long hotelId);
}
