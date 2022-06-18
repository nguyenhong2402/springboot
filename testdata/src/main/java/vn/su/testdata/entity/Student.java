package vn.su.testdata.entity;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "student")
@Table(name = "student")
@Data
@NoArgsConstructor
public class Student {
    @Id 
    private Long id;

    private String name;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    List<CourseRating> ratings = new ArrayList<>();

    
}
