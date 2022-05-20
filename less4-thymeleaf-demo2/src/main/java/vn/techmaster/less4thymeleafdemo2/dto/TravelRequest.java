package vn.techmaster.less4thymeleafdemo2.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import vn.techmaster.less4thymeleafdemo2.model.TravelType;

@Data
@AllArgsConstructor
public class TravelRequest {
    private String nationality;
    private List<String> visitedCountries;
    private TravelType travelType;
    public TravelRequest() {
        visitedCountries = new ArrayList<>();
        travelType = TravelType.BASIC;
    }
}
