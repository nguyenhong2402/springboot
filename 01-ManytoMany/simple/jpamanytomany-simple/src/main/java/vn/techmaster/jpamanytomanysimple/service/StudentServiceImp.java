package vn.techmaster.jpamanytomanysimple.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.techmaster.jpamanytomanysimple.model.Student;
import vn.techmaster.jpamanytomanysimple.repository.StudentRepository;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
        
    }

    @Override
    public Student findById(Long id) {

        return studentRepository.findById(id).orElse(null);
    }
    
}
