package vn.su.testdata.entity;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseRating {
   

    @EmbeddedId
    private CourseRatingkey id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("studentId")
    @JsonIgnore
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("courseId")
    @JsonIgnore
    private Course course;

    @Min(0)
    @Max(10)
    private int rating;
    
}
