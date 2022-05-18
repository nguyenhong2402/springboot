package vn.su.lab_thymeleaf.repository;

import java.util.concurrent.ConcurrentHashMap;


import org.springframework.stereotype.Repository;

import lombok.Getter;
import vn.su.lab_thymeleaf.model.Job;

@Getter
@Repository
public class JobRepository {
    ConcurrentHashMap<String, Job> jobs;

    public JobRepository() {
        jobs = new ConcurrentHashMap<>();
        jobs.put("FPT", new Job( "Tuyển lập trình viên frontend", "FPT", "FE","Hà Nội"));
        jobs.put("Viettel", new Job( "Tuyển lập trình viên Java", "Viettel","Tester", "Hà Nội"));
        jobs.put("Zalo", new Job( "Tuyển lập trình viên Python", "Zalo","AI", "HCM"));
        jobs.put("Techmaster", new Job( "Tuyển giáo viên dạy lập trình", "Techmaster","Giáo viên", "Hà Nội"));
    }
}
