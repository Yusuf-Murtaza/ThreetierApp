package com.example.threetier.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
  private Long id;
  private String name;
  private String email;

  public User() {

  }
  public User(String name, String email) {
    this.name = name;
    this.email = email;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  @Column(name = "name", nullable = false)
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }


  @Column(name = "email", nullable = true)
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", firstName=" + name + ", emailId=" + email
        + "]";
  }

}