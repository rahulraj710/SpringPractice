package org.example.service;

import jakarta.transaction.Transactional;
import org.example.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public List<Student> getStudents(Optional<Integer> age);
    public Student getStudentById(int id);
    public void addStudent(Student student);
    public void updateStudent(Student student);
    public void deleteStudent(int id);
}
