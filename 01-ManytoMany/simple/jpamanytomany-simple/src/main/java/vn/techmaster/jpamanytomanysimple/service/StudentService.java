package vn.techmaster.jpamanytomanysimple.service;



import vn.techmaster.jpamanytomanysimple.model.Student;


public interface StudentService {
    Student save(Student student);

    Student findById(Long id);
}
