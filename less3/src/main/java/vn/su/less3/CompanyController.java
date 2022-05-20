package vn.su.less3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController

public class CompanyController {
    private Employee employee;

    public CompanyController(Employee employee){
        this.employee = employee;
    }
    @Override
    public String toString() {
        return "CompanyController [employee=]" + employee + "]";
    }
    @GetMapping("/")
    public String companyDetail() {
        return this.toString();
    }
    
}
