package vn.su.less1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.su.less1.model.BMI;
import vn.su.less1.model.Student;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/")
public class Exercise {
    public Exercise() {
        student.add(new Student(1, "Hong", "Lớp 12"));
        student.add(new Student(2, "Su", "Lớp 11"));
        student.add(new Student(3, "Chien", "Lớp 10"));
    }
    List<Student> student = new ArrayList<Student>();
    Random rd = new Random();
    @GetMapping("/random")
    public String random() {
        final String alpha = "abcdefghijklmnopqrstuvwxyz";
        final String alphaUppercase = alpha.toUpperCase();
        final String digits = "0123456789";
        int numberChar = 8;
        
        String totalChar = alpha + alphaUppercase + digits;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < numberChar; i++) {
            int index = rd.nextInt(totalChar.length() - 1);
            str = str.append(totalChar.charAt(index));
        }
        return str.toString();
    }
    @GetMapping("/quote")
    public String quote() {
        List<String> repoQuote = new ArrayList<>(Arrays.asList("Kiến tha lâu đầy tổ",
                "Có công mài sắt, có ngày nên kim", "Không thầy đố mày làm nên", "Học thầy không tày học bạn"));
        int index = rd.nextInt(4);
        return repoQuote.get(index);
    }
    @PostMapping(value="/bmi")
    public double createCountBMI(@RequestBody BMI bmi) {

        double bmiValue = bmi.getWeight() / (bmi.getHeight() * bmi.getHeight());
        return bmiValue;
    }
    @GetMapping("/student")
    public List<Student> getAllstudent() {
        return student.stream().toList();
}
@PostMapping("/student")
public List<Student> createStudent(@RequestBody Student newStudent) {
    student.add(newStudent);
    return student;
        
    }
}
