package vn.techmaster.less4thymeleafdemo2.model;

public enum TravelType {
    BASIC("Basic"),
    ECONOMY("Economy"),
    LUXURY("Luxury"),
    PREMIUM("Premium");

    private String value;

    private TravelType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
      }
}
