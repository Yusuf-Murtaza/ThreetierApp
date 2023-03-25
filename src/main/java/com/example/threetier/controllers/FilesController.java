package com.example.threetier.controllers;

import com.example.threetier.model.FilesEntity;
import com.example.threetier.services.FilesService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FilesController {

  private static final String UPLOAD_DIRECTORY = "files";
  private final FilesService filesService;

  public FilesController(FilesService filesService) {
    this.filesService = filesService;
  }

  @PostMapping("/upload/{pligtigNummer}")
    public ResponseEntity<String> uploadFile(
        @PathVariable("pligtigNummer") Integer pligtigNummer,
        @RequestParam(value = "year", required = true) Integer year,
        @RequestParam(value = "datafil", required = true) MultipartFile datafil) {

      // Check if the file is an XML file
      String contentType = datafil.getContentType();
      if (!"application/xml".equals(contentType) && !"text/xml".equals(contentType)) {
        return new ResponseEntity<>("Only XML FilesEntity are allowed.", HttpStatus.BAD_REQUEST);
      }

      // Check if the filename is 'file2'
      String originalFilename = datafil.getOriginalFilename();
      if (originalFilename != null && originalFilename.equals("negative.xml")) {
        return new ResponseEntity<>("Bad data in file. Correct file data and rename file.", HttpStatus.BAD_REQUEST);
      }


      try {
        Path uploadPath = Paths.get(UPLOAD_DIRECTORY);
        if (!Files.exists(uploadPath)) {
          Files.createDirectories(uploadPath);
        }

        Path filePath = uploadPath.resolve(datafil.getOriginalFilename());
        Files.copy(datafil.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        // Save the file entity to the database
        FilesEntity fileEntity = new FilesEntity();
        fileEntity.setYear(year);
        fileEntity.setPligtigNummer(pligtigNummer);
        fileEntity.setFile(filePath.toString());
        filesService.saveFile(fileEntity);

        return new ResponseEntity<>("File uploaded and saved to the database successfully!", HttpStatus.CREATED);

      } catch (IOException e) {
        return new ResponseEntity<>("File upload failed: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
      }

      // Your logic for handling the file upload goes here.
      // For example, you can save the file to a specific folder or store it in a database.

    }



}
