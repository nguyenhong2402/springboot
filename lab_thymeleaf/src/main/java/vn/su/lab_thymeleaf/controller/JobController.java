package vn.su.lab_thymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import vn.su.lab_thymeleaf.model.Job;
import vn.su.lab_thymeleaf.repository.JobRepository;

@Controller
public class JobController {
    @Autowired
    private JobRepository jobrepo;

    @GetMapping("/getJob")
    public String getEmployer(Model model) {
        List<Job> listjob = jobrepo.getJobs().values().stream().toList();
        model.addAttribute("jobs", listjob);
        return "job";
    }

    @GetMapping("/addJob")
    public String getJobForm(Model model) {
        model.addAttribute("jobRequest", new Job());

        return "jobrequest";
    }

    @PostMapping("/addJob")
    public String addEmployer(@ModelAttribute Job job) {
        jobrepo.getJobs().put(job.getNameCompany(), job);
        return "success";
    }
}
