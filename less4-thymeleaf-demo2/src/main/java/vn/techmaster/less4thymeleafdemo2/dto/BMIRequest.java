package vn.techmaster.less4thymeleafdemo2.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BMIRequest {
    @NotEmpty(message = "{empty.name}")
    private String name;
    @NotEmpty
    @Email
    private String email;
    @Positive
    private float height;
    @Positive
    private float weight;
}
