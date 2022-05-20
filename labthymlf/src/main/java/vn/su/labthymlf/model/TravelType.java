package vn.su.labthymlf.model;


public enum TravelType {
    BASIC("basic"),
    ECONOMY("economy"),
    LUXURY("luxury"),
    PREMIUM("Premium");
    
    private String value;

    private TravelType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    
}
