package com.sih.springproject.controller;


import com.sih.springproject.model.Student;
import com.sih.springproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sih.springproject.commons.Constants.crossOrigins;


@CrossOrigin(origins = crossOrigins)
@RestController
@RequestMapping("/Student")

public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student)
    {
        return studentService.addStudent(student);
    }
    @GetMapping("/get/{customerId}")
    public Student getStudentById(@PathVariable Long studentId)
    {
        return studentService.findStudent(studentId);
    }
    @GetMapping("/getall")
    public List<Student> getAllStudent(){
        return studentService.findAll();
    }
}
