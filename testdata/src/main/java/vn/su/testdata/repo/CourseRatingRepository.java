package vn.su.testdata.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.su.testdata.entity.CourseRating;
import vn.su.testdata.entity.CourseRatingkey;

@Repository
public interface CourseRatingRepository extends JpaRepository<CourseRating, CourseRatingkey> {
    

}
