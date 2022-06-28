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

@Entity(name = "student")
@Table(name = "student")
@Data
@NoArgsConstructor
@ToString(exclude = "ratings")
public class Student {
    @Id 
    private Long id;

    private String name;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    List<CourseRating> ratings = new ArrayList<>();

    
}
