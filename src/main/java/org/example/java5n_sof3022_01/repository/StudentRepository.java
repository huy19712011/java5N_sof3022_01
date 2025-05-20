package org.example.java5n_sof3022_01.repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.java5n_sof3022_01.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Transactional
public class StudentRepository {

    private final EntityManager entityManager;

    public List<Student> getAllStudents() {

        return entityManager.createQuery("from Student", Student.class).getResultList();
    }

    public void saveStudent(Student student) {

        entityManager.persist(student);
    }

    public void deleteStudentById(long id) {

        entityManager.remove(entityManager.find(Student.class, id));
    }
}
