package com.example.service;

import com.example.model.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IStudentService {

    //Get all students
    public List<Student> getAllStudents();

    //Get student by id
    public Student getStudentById(Integer id);

    //Create a student
    public ResponseEntity<Object> createStudent(Student student);

    //Update a student
    public ResponseEntity<Object> updateStudent(Student student, Integer id);

    //Delete a student
    public void deleteStudent(Integer id);
}
