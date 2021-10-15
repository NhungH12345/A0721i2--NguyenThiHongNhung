package bai4_lop_va_doi_tuong_trong_java.bai_tap.Xay_Dung_Lop_Fan;

public class Fan {
    private final int SLOW = 1;
    private final int MEDIUM = 2;
    private final int PASt = 3;
    private int speed = 1;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    public int getSLOW() {
        return SLOW;
    }

    public int getMEDIUM() {
        return MEDIUM;
    }

    public int getPASt() {
        return PASt;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn()
    {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public Fan(){

    }
    public Fan(int speed, boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.radius = radius;
    }

    @Override
    public String toString() {
        String result = "";
        if (this.isOn()) {
            result = "Speed" + speed + ", color" + color + ", radius" + radius + "Fan is on";
            return result;
        } else {
            result = "Color" + color + ", radius" + radius + "Fan is off";
            return result;
        }
    }
}


