package kz.lab9.controllers;

import kz.lab9.models.Book;
import kz.lab9.repositories.BookRepository;
import kz.lab9.models.Student;
import kz.lab9.repositories.CourseRepository;
import kz.lab9.repositories.StudentRepository;
import kz.lab9.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    @PostMapping
    public Course createSubject(@RequestBody Course course) {
        return courseRepository.save(course);
    }

    @PutMapping("/{courseId}/students/{studentId}")
    public Course addStudentToCourse(
            @PathVariable Long courseId,
            @PathVariable Long studentId
    ) {
        Course course = courseRepository.findById(courseId).get();
        Student student = studentRepository.findById(studentId).get();

        course.getEnrolledStudents().add(student);
        return courseRepository.save(course);
    }

    @PutMapping("/{courseId}/book/{bookId}")
    public Course assignTeacherToSubject(
            @PathVariable Long courseId,
            @PathVariable Long bookId
    ) {
        Course course = courseRepository.findById(courseId).get();
        Book book = bookRepository.findById(bookId).get();

        course.setBook(book);
        return courseRepository.save(course);
    }
}
