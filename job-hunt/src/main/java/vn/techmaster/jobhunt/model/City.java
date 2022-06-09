package vn.techmaster.jobhunt.model;

public enum City {
    HANOI("Hà Nội"),
    HOCHIMINH("Hồ Chí Minh"),
    DANANG("Đà Nẵng"),
    HAIPHONG("Hải Phòng");

    public final String label;
    private City(String label) {
        this.label = label;
    }
}
