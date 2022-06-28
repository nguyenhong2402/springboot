package vn.techmaster.jpamanytomanysimple.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.techmaster.jpamanytomanysimple.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
}
