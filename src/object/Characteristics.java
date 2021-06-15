package object;

public class Characteristics {
    protected double length;
    protected double width;
    protected double height;

    public void setWidth(double width) {
        this.width = width;
    }

    protected Cordination pointA = new Cordination();
    protected Cordination pointB = new Cordination();
    protected Cordination pointC = new Cordination();
    protected Cordination pointD = new Cordination();
    protected Cordination pointA1 = new Cordination();
    protected Cordination pointB1 = new Cordination();
    protected Cordination pointC1 = new Cordination();
    protected Cordination pointD1 = new Cordination();
    public Characteristics(double width, double length,  double height,  Cordination pointA, Cordination pointB,
                           Cordination pointC, Cordination pointD,
                           Cordination pointA1, Cordination pointB1, Cordination pointC1, Cordination pointD1) {
        this.width = width;
        this.length = length;
        this.height = height;
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
        this.pointA1 = pointA1;
        this.pointB1 = pointB1;
        this.pointC1 = pointC1;
        this.pointD1 = pointD1;

    }
    public Characteristics(double height,  Cordination pointA, Cordination pointB,
                           Cordination pointC, Cordination pointD,
                           Cordination pointA1, Cordination pointB1, Cordination pointC1, Cordination pointD1) {
        this.height = height;
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
        this.pointA1 = pointA1;
        this.pointB1 = pointB1;
        this.pointC1 = pointC1;
        this.pointD1 = pointD1;

    }

    public Characteristics() {
    }

    public Cordination getPointA() {
        return pointA;
    }
    public Cordination getPointB() {
        return pointB;
    }
    public Cordination getPointC() {
        return pointC;
    }
    public Cordination getPointD() {
        return pointD;
    }
    public Cordination getPointA1() {
        return pointA1;
    }
    public Cordination getPointB1() {
        return pointB1;
    }
    public Cordination getPointC1() {
        return pointC1;
    }
    public Cordination getPointD1() {
        return pointD1;
    }
    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        this.length = length;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setPointA(Cordination pointA) {
        this.pointA = pointA;
    }

    public void setPointB(Cordination pointB) {
        this.pointB = pointB;
    }

    public void setPointC(Cordination pointC) {
        this.pointC = pointC;
    }

    public void setPointD(Cordination pointD) {
        this.pointD = pointD;
    }

    public void setPointA1(Cordination pointA1) {
        this.pointA1 = pointA1;
    }

    public void setPointB1(Cordination pointB1) {
        this.pointB1 = pointB1;
    }

    public void setPointC1(Cordination pointC1) {
        this.pointC1 = pointC1;
    }

    public void setPointD1(Cordination pointD1) {
        this.pointD1 = pointD1;
    }

    public double getHeight() {
        return height;
    }

    public void printParameters() {
        System.out.println("Point A: (" + this.getPointA().getX() + ", " + this.getPointA().getY() + ", " + this.getPointA().getZ() + ")");
        System.out.println("Point B: (" + this.getPointB().getX() + ", " + this.getPointB().getY() + ", " + this.getPointB().getZ() + ")");
        System.out.println("Point C: (" + this.getPointC().getX() + ", " + this.getPointC().getY() + ", " + this.getPointC().getZ() + ")");
        System.out.println("Point D: (" + this.getPointD().getX() + ", " + this.getPointD().getY() + ", " + this.getPointD().getZ() + ")");
        System.out.println("Point A1: (" + this.getPointA1().getX() + ", " + this.getPointA1().getY() + ", " + this.getPointA1().getZ() + ")");
        System.out.println("Point B1: (" + this.getPointB1().getX() + ", " + this.getPointB1().getY() + ", " + this.getPointB1().getZ() + ")");
        System.out.println("Point C1: (" + this.getPointC1().getX() + ", " + this.getPointC1().getY() + ", " + this.getPointC1().getZ() + ")");
        System.out.println("Point D1: (" + this.getPointD1().getX() + ", " + this.getPointD1().getY() + ", " + this.getPointD1().getZ() + ")");
        System.out.println("Length: " + getLength());
        System.out.println("Width: " + getWidth());
        System.out.println("Height: " + getHeight());
    }
}
