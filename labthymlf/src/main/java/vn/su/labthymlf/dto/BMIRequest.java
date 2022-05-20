package vn.su.labthymlf.dto;

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
    @NotEmpty
    private String name;
    @Email
    private String email;
    @Positive
    private float height;
    @Positive
    private float weight;
}
