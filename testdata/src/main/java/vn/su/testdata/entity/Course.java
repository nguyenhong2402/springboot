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

@Entity(name = "course")
@Table(name = "course")
@Data
@NoArgsConstructor
public class Course {
    @Id 
    private Long id;
    private String name;

    @OneToMany(mappedBy="course", fetch = FetchType.LAZY)
    List<CourseRating> courseRatingkey = new ArrayList<>();
}
