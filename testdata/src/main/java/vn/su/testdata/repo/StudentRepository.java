package vn.su.testdata.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.su.testdata.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>, StudentRepositoryCustom {
    
}
