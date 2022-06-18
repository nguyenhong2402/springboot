package vn.su.testdata.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.su.testdata.entity.CourseRating;
import vn.su.testdata.entity.Student;
import vn.su.testdata.service.TService;

@RestController
@RequestMapping("/")
public class RatingController {
    @Autowired
    TService tService;

    @GetMapping
    public List<CourseRating> addRating() {
        tService.addResult(1L, 1L, 7);
        tService.addResult(1L, 2L, 5);
        tService.addResult(1L, 3L, 8);
        tService.addResult(2L, 1L, 8);
        tService.addResult(2L, 2L, 2);
        tService.addResult(2L, 3L, 9);
        tService.addResult(3L, 1L, 4);
        tService.addResult(3L, 3L, 10);
        tService.addResult(4L, 2L, 9);
        tService.addResult(4L, 3L, 8);
        tService.addResult(5L, 1L, 9);
        tService.addResult(5L, 2L, 7);
        tService.addResult(5L, 3L, 6);
        tService.addResult(6L, 1L, 10);
        tService.addResult(6L, 2L, 3);

        return tService.findStudentById(1L).getRatings();
    }
    @GetMapping("/api")
    public Map<String, List<Student>> findListStudentByCourse() {
        return tService.findListStudentByCourse();
    }
}
