package vn.su.labthymlf.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

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
