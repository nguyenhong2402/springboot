package vn.techmaster.jobhunt.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class EmployerRequest {
    private String id;
    @NotBlank(message= "{employer.name.notblank}")
    private String name;
    @NotBlank(message= "{employer.website.notblank}")
    private String website;
    @NotBlank(message= "{employer.email.notblank}")
    @Email
    private String email;
    private MultipartFile logo;
}
