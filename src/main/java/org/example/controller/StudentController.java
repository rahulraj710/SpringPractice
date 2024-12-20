package org.example.controller;

import org.example.entity.Student;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> getStudents(@RequestParam(value = "age", required = false) Integer age){
        List<Student> students = studentService.getStudents(Optional.ofNullable(age));
        System.out.println(students.size());
        return studentService.getStudents(Optional.ofNullable(age));
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }

    @PostMapping("/students")
    public ResponseEntity<String> saveStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return new ResponseEntity<>("Student created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable int id, @RequestBody Student student) {
        student.setId(id); // Set the ID to the existing student ID
        studentService.updateStudent(student);
        return new ResponseEntity<>("Student updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
    }
}
