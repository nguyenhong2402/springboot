package vn.techmaster.less4thymeleafdemo2.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private String nationality;
    private Date birthDay;
    private String gender;
}
