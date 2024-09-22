package com.SpringSecurity.Respositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringSecurity.Model.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{

	

}