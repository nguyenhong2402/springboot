package vn.techmaster.less4thymeleafdemo2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true, setterPrefix = "with")
public class BMIResult {
    private float bmiIndex;
    private String category;
    private String recommendation;
}
