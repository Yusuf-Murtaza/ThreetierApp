package com.example.threetier.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "files")
public class FilesEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private Integer year;

  @Column(name = "pligtigNummer", nullable = false)
  private Integer pligtigNummer;

  @Column(nullable = false)
  private String file;

  public FilesEntity() {
  }

  // Getters and setters

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public Integer getPligtigNummer() {
    return pligtigNummer;
  }

  public void setPligtigNummer(Integer pligtigNummer) {
    this.pligtigNummer = pligtigNummer;
  }

  public String getFile() {
    return file;
  }

  public void setFile(String file) {
    this.file = file;
  }
}

