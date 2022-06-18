package vn.su.testdata.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.su.testdata.entity.Course;
import vn.su.testdata.entity.CourseRating;
import vn.su.testdata.entity.CourseRatingkey;
import vn.su.testdata.entity.Student;
import vn.su.testdata.repo.CourseRatingRepository;
import vn.su.testdata.repo.CourseRepository;
import vn.su.testdata.repo.StudentRepository;


@Service
public class TService {
    @Autowired
    CourseRatingRepository courseRatingRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    public CourseRating addResult(Long sid, Long cid, int rating) {
        
        Student stu = findStudentById(sid);
        Course cour = findCourseById(cid);
        CourseRatingkey courseRatingkey = new CourseRatingkey(cour.getId(), stu.getId());
        CourseRating courseRating = new CourseRating(courseRatingkey, stu, cour, rating);
        return courseRatingRepository.save(courseRating);
    }

    public Student findStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
    
    public Course findCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public Map<String, List<Student>> findListStudentByCourse() {
        return studentRepository.findListStudentByCourse();
    }
}
