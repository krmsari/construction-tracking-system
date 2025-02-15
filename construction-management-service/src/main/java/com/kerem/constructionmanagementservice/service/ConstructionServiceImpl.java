package com.kerem.constructionmanagementservice.service;

import com.kerem.constructionmanagementservice.client.AuthServiceClient;
import com.kerem.constructionmanagementservice.dao.ConstructionRepository;
import com.kerem.constructionmanagementservice.dto.construction.request.ConstructionRequest;
import com.kerem.constructionmanagementservice.dto.construction.response.ConstructionResponse;
import com.kerem.constructionmanagementservice.dto.user.UserDTO;
import com.kerem.constructionmanagementservice.entity.Construction;
import com.kerem.constructionmanagementservice.service.abstracts.ConstructionService;
import org.springframework.stereotype.Service;
import com.kerem.constructionmanagementservice.util.Mapper;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ConstructionServiceImpl implements ConstructionService {

    private final AuthServiceClient authServiceClient;
    private final ConstructionRepository constructionRepository;

    public ConstructionServiceImpl(AuthServiceClient authServiceClient, ConstructionRepository constructionRepository) {
        this.authServiceClient = authServiceClient;
        this.constructionRepository = constructionRepository;
    }

    @Override
    public ConstructionResponse createConstruction(ConstructionRequest request) {
        Construction construction = Mapper.mapConstructionRequestToConstruction(request);
        UserDTO user = authServiceClient.getUserById(request.getSiteManagerId());
        System.out.println("user = " + user);
        constructionRepository.save(construction);
        return Mapper.mapConstructionToConstructionResponse(construction);
    }

    @Override//UPDATE
    public ConstructionResponse updateConstruction(ConstructionRequest request, String name) {
        Construction construction = constructionRepository.findByName(name).orElseThrow(() -> new RuntimeException("Construction not found"));
        construction.setName(request.getName());
        construction.setAddress(request.getAddress());
        construction.setStartDate(request.getStartDate());
        construction.setEndDate(request.getEndDate());
        construction.setNumberOfBasements(request.getNumberOfBasements());
        construction.setNumberOfFloors(request.getNumberOfFloors());
        construction.setEstimatedCost(request.getEstimatedCost());
        construction.setSiteManagerId(request.getSiteManagerId());
        construction.setStructuralEngineerId(request.getStructuralEngineerId());
        construction.setProjectManagerId(request.getProjectManagerId());
        construction.setConstructor(request.getConstructor());
        constructionRepository.save(construction);
        return Mapper.mapConstructionToConstructionResponse(construction);
    }

    @Override
    public ConstructionResponse deleteConstruction(String name) {
        Construction construction = constructionRepository.findByName(name).orElseThrow(() -> new RuntimeException("Construction not found"));
        constructionRepository.delete(construction);
        return Mapper.mapConstructionToConstructionResponse(construction);
    }

    @Override
    public ConstructionResponse getConstructionName(String name) {
        Construction construction = constructionRepository.findByName(name).orElseThrow(() -> new RuntimeException("Construction not found"));

        return Mapper.mapConstructionToConstructionResponse(construction);
    }

    @Override
    public List<ConstructionResponse> getAllConstructions() {
        List<Construction> constructionList = constructionRepository.findAll();

        return constructionList.stream()
                .map(Mapper::mapConstructionToConstructionResponse)
                .toList();
    }


}
