package com.duy.BackendDoAn.responses;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EvaluationListResponse {
    private List<EvaluationResponse> evaluationResponses;
    private int totalPages;
}
