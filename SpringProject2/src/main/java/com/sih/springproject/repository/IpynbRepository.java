package com.sih.springproject.repository;


import com.sih.springproject.model.Comment;
import com.sih.springproject.model.Ipynb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IpynbRepository extends JpaRepository<Ipynb,Long> {
}
