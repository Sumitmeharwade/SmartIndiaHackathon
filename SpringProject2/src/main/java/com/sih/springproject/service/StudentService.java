package com.sih.springproject.service;



import com.sih.springproject.model.Student;
import com.sih.springproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student addCustomer(Student student)
    {
        return studentRepository.save(student);
    }

    public Student modifyCustomer(Student student)
    {
        return studentRepository.save(student);
    }

    public Student deleteCustomer(Student student)
    {
        Student ad=studentRepository.findById(student.getUserId()).get();
        studentRepository.delete(student);
        return ad;
    }

    public Student findCustomer(Long id)
    {
        return studentRepository.findById(id).get();
    }

    public List<Student> findAll()
    {
        return studentRepository.findAll();
    }
}

