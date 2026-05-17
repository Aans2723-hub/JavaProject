package com.project.organix.repository;

import com.project.organix.model.RewardItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardItemRepository extends JpaRepository<RewardItem, Long> {
    // Kosongkan saja, Spring Boot akan mengurus fungsi CRUD-nya otomatis
}