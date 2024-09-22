package com.SpringSecurity.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.SpringSecurity.Model.Student;
import com.SpringSecurity.Respositry.StudentRepository;

import jakarta.persistence.EntityNotFoundException;

@Component
public class StudentService {

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Student saveStudent(Student student) {
        // Encrypt the password before saving the student
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        return studentRepo.save(student);
    }

    public Student updateStudent(Student std, int id) {
        std.setRoll(id);
        // Encrypt the password before updating the student
        std.setPassword(passwordEncoder.encode(std.getPassword()));
        studentRepo.save(std);
        System.out.println("Student with id : " + id + " is updated successfully..");
        return std;
    }

    public List<Student> getAllStudentList() {
        return studentRepo.findAll();
    }

    public Student getStudent(int id) {
        return studentRepo.getById(id);
    }

    public void deleteStudent(int id) {
        studentRepo.deleteById(id);
    }

    public Student getStudentById(int id) {
        return studentRepo.findById(id).orElse(null);
                      
    }
}
