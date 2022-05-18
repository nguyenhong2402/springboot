package vn.su.lab_thymeleaf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    private String title;
    private String nameCompany;
    private String nominee;
    private String address;
}
