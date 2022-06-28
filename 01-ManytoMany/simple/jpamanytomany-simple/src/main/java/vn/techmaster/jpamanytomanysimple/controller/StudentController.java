package vn.techmaster.jpamanytomanysimple.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import vn.techmaster.jpamanytomanysimple.model.Course;
import vn.techmaster.jpamanytomanysimple.model.Student;
import vn.techmaster.jpamanytomanysimple.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;




@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentService.findById(id);
    }
    @PostMapping(value="/student")
    public Student registerStudent() {
        Course courseA = new Course("Couse A");
        Course courseB = new Course("Couse B");
        
        Set<Course> courses = new HashSet<>(Arrays.asList(courseA, courseB));
        Student student = new Student("Jack");
        student.setLikedCourses(courses);
        return studentService.save(student);
    }
    
}
