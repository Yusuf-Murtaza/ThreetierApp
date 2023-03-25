package com.example.threetier.repository;


import com.example.threetier.model.FilesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilesRepository extends JpaRepository<FilesEntity, Long> {
}
