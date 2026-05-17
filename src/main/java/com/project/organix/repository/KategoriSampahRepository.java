package com.project.organix.repository;

import com.project.organix.model.KategoriSampah;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KategoriSampahRepository extends JpaRepository<KategoriSampah, Long> {
    // Biarkan kosong, Spring Boot akan otomatis membuatkan fungsi CRUD-nya
}