package com.sih.springproject.repository;



import com.sih.springproject.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
public interface StudentRepository extends JpaRepository<Student,Long> {
}
