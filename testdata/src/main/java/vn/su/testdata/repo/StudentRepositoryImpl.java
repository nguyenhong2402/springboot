package vn.su.testdata.repo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import vn.su.testdata.entity.Course;
import vn.su.testdata.entity.CourseRating;
import vn.su.testdata.entity.Student;

public class StudentRepositoryImpl implements StudentRepositoryCustom {

    @Autowired
    @Lazy
    StudentRepository studentRepository;

    @Autowired
    @Lazy
    CourseRepository courseRepository;

    @Override
    public Map<String, List<Student>> findListStudentByCourse() {
        List<Course> listCourse = courseRepository.findAll();
        Map<String, List<Student>> map = new HashMap<>();
        List<Student> stu = new ArrayList<>();
        for (Course course : listCourse) {
            List<CourseRating> listCourseRating = course.getCourseRatingkey();
            for (CourseRating cr : listCourseRating) {
                stu.add(cr.getStudent());
            }
            map.put(course.getName(), stu);
        }
        return map;
    }
   

}
