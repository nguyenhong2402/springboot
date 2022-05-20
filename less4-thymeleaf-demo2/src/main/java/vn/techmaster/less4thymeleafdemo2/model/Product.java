package vn.techmaster.less4thymeleafdemo2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private String name;
    private String manufacture;
    private int price;
}
