package org.example.service;

import jakarta.transaction.Transactional;
import org.example.entity.Student;
import org.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional
    public List<Student> getStudents(Optional<Integer> age) {
        return studentRepository.getStudents(age);
    }

    @Override
    @Transactional
    public Student getStudentById(int id) {
        return studentRepository.getStudent(id);
    }
    @Override
    @Transactional
    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }
    @Override
    @Transactional
    public void updateStudent(Student student) {
        studentRepository.updateStudent(student);
    }
    @Override
    @Transactional
    public void deleteStudent(int id) {
        studentRepository.deleteStudent(id);
    }
}
