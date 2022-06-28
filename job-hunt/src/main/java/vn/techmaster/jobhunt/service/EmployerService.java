package vn.techmaster.jobhunt.service;

import java.util.List;



import vn.techmaster.jobhunt.dto.EmployerRequest;
import vn.techmaster.jobhunt.model.Employer;

public interface EmployerService {
    List<Employer> getAllEmployers();
    Employer getEmployerById(String employerId);
    List<Employer> getEmployersByName(String employerName);

    Employer addEmployer(EmployerRequest employerRequest);
    Employer updateEmployer(Employer employer);
    void delete(String employerId);
    void edit(EmployerRequest employerRequest);
    
    EmployerRequest getByIdEmployerRequest(Employer employerById);
   
   

}
