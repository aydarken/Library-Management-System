package kz.lab9;

import kz.lab9.config.SpringConfig;
import kz.lab9.controllers.BookController;
import kz.lab9.controllers.CourseController;
import kz.lab9.controllers.StudentController;
import kz.lab9.models.Book;
import kz.lab9.models.Course;
import kz.lab9.models.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        BookController bookController =context.getBean("bookController", BookController.class);
        CourseController courseController = context.getBean("courseController", CourseController.class);
        StudentController studentController = context.getBean("studentController", StudentController.class);


        Book book = new Book();
        Student student = new Student();
        Course course = new Course();

        course.setId(1L);
        course.setBook(book);
        course.setName("testCourse");
        course.setEnrolledStudents(new HashSet<>());

        student.setId(1L);
        student.setName("testStudent");
        student.setCourses(new HashSet<>());

        book.setId(1L);
        book.setTitle("testBook");
        book.setCourse(student.getCourses());

        bookController.createBook(book);
        System.out.println(bookController.getBooks());

        studentController.createStudent(student);
        System.out.println(studentController.getStudents());

        courseController.createSubject(course);
        courseController.addStudentToCourse(1L,1L);
        courseController.assignTeacherToSubject(1L,1L);
        System.out.println(courseController.getCourses());

    }
}
