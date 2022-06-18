package vn.su.testdata.repo;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import vn.su.testdata.entity.Course;
import vn.su.testdata.entity.CourseRating;
import vn.su.testdata.entity.Student;

public class StudentRepositoryCustomImpl implements StudentRepositoryCustom {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CourseRatingRepository courseRatingRepository;
    @Override
    public Map<String, List<Student>> findListStudentByCourse() {
        
        Map<Course, List<CourseRating>> a = courseRatingRepository.findAll().stream()
                .collect(Collectors.groupingBy(CourseRating::getCourse));
        Map<String, List<Student>> student = new HashMap<>();
        
        return null;
    }
    
}
