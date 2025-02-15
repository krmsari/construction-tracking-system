package com.kerem.constructionmanagementservice.dao;

import com.kerem.constructionmanagementservice.entity.Construction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ConstructionRepository extends JpaRepository<Construction, UUID> {

    Optional<Construction> findByName(String name);

}
