package vn.su.testdata.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.su.testdata.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
