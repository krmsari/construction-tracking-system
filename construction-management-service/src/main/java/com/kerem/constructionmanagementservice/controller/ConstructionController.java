package com.kerem.constructionmanagementservice.controller;

import com.kerem.constructionmanagementservice.dto.construction.request.ConstructionRequest;
import com.kerem.constructionmanagementservice.dto.construction.response.ConstructionResponse;
import com.kerem.constructionmanagementservice.service.abstracts.ConstructionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/construction")
public class ConstructionController {

    private final ConstructionService constructionService;

    public ConstructionController(ConstructionService constructionService) {
        this.constructionService = constructionService;
    }

    @PostMapping("/create")
    public ResponseEntity<ConstructionResponse> createConstruction(@RequestBody ConstructionRequest request) {

        return new ResponseEntity<>(
                constructionService.createConstruction(request),
                HttpStatus.CREATED);
    }

    @PutMapping("/update/{name}")
    public ResponseEntity<ConstructionResponse> updateConstruction(@PathVariable String name, @RequestBody ConstructionRequest request) {

        return new ResponseEntity<>(
                constructionService.updateConstruction(request, name),
                HttpStatus.OK);
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<ConstructionResponse> deleteConstruction(@PathVariable String name) {

        return new ResponseEntity<>(
                constructionService.deleteConstruction(name),
                HttpStatus.NO_CONTENT);
    }

    @GetMapping("/get/{name}")
    public ConstructionResponse getConstruction(@PathVariable String name) {
        return new ResponseEntity<>(constructionService.getConstructionName(name), HttpStatus.OK).getBody();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ConstructionResponse>> getAllConstructions() {
        return new ResponseEntity<>(constructionService.getAllConstructions(), HttpStatus.OK);
    }

}
