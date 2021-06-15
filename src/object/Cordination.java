package object;

public class Cordination {
    private double x;
    private double y;
    private double z;

    public Cordination() {
    }

    public Cordination(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Cordination(double x, double y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString() {
        return "{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
    public boolean toEqual(Cordination pointCheck) {
        if (getX() == pointCheck.getX() && getY() == pointCheck.getY() && getZ() == pointCheck.getZ()) {
            return true;
        } else
            return false;
    }
}
