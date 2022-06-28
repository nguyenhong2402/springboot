package vn.techmaster.jpamanytomanysimple.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String name;

@ManyToMany(cascade = CascadeType.ALL)
@JsonManagedReference
@JoinTable(name= "course_like", joinColumns = @JoinColumn(name ="student_id"), inverseJoinColumns = @JoinColumn(name ="course_id"))
private Set<Course> likedCourses;

public Student(String name) {
    this.name = name;
}
}
