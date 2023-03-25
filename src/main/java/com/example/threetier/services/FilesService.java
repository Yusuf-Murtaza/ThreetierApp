package com.example.threetier.services;


import com.example.threetier.model.FilesEntity;
import com.example.threetier.repository.FilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilesService {

  private final FilesRepository filesRepository;

  public FilesService(FilesRepository filesRepository) {
    this.filesRepository = filesRepository;
  }

  // Save a FilesEntity entity
  public FilesEntity saveFile(FilesEntity file) {
    return filesRepository.save(file);
  }

  // Update a FilesEntity entity
  public FilesEntity updateFile(FilesEntity file) {
    return filesRepository.save(file);
  }

  // Delete a FilesEntity entity by id
  public void deleteFile(Long id) {
    filesRepository.deleteById(id);
  }

  // Find a FilesEntity entity by id
  public Optional<FilesEntity> findFileById(Long id) {
    return filesRepository.findById(id);
  }

  // Get all FilesEntity entities
  public List<FilesEntity> findAllFiles() {
    return filesRepository.findAll();
  }
}
