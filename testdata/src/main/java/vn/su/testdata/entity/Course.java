package vn.su.testdata.entity;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "course")
@Table(name = "course")
@Data
@NoArgsConstructor
@ToString(exclude ="courseRatingkey")
public class Course {
    @Id 
    private Long id;
    private String name;

    @OneToMany(mappedBy="course", fetch = FetchType.LAZY)
    List<CourseRating> courseRatingkey = new ArrayList<>();
}
