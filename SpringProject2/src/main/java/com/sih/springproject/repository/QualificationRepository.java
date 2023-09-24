package com.sih.springproject.repository;


import com.sih.springproject.model.Comment;
import com.sih.springproject.model.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualificationRepository extends JpaRepository<Qualification,Long> {
}
