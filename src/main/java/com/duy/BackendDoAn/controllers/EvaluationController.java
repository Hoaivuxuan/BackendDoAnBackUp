package com.duy.BackendDoAn.controllers;

import com.duy.BackendDoAn.dtos.EvaluationDTO;
import com.duy.BackendDoAn.models.Evaluation;
import com.duy.BackendDoAn.responses.EvaluationListResponse;
import com.duy.BackendDoAn.responses.EvaluationResponse;
import com.duy.BackendDoAn.services.EvaluationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/evaluation")
@RestController
public class EvaluationController {
    private final EvaluationService evaluationService;
    @GetMapping("")
    public ResponseEntity<List<EvaluationResponse>> getAllEvaluation(@RequestParam("hotel_id") long id) {
        return ResponseEntity.ok(evaluationService.getAllEvaluation(id));
    }

    @PostMapping
    public ResponseEntity<EvaluationResponse> postNewEvaluation(@RequestHeader("Authorization") String authorizationHeader, @Valid @RequestBody EvaluationDTO evaluationDTO) throws Exception {
        String extractedToken = authorizationHeader.substring(7);
        Evaluation evaluation = evaluationService.postNewEvaluation(extractedToken, evaluationDTO);
        return ResponseEntity.ok(EvaluationResponse.fromEvaluation(evaluation));
    }
}
