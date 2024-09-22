package com.SpringSecurity.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.SpringSecurity.Model.Student;
import com.SpringSecurity.Service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Allow both ADMIN and STUDENT roles to view the list of students
    @GetMapping("/students")
    @PreAuthorize("hasAnyRole('ADMIN', 'STUDENT')")
    public List<Student> getAllStudents() {
        return studentService.getAllStudentList();
    }
    
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'STUDENT')")
    public Student getStudent(@PathVariable int id) {
        return studentService.getStudentById(id);
    }


    // Allow only ADMIN role to save a new student
    @PostMapping("/students")
    @PreAuthorize("hasRole('ADMIN')")
    public Student save(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    // Allow only ADMIN role to update an existing student
    @PutMapping("/update/{roll}")
    @PreAuthorize("hasRole('ADMIN')")
    public Student update(@PathVariable("roll") int roll, @RequestBody Student student) {
        return studentService.updateStudent(student, roll);
    }

    // Allow only ADMIN role to delete a student
    @DeleteMapping("/students/{roll}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteStudent(@PathVariable int roll) {
        this.studentService.deleteStudent(roll);
    }
}
