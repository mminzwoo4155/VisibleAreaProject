package customer;

import object.Calculate;
import object.Characteristics;
import object.Cordination;

public class Camera extends Cordination {
    private double sightCorner;         //goc nhin
    public static final double scope = 100;               //tam xa
    private Cordination pointTmp;       //Diem xet trung gian
    //Bien check: 1: Camera nam tren mp z = height
    //2: Camera nam tren mp Oyz
    //3: Camera nam tren mp Oxz
    //4: Camera nam tren mp x = length
    //5: Camera nam tren mp y = width
    private int check;

    public Camera() {
    }

    public int getCheck(){
        return check;
    }
    public double getSightCorner() {
        return sightCorner;
    }

    public void setSightCorner(double sightCorner) {
        this.sightCorner = sightCorner;
    }

    public double getScope() {
        return scope;
    }

    public Camera(double x, double y, double z, double sightCorner) {
        super(x, y, z);
        this.sightCorner = sightCorner;
    }


    public boolean checkInVisibleArea(Cordination point) {
        double factorTmp1, factorTmp2, factorTmp3, factorTmp4, factorPoint1, factorPoint2, factorPoint3, factorPoint4;
        //Camera nam tren mp z = height
        if (check == 1) {
            factorTmp1 = (pointTmp.getY() - getY()) - Math.tan(sightCorner / 2) * (pointTmp.getZ() - getZ());
            factorPoint1 = (point.getY() - getY()) - Math.tan(sightCorner / 2) * (point.getZ() - getZ());
            factorTmp2 = (pointTmp.getY() - getY()) + Math.tan(sightCorner / 2) * (pointTmp.getZ() - getZ());
            factorPoint2 = (point.getY() - getY()) + Math.tan(sightCorner / 2) * (point.getZ() - getZ());
            factorTmp3 = (pointTmp.getX() - getX()) - Math.tan(sightCorner / 2) * (pointTmp.getZ() - getZ());
            factorPoint3 = (point.getX() - getX()) - Math.tan(sightCorner / 2) * (point.getZ() - getZ());
            factorTmp4 = (pointTmp.getX() - getX()) + Math.tan(sightCorner / 2) * (pointTmp.getZ() - getZ());
            factorPoint4 = (point.getX() - getX()) + Math.tan(sightCorner / 2) * (point.getZ() - getZ());
        }
        //Camera nam tren mp Oyz hoac x = length
        else if (check == 2 || check == 4) {
            factorTmp1 = Math.tan(sightCorner / 2) * (pointTmp.getX() - getX()) + (pointTmp.getY() - getY());
            factorPoint1 = Math.tan(sightCorner / 2) * (point.getX() - getX()) + (point.getY() - getY());
            factorTmp2 = Math.tan(sightCorner / 2) * (pointTmp.getX() - getX()) - (pointTmp.getY() - getY());
            factorPoint2 = Math.tan(sightCorner / 2) * (point.getX() - getX()) - (point.getY() - getY());
            factorTmp3 = Math.tan(sightCorner / 2) * (pointTmp.getX() - getX()) + (pointTmp.getZ() - getZ());
            factorPoint3 = Math.tan(sightCorner / 2) * (point.getX() - getX()) + (point.getZ() - getZ());
            factorTmp4 = Math.tan(sightCorner / 2) * (pointTmp.getX() - getX()) - (pointTmp.getZ() - getZ());
            factorPoint4 = Math.tan(sightCorner / 2) * (point.getX() - getX()) - (point.getZ() - getZ());
        }
        //Camera nam tren mp Oxz hoac y = width ((check == 3 || check == 5))
        else {
            factorTmp1 = (pointTmp.getX() - getX()) + Math.tan(pointTmp.getY() - getY());
            factorPoint1 = (point.getX() - getX()) + Math.tan(point.getY() - getY());
            factorTmp2 = (pointTmp.getX() - getX()) - Math.tan(pointTmp.getY() - getY());
            factorPoint2 = (point.getX() - getX()) - Math.tan(point.getY() - getY());
            factorTmp3 = (pointTmp.getZ() - getZ()) + Math.tan(pointTmp.getY() - getY());
            factorPoint3 = (point.getZ() - getZ()) + Math.tan(point.getY() - getY());
            factorTmp4 = (pointTmp.getZ() - getZ()) - Math.tan(pointTmp.getY() - getY());
            factorPoint4 = (point.getZ() - getZ()) - Math.tan(point.getY() - getY());
        }
        return (factorPoint1 * factorTmp1 >= 0 && factorPoint2 * factorTmp2 >= 0 && factorPoint3 * factorTmp3 >= 0
                && factorPoint4 * factorTmp4 >= 0);
    }
    public void setParameter() {
        Characteristics room = new Calculate().objectsList.get(0);
        //Camera nam tren tran nha (z = height)
        if (getZ() == room.getHeight()) {
            pointTmp = new Cordination(getX(), getY(), getZ() - 0.01);
            check = 1;
        }
        //Camera nam tren mp Oyz
        else if (getX() == 0) {
            pointTmp = new Cordination(0.01, getY(), getZ());
            check = 2;
        }
        //Camera nam tren mp Oxz
        else if (getY() == 0) {
            pointTmp = new Cordination(getX(), getY() + 0.01, getZ());
            check = 3;
        }
        //Camera nam tren mp x = length
        else if (getX() == room.getLength()) {
            pointTmp = new Cordination(getX() - 0.01, getY(), getZ());
            check = 4;
        }
        //Camera nam tren mp y = width
        else if (getY() == room.getWidth()) {
            pointTmp = new Cordination(getX(), getY() - 0.01, getZ());
            check = 5;
        }
    }
    public void printParameter() {
        System.out.println("Cordination: " + "(" + getX() + " ," + getY() + " ," + getZ() + ")");
        System.out.println("Sight corner: " + getSightCorner());
        System.out.println("Scope: " + getScope());
    }
}
