package kz.lab9.controllers;

import io.swagger.annotations.Api;
import kz.lab9.models.Student;
import kz.lab9.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@Api(value = "Student Controller class", description = "This class allows to interact with Student object")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @PutMapping
    public void updateStudent(@RequestBody Long id, Student newStudent) {
        studentRepository.findById(id)
                .map(student -> {
                    student.setName(newStudent.getName());
                    student.setCourses(newStudent.getCourses());
                    return student;
                })
                .orElseGet(() -> {
                    newStudent.setId(id);
                    return studentRepository.save(newStudent);
                });
    }

    @DeleteMapping
    public void deleteStudent(@RequestBody Long id) {
        studentRepository.deleteById(id);
    }
}