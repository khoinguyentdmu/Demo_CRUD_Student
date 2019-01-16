package com.example.service.impl;

import com.example.exception.StudentNotFoundException;
import com.example.model.Student;
import com.example.repository.IStudentRepository;
import com.example.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    IStudentRepository studentRepository;

    /**
     * Get all students
     * @return
     */
    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }

    /**
     * Get student by id
     * @param id
     * @return
     */
    public Student getStudentById(Integer id) {

        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }

    /**
     * Create a student
     * @param student
     * @return
     */
    public ResponseEntity<Object> createStudent(Student student) {

        Student savedStudent = studentRepository.save(student);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedStudent.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    /**
     * Update a student
     * @param student
     * @param id
     * @return
     */
    public ResponseEntity<Object> updateStudent(Student student, Integer id) {

        Optional<Student> studentOptional = studentRepository.findById(id);

        if (!studentOptional.isPresent())
            return ResponseEntity.notFound().build();

        student.setId(id);

        studentRepository.save(student);

        return ResponseEntity.noContent().build();
    }

    /**
     * Delete a student
     * @param id
     */
    public void deleteStudent(Integer id){

        studentRepository.deleteById(id);
    }
}
