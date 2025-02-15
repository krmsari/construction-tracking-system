package com.kerem.constructionmanagementservice.service.abstracts;

import com.kerem.constructionmanagementservice.dto.construction.request.ConstructionRequest;
import com.kerem.constructionmanagementservice.dto.construction.response.ConstructionResponse;

import java.util.List;

public interface ConstructionService {

    public ConstructionResponse createConstruction(ConstructionRequest request);
    public ConstructionResponse updateConstruction(ConstructionRequest request,String name);
    public ConstructionResponse deleteConstruction(String name);
    public ConstructionResponse getConstructionName(String name);
    public List<ConstructionResponse> getAllConstructions();
}
