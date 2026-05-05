package com.project.organix.repository;

import com.project.organix.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Kosong saja, Spring Boot sudah otomatis membuatkan fungsi CRUD-nya
}