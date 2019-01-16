package com.example.controller;

import java.util.List;

import com.example.model.Student;
import com.example.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
filter, paging, multi table, slide report, DTO & DAO
 */
@RestController
@RequestMapping( "/Student" )
public class StudentController {

    @Autowired
    private IStudentService StudentService;

    /**
     * Get all students
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Student> getAllStudents() {

        return StudentService.getAllStudents();
    }

    /**
     * Get student by id
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student getStudent(@PathVariable Integer id) {

        return StudentService.getStudentById(id);
    }

    /**
     * Create a student
     * @param student
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Object> createStudent(@RequestBody Student student) {

        return StudentService.createStudent(student);
    }

    /**
     * Update a student
     * @param student
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateStudent(@RequestBody Student student, @PathVariable Integer id) {

        return StudentService.updateStudent(student, id);
    }

    /**
     * Delete a student
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable Integer id) {

        StudentService.deleteStudent(id);
    }
}