package org.example.java5n_sof3022_01.controller;

import lombok.RequiredArgsConstructor;
import org.example.java5n_sof3022_01.entity.Student;
import org.example.java5n_sof3022_01.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public String listStudents(Model model) {
        // get all students
        List<Student> students = studentService.getAllStudents();

        // data => view
        model.addAttribute("students", students);

        // return view .html
        return "views/students";
    }
}


