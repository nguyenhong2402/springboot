package vn.su.testdata.repo;

import java.util.List;
import java.util.Map;

import vn.su.testdata.entity.Student;

public interface StudentRepositoryCustom {
    Map<String, List<Student>> findListStudentByCourse();
}
