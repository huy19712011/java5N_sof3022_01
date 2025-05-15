package org.example.java5n_sof3022_01.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.example.java5n_sof3022_01.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StudentRepository {

    private final EntityManager entityManager;

    public List<Student> getAllStudents() {

        return entityManager.createQuery("from Student", Student.class).getResultList();
    }
}
