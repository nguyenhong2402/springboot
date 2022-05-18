package vn.su.lab_thymeleaf.repository;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import vn.su.lab_thymeleaf.model.Employer;

@Getter
@Repository
public class EmployerRepository {
    ConcurrentHashMap<String, Employer> employers;

    public EmployerRepository() {
        employers = new ConcurrentHashMap<>();
        employers.put("Công ty FSoft", new Employer( "Công ty FSoft", "Outsource", "Hà Nội"));
        employers.put("Công ty Viettel", new Employer( "Công ty Viettel", "Product", "Hà Nội"));
        employers.put("Công ty VNG", new Employer( "Công ty VNG", "Outsource", "Hà Nội"));
        employers.put("Công ty VNPT", new Employer( "Công ty VNPT", "Product", "Hà Nội"));
        employers.put("Công ty Techmaster", new Employer( "Công ty Techmaster", "Product", "Hà Nội"));
    }
}
