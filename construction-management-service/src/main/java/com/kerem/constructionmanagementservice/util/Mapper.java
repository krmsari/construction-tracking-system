package com.kerem.constructionmanagementservice.util;

import com.kerem.constructionmanagementservice.dto.construction.request.ConstructionRequest;
import com.kerem.constructionmanagementservice.dto.construction.response.ConstructionResponse;
import com.kerem.constructionmanagementservice.entity.Construction;

import java.util.UUID;

public class Mapper {

    // Construction to ConstructionResponse
    public static ConstructionResponse mapConstructionToConstructionResponse(Construction construction) {
        return new ConstructionResponse(
                construction.getName(),
                construction.getAddress(),
                construction.getStartDate(),
                construction.getEndDate(),
                construction.getNumberOfBasements(),
                construction.getNumberOfFloors(),
                construction.getEstimatedCost(),
                construction.getSiteManagerId(),
                construction.getStructuralEngineerId(),
                construction.getProjectManagerId(),
                construction.getConstructor()
        );
    }

    // ConstructionResponse to Construction
    public static Construction mapConstructionResponseToConstruction(ConstructionResponse constructionResponse) {
        return new Construction(
                null,
                constructionResponse.getName(),
                constructionResponse.getAddress(),
                constructionResponse.getStartDate(),
                constructionResponse.getEndDate(),
                constructionResponse.getNumberOfBasements(),
                constructionResponse.getNumberOfFloors(),
                constructionResponse.getEstimatedCost(),
                constructionResponse.getSiteManagerId(),
                constructionResponse.getStructuralEngineerId(),
                constructionResponse.getProjectManagerId(),
                constructionResponse.getConstructor()
        );
    }

    //ConstructionRequest to Construction
    public static Construction mapConstructionRequestToConstruction(ConstructionRequest constructionRequest) {
        return new Construction(
                null,
                constructionRequest.getName(),
                constructionRequest.getAddress(),
                constructionRequest.getStartDate(),
                constructionRequest.getEndDate(),
                constructionRequest.getNumberOfBasements(),
                constructionRequest.getNumberOfFloors(),
                constructionRequest.getEstimatedCost(),
                constructionRequest.getSiteManagerId(),
                constructionRequest.getStructuralEngineerId(),
                constructionRequest.getProjectManagerId(),
                constructionRequest.getConstructor()
        );
    }
}
