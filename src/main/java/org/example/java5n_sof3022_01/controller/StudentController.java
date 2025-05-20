package org.example.java5n_sof3022_01.controller;

import lombok.RequiredArgsConstructor;
import org.example.java5n_sof3022_01.entity.Student;
import org.example.java5n_sof3022_01.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/students/showNewStudentForm")
    public String showNewStudentForm(Model model) {

        // create model attribute to bind form data
        Student student = new Student();
        model.addAttribute("student", student);

        return "views/new_student";
    }

    @PostMapping("/students/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student) {

        // save student to database
        studentService.saveStudent(student);

        return "redirect:/students";
    }

    @GetMapping("/students/deleteStudent/{id}")
    public String deleteStudent(@PathVariable("id") long id) {

        // delete student
        studentService.deleteStudentById(id);

        // show table
        return "redirect:/students";

    }


}


