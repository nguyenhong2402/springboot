package vn.su.lab02.controller;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.su.lab02.model.Job;
import vn.su.lab02.model.JobRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/")
public class HomeController {
    private ConcurrentHashMap<String, Job> jobs;

    public HomeController() {
        jobs = new ConcurrentHashMap<>();

        jobs.put("1", new Job("1", "Thực Tập Sinh IT - Helpdesk", "Nhân viên chính thức IT help desk", "Hanoi",
                3000000, 15000000, "phuongchi3123@gmail.com"));
        jobs.put("2",
                new Job("2", "Thực Tập Sinh IT (Có Lương)",
                        "Tham gia nghiên cứu các frameworks, kiến trúc hệ thống phần mềm.", "HaiPhong",
                        4000000, 10000000, "ascomvietnam@gmail.com"));
    }

    @GetMapping("/job")
    public List<Job> getAll() {
        return jobs.values().stream().toList();
    }

    @PostMapping(value = "job")
    public Job createJob(@RequestBody JobRequest jobRequest) {
        String uuid = UUID.randomUUID().toString();
        Job newJob = new Job(uuid, jobRequest.title(), jobRequest.description(), jobRequest.location(),
                jobRequest.min_salary(), jobRequest.max_salary(), jobRequest.email());
        jobs.put(uuid, newJob);
        return newJob;
    }

    @PutMapping("/job/{id}")
    public Job updateJob(@PathVariable("id") String id, @RequestBody JobRequest jobRequest) {
        Job updateJob = new Job(id, jobRequest.title(), jobRequest.description(), jobRequest.location(),
                jobRequest.min_salary(), jobRequest.max_salary(), jobRequest.email());
        jobs.replace(id, updateJob);
        return updateJob;
    }

    @DeleteMapping("/job/{id}")
    public Job deleteJob(@PathVariable String id) {
        Job deleteJob = jobs.remove(id);
        return deleteJob;
    }

    @GetMapping("/job/sortbylocation")
    public List<Job> sortListJobbyLocation() {
        // List<Job> listSort = jobs.values().stream().toList();
        // listSort.sort(Comparator.comparing(Job::getLocation)); ///Code lỗiii
        // return listSort;
        return jobs.values().stream().sorted(Comparator.comparing(Job::getLocation)).collect(Collectors.toList());
    }

    @GetMapping("/job/salary/{salary}")
    public List<Job> getJobbySalary(@PathVariable("salary") int salary) {
        List<Job> jobList = jobs.values().stream().toList();
        List<Job> newJob = new ArrayList<>();
        jobList.forEach((job) -> {
            if (salary >= job.getMin_salary() && salary <= job.getMax_salary()) {
                newJob.add(job);
            }
        });
        return newJob;
    }
    @GetMapping("/job/keyword/{keyword}")
    public List<Job> getJobbytitleordescription(@PathVariable("keyword") String keyword) {
        List<Job> jobList = jobs.values().stream().toList();
        List<Job> newJob = new ArrayList<>();
        jobList.forEach((job) -> {
            if (job.getDescription().toLowerCase().contains(keyword.toLowerCase())
                    || job.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                newJob.add(job);
            }
        });
        return newJob;

    }
    @GetMapping("/job/query")
    public List<Job> getJobbyLocation_description_title(@RequestParam("location") String location,
            @RequestParam("keyword") String keyword) {
        List<Job> jobList = jobs.values().stream().toList();
        List<Job> newJob = new ArrayList<>();
        jobList.forEach((job) -> {
            if (job.getDescription().toLowerCase().contains(keyword.toLowerCase())
                    || job.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                if (location.toLowerCase().equals(job.getLocation().toLowerCase())) {
                    newJob.add(job);
                }
            }
        });
        return newJob;
    }
}
