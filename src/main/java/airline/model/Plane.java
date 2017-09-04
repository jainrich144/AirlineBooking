package airline.model;

public class Plane {
    String planeName;
    int planeCapacity;

    public void setPlaneName(String planeName) {
        this.planeName = planeName;
    }

    public void setPlaneCapacity(int planeCapacity) {
        this.planeCapacity = planeCapacity;
    }

    public String getPlaneName() {
        return planeName;
    }

    public int getPlaneCapacity() {
        return planeCapacity;
    }
}