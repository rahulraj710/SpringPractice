package org.example.repository;

import org.example.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    public Student getStudent(int id);
    public List<Student> getStudents(Optional<Integer> age);
    public void addStudent(Student student);
    public void updateStudent(Student student);
    public void deleteStudent(int id);
}
