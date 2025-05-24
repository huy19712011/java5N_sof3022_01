package org.example.java5n_sof3022_01.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "students")
public class Student {

    @Id
    private Long id;

    @Size(min = 2, max = 20, message = "Name must be between 2 and 20 characters")
    private String name;

    //@Email(message = "Please enter a valid email address")
    @Pattern(regexp = "^(.+)@(.+)$", message = "Invalid email address")
    private String email;

    @Pattern(regexp = "^(0)\\d{9}$", message = "Invalid phone number")
    private String phone;
}
