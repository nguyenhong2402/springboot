package vn.techmaster.fileupload.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Size(min = 5, max = 30, message = "Name must between 5 and 30")
    private String name;

    @NotBlank(message = "Email cannot null")
    @Email(message =  "Not valid email")
    private String email;

    private MultipartFile photo;
}
