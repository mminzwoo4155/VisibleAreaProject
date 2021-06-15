package object;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Calculate extends Characteristics{
    public static List<Characteristics> objectsList = new ArrayList<>();
    public Calculate() {
    }
    // cac quy uoc cho bai toan
    // mat phang ABCD la mat phang san
    // AB song song truc OX
    // AD song song truc OY
    // xac dinh vector phap tuyen n cua mat phang tao boi 3 diem

    // xac dinh vector chi phuong cua duong thang di qua 2 diem trong khong gian
    public Cordination makeVectorU(Cordination pointX, Cordination pointY){
        Cordination vectorXY = new Cordination();
        vectorXY.setX(pointY.getX() - pointX.getX());
        vectorXY.setY(pointY.getY() - pointX.getY());
        vectorXY.setZ(pointY.getZ() - pointX.getZ());
        return vectorXY;
    }
    //check vuong goc
    public boolean checkPerpendicular(Cordination vectorXY, Cordination vectorYZ){
        return vectorXY.getX() * vectorYZ.getX() + vectorXY.getY() * vectorYZ.getY() + vectorXY.getZ() * vectorYZ.getZ() == 0;
    }
    // check la hinh chu nhat
    public boolean checkRectangle(Cordination a, Cordination b, Cordination c, Cordination d){double ab = distancePointAB(a,b);
        double ac = distancePointAB(a,c);
        double ad = distancePointAB(a,d);
        Cordination vector1 = makeVectorN(a,b);
        Cordination vector2 = makeVectorN(a,c);
        Cordination vector3 = makeVectorN(a,d);
        if ((Math.round(Math.pow(ab,2)+Math.pow(ac,2)) == Math.round(Math.pow(ad,2)))) {
            return checkPerpendicular(vector1, vector2);

        }else
        if (Math.round(Math.pow(ab,2)+Math.pow(ad,2)) == Math.round(Math.pow(ac,2))){
            return checkPerpendicular(vector1, vector3);
        }else
        if (Math.round(Math.pow(ac,2)+Math.pow(ad,2)) == Math.round(Math.pow(ab,2))){
            return checkPerpendicular(vector2, vector3);
        }
        else {
            return false;
        }
    }
    public Cordination makeVectorN(Cordination pointX, Cordination pointY, Cordination pointZ )
    {
        Cordination vectorXY = new Cordination();
        Cordination vectorXZ = new Cordination();
        Cordination vectorN = new Cordination();

        vectorXY.setX(pointY.getX() - pointX.getX());
        vectorXY.setY(pointY.getY() - pointX.getY());
        vectorXY.setZ(pointY.getZ() - pointX.getZ());

        vectorXZ.setX(pointZ.getX() - pointX.getX());
        vectorXZ.setY(pointZ.getY() - pointX.getY());
        vectorXZ.setZ(pointZ.getZ() - pointX.getZ());

        vectorN.setX((vectorXY.getY() * vectorXZ.getZ()) - (vectorXY.getZ() * vectorXZ.getY()));
        vectorN.setY((vectorXY.getZ() * vectorXZ.getX()) - (vectorXY.getX() * vectorXZ.getZ()));
        vectorN.setZ((vectorXY.getX() * vectorXZ.getY()) - (vectorXY.getY() * vectorXZ.getX()));

        // phuong trinh mat phang la viet boi vector phap tuyen N
        // X(x - xo) + Y(y- yo) + Z(z-zo) = 0;
        return vectorN;
    }
    // xac dinh vector phap tuyen cua duong thang di qua 2 diem trong mat phang
    public Cordination makeVectorN(Cordination pointX, Cordination pointY)
    {
        return new Cordination((pointX.getY() - pointY.getY()), (pointY.getX() - pointX.getX()));
    }
    // tinh khoang cach giua 2 diem
    public double distancePointAB(Cordination pointA, Cordination pointB)
    {
        return Math.abs(Math.sqrt(Math.pow((pointB.getX()) - pointA.getX(), 2) + Math.pow(pointB.getY() - pointA.getY(), 2)
                + Math.pow(pointB.getZ() - pointA.getZ(), 2)));
    }
    // tinh khoang cach tu mot diem nam ngoai mat phang den mat phang do
    // K la diem thuoc mat phang cho truoc
    public double distance(Cordination pointM, Cordination vectorN, Cordination pointK)
    {
        return Math.abs((pointM.getX() * vectorN.getX())+ (pointM.getY() * vectorN.getY()) + (pointM.getZ() * vectorN.getZ())
                +((vectorN.getX() * pointK.getX()) + (vectorN.getY() * pointK.getY()) + vectorN.getZ() * pointK.getZ()) * (-1))
                / (Math.sqrt(Math.pow(vectorN.getX(),2) + Math.pow(vectorN.getY(), 2) + Math.pow(vectorN.getZ(), 2)));
    }
    // khoang cach tu mot diem den mot duong thang
    public  double distanceLine( Cordination pointM, Cordination vectorN, Cordination pointK)
    {
        return Math.abs((pointM.getX() * vectorN.getX())+ (pointM.getY() * vectorN.getY())
                +((vectorN.getX() * pointK.getX()) + (vectorN.getY() * pointK.getY())) * (-1))
                / (Math.sqrt(Math.pow(vectorN.getX(),2) + Math.pow(vectorN.getY(), 2)));
    }
    // tinh dien tich mat
    public double square(Cordination pointX, Cordination pointY, Cordination pointZ)
    {
        double XY = distancePointAB(pointX, pointY);
        double YZ = distancePointAB(pointY, pointZ);
        return XY * YZ;
    }
    public double triangle(Cordination pointX, Cordination pointY, Cordination pointZ)
    {
        double XY = distancePointAB(pointX, pointY);
        double YZ = distancePointAB(pointY, pointZ);
        double ZX = distancePointAB(pointZ, pointX);
        double p = (XY + YZ + ZX )/2;

        return Math.round(Math.sqrt(p*(p-XY)*(p-YZ)*(p-ZX))*100) / 100.0;
    }
    // tinh the tich hinh chop tu giac
    public double pyramidVolume (Cordination pointX, Cordination pointY, Cordination pointZ, Cordination pointM)
    {
        Cordination vectorN = makeVectorN(pointX, pointY, pointZ);
        double square = square(pointX, pointY, pointZ);
        double distance = distance(pointM, vectorN, pointX);
        return (square * distance) / 3;
    }
    // tinh the tich can phong
    public double volumeOfObject( Calculate obj, int indexObj)
    {
        double width = distancePointAB(objectsList.get(indexObj).getPointA(), objectsList.get(indexObj).getPointB());
        double length = distancePointAB(objectsList.get(indexObj).getPointA(), objectsList.get(indexObj).getPointD());
        double height = distancePointAB(objectsList.get(indexObj).getPointA(), objectsList.get(indexObj).getPointA1());
        return  width * length * height;
    }
    // tinh tong the tich 6 hinh chop
    public double sumOfVolume( Calculate obj, int index, Cordination pointM)
    {
        double volumeM1 = pyramidVolume(objectsList.get(index).getPointA(), objectsList.get(index).getPointB(), objectsList.get(index).getPointC(), pointM);
        double volumeM2 = pyramidVolume(objectsList.get(index).getPointA(), objectsList.get(index).getPointB(), objectsList.get(index).getPointB1(), pointM);
        double volumeM3 = pyramidVolume(objectsList.get(index).getPointA(), objectsList.get(index).getPointD(), objectsList.get(index).getPointD1(), pointM);
        double volumeM4 = pyramidVolume(objectsList.get(index).getPointB1(), objectsList.get(index).getPointB(), objectsList.get(index).getPointC(), pointM);
        double volumeM5 = pyramidVolume(objectsList.get(index).getPointA1(), objectsList.get(index).getPointB1(), objectsList.get(index).getPointC1(), pointM);
        double volumeM6 = pyramidVolume(objectsList.get(index).getPointC(), objectsList.get(index).getPointD(), objectsList.get(index).getPointD1(), pointM);
        return volumeM1 + volumeM2 + volumeM3 + volumeM4 + volumeM5 + volumeM6;
    }
    // kiem tra xem vat co ton tai trong danh sach khong

    // kiem tra xem vat co nam o tren san nha khong?
    // quy uoc OXY la mat phang san nha
    public double checkOnPlane(Calculate obj, int index, Cordination pointM)
    {
        Cordination vectorN = makeVectorN(objectsList.get(index).getPointA(), objectsList.get(index).getPointB(), objectsList.get(index).getPointC());
        return distance(pointM, vectorN, objectsList.get(index).getPointA());
    }
    //check 1 diem thuoc mot khung mat phang gioi han cho truoc hay khong
    // thuat toan xet su cung phia voi 4 duong thang xac dinh mat phang gioi han
    public boolean checkRelative(Cordination pointX, Cordination pointY, Cordination pointN, Cordination pointM)
    {
        //point M la diem thuoc duong thang da biet trc
        //AB:(y1−y2)(x−x1)+(x2−x1)(y−y1)=0
        Cordination vectorN = makeVectorN(pointN,pointM);
        double a = (vectorN.getX() * pointX.getX()) + (vectorN.getY() * pointX.getY())
                - (vectorN.getX() * pointM.getX() + vectorN.getY() * pointM.getY());
        double b = (vectorN.getX() * pointY.getX()) + (vectorN.getY() * pointY.getY())
                - (vectorN.getX() * pointM.getX() + vectorN.getY() * pointM.getY());
        return a * b >= 0;
    }
    public boolean checkRelativeObject(Cordination pointX, Cordination pointY, Cordination pointN, Cordination pointM)
    {
        //point M la diem thuoc duong thang da biet trc
        //AB:(y1−y2)(x−x1)+(x2−x1)(y−y1)=0
        Cordination vectorN = makeVectorN(pointN,pointM);
        double a = (vectorN.getX() * pointX.getX()) + (vectorN.getY() * pointX.getY())
                - (vectorN.getX() * pointM.getX() + vectorN.getY() * pointM.getY());
        double b = (vectorN.getX() * pointY.getX()) + (vectorN.getY() * pointY.getY())
                - (vectorN.getX() * pointM.getX() + vectorN.getY() * pointM.getY());
        // tra ve cung phia voi duong thang
        return a * b > 0;
    }
    public int checkPointOnFloor(Cordination point)
    {
        // lay toa do trung diem cua duong cheo san nha
        Cordination center = new Cordination();
        center.setX((objectsList.get(0).getPointA().getX() + objectsList.get(0).getPointC().getX()) / 2);
        center.setY((objectsList.get(0).getPointA().getY() + objectsList.get(0).getPointC().getY()) / 2);
        center.setZ(objectsList.get(0).getPointA().getZ());
        boolean check1 = checkRelative(center, point, objectsList.get(0).getPointA(), objectsList.get(0).getPointB());
        boolean check2 = checkRelative(center, point, objectsList.get(0).getPointA(), objectsList.get(0).getPointD());
        boolean check3 = checkRelative(center, point, objectsList.get(0).getPointB(), objectsList.get(0).getPointC());
        boolean check4 = checkRelative(center, point, objectsList.get(0).getPointC(), objectsList.get(0).getPointD());
        if (check1 && check2 && check3 && check4) {
            return 1;
        }
        else {
            return -1;
        }
    }
    public int checkPointOnSurface(Cordination point, int indexCheckObj){
        // lay toa do trung diem cua duong cheo hinh hop chu nhat nam duoi
        List<Double> list = new ArrayList<>();
        double A1B1 = (double)Math.round(distancePointAB(objectsList.get(indexCheckObj).getPointA1(),objectsList.get(indexCheckObj).getPointB1())*100)/100;
        double A1C1 = (double)Math.round(distancePointAB(objectsList.get(indexCheckObj).getPointA1(),objectsList.get(indexCheckObj).getPointC1())*100)/100;
        double A1D1 = (double)Math.round(distancePointAB(objectsList.get(indexCheckObj).getPointA1(),objectsList.get(indexCheckObj).getPointD1())*100)/100;
        list.add(A1B1);
        list.add(A1C1);
        list.add(A1D1);
        Collections.sort(list);
        if(A1B1 == list.get(2)) {
            Cordination center = new Cordination();
            center.setX((objectsList.get(indexCheckObj).getPointA1().getX() + objectsList.get(indexCheckObj).getPointB1().getX()) / 2);
            center.setY((objectsList.get(indexCheckObj).getPointA1().getY() + objectsList.get(indexCheckObj).getPointB1().getY()) / 2);
            center.setZ(objectsList.get(indexCheckObj).getPointA1().getZ());
            boolean check1 = checkRelative(center, point, objectsList.get(indexCheckObj).getPointA1(), objectsList.get(indexCheckObj).getPointB1());
            boolean check2 = checkRelative(center, point, objectsList.get(indexCheckObj).getPointA1(), objectsList.get(indexCheckObj).getPointD1());
            boolean check3 = checkRelative(center, point, objectsList.get(indexCheckObj).getPointB1(), objectsList.get(indexCheckObj).getPointC1());
            boolean check4 = checkRelative(center, point, objectsList.get(indexCheckObj).getPointC1(), objectsList.get(indexCheckObj).getPointD1());
            if (check1 && check2 && check3 && check4) {
                return 1;
            }
            else {
                return -1;
            }
        }
        if(A1C1 == list.get(2)) {
            Cordination center = new Cordination();
            center.setX((objectsList.get(indexCheckObj).getPointA1().getX() + objectsList.get(indexCheckObj).getPointC1().getX()) / 2);
            center.setY((objectsList.get(indexCheckObj).getPointA1().getY() + objectsList.get(indexCheckObj).getPointC1().getY()) / 2);
            center.setZ(objectsList.get(indexCheckObj).getPointA1().getZ());
            boolean check1 = checkRelative(center, point, objectsList.get(indexCheckObj).getPointA1(), objectsList.get(indexCheckObj).getPointB1());
            boolean check2 = checkRelative(center, point, objectsList.get(indexCheckObj).getPointA1(), objectsList.get(indexCheckObj).getPointD1());
            boolean check3 = checkRelative(center, point, objectsList.get(indexCheckObj).getPointB1(), objectsList.get(indexCheckObj).getPointC1());
            boolean check4 = checkRelative(center, point, objectsList.get(indexCheckObj).getPointC1(), objectsList.get(indexCheckObj).getPointD1());
            if (check1 && check2 && check3 && check4) {
                return 1;
            }
            else {
                return -1;
            }
        }
        if(A1D1 == list.get(2)) {
            Cordination center = new Cordination();
            center.setX((objectsList.get(indexCheckObj).getPointA1().getX() + objectsList.get(indexCheckObj).getPointD1().getX()) / 2);
            center.setY((objectsList.get(indexCheckObj).getPointA1().getY() + objectsList.get(indexCheckObj).getPointD1().getY()) / 2);
            center.setZ(objectsList.get(indexCheckObj).getPointA1().getZ());
            boolean check1 = checkRelative(center, point, objectsList.get(indexCheckObj).getPointA1(), objectsList.get(indexCheckObj).getPointB1());
            boolean check2 = checkRelative(center, point, objectsList.get(indexCheckObj).getPointA1(), objectsList.get(indexCheckObj).getPointD1());
            boolean check3 = checkRelative(center, point, objectsList.get(indexCheckObj).getPointB1(), objectsList.get(indexCheckObj).getPointC1());
            boolean check4 = checkRelative(center, point, objectsList.get(indexCheckObj).getPointC1(), objectsList.get(indexCheckObj).getPointD1());
            if (check1 && check2 && check3 && check4) {
                return 1;
            }
            else {
                return -1;
            }
        }
        return -1;
    }
    // kiem tra xem vat co nam trong can phong khong?
    public int checkInRoom( Calculate object, int index)
    {
        // System.out.println(" size : "+object.objectsList.size());
        double sum1 = Math.round(sumOfVolume(object, 0, objectsList.get(index).getPointA()));
        double sum2 = Math.round(sumOfVolume(object, 0, objectsList.get(index).getPointB()));
        double sum3 = Math.round(sumOfVolume(object, 0, objectsList.get(index).getPointC()));
        double sum4 = Math.round(sumOfVolume(object, 0, objectsList.get(index).getPointD()));
        double sum5 = Math.round(sumOfVolume(object, 0, objectsList.get(index).getPointA1()));
        double sum6 = Math.round(sumOfVolume(object, 0, objectsList.get(index).getPointB1()));
        double sum7 = Math.round(sumOfVolume(object, 0, objectsList.get(index).getPointC1()));
        double sum8 = Math.round(sumOfVolume(object, 0 , objectsList.get(index).getPointD1()));

        if (sum1 == volumeOfObject(object, 0) && sum2 == volumeOfObject(object, 0) && sum3 == volumeOfObject(object, 0)
                && sum4 == volumeOfObject(object, 0) && sum5 == volumeOfObject(object, 0)
                && sum6 == volumeOfObject(object, 0) && sum7 == volumeOfObject(object, 0) && sum8 == volumeOfObject(object, 0)) {
            // xet vat nam tren san nha
            // System.out.println(" vao day lan 1");
            if(checkOnPlane(object,0, objectsList.get(index).getPointA()) == 0
                    && checkOnPlane(object, 0, objectsList.get(index).getPointB()) == 0 &&
                    checkOnPlane(object, 0, objectsList.get(index).getPointC()) == 0
                    && checkOnPlane(object, 0, objectsList.get(index).getPointD()) == 0)
            {
                // System.out.println(" check A1 :" + checkPointOnFloor(object.objectsList.get(i).getPointA()));
                if(checkPointOnFloor(objectsList.get(index).getPointA()) == 1 && checkPointOnFloor(objectsList.get(index).getPointB()) == 1
                        && checkPointOnFloor(objectsList.get(index).getPointC()) == 1 && checkPointOnFloor(objectsList.get(index).getPointD()) == 1) {
                    //  System.out.println(" vao check vat nam tren san");
                    return 1;
                }
            }
            else {
                //  System.out.println(" vao day check vat nam tren mat vat khac");
                for( int j = 1 ; j < objectsList.size() ; j++) {
                    if (index == j) {
                        continue;
                    }
                    // tao vectorN mat phang A1B1C1
                    // list de luu cac diem nam tren be mat vat khac
                    //ArrayList<Cordination> list = new ArrayList<>();
                    // tao vector phap tuyen cua mat phang
                    int count = 0;
                    Cordination vectorN = makeVectorN(objectsList.get(j).getPointA1(), objectsList.get(j).getPointB1()
                            , objectsList.get(j).getPointC1());
                    if (distance(objectsList.get(index).getPointA(), vectorN, objectsList.get(j).getPointA1()) == 0 &&
                            distance(objectsList.get(index).getPointB(), vectorN, objectsList.get(j).getPointA1()) == 0 &&
                            distance(objectsList.get(index).getPointC(), vectorN, objectsList.get(j).getPointA1()) == 0) {
                        if (checkPointOnSurface(objectsList.get(index).getPointA(), j) == 1) {
                            count++; }
                        if (checkPointOnSurface(objectsList.get(index).getPointB(), j) == 1) {
                            count++;
                        }
                        if (checkPointOnSurface(objectsList.get(index).getPointC(), j) == 1) {
                            count++;
                        }
                        if (checkPointOnSurface(objectsList.get(index).getPointD(), j) == 1) {
                            count++;
                        }
                        if (count >= 1 && count <= 4) {
                            return 2;
                        }
                    }
                }
            }
        }

        return -1;
    }
    public boolean checkPointInObject(Cordination point, Characteristics obj){
        Cordination vectorABCD = makeVectorN(obj.getPointA(),obj.getPointB(),obj.getPointC());
        Cordination vectorABB1A1 = makeVectorN(obj.getPointA(),obj.getPointB(),obj.getPointA1());
        Cordination vectorA1B1C1D1 = makeVectorN(obj.getPointA1(),obj.getPointB1(),obj.getPointC1());
        Cordination vectorC1D1DC = makeVectorN(obj.getPointC1(),obj.getPointD1(),obj.getPointC());
        Cordination vectorADD1A1 = makeVectorN(obj.getPointA(),obj.getPointD1(),obj.getPointA1());
        Cordination vectorBCC1B1 = makeVectorN(obj.getPointC1(),obj.getPointB(),obj.getPointC());

        double distancePToABCD = distance(point,vectorABCD,obj.getPointA());
        double distancePToABB1A1 = distance(point,vectorABB1A1,obj.getPointA());
        double distancePToA1B1C1D1 = distance(point,vectorA1B1C1D1,obj.getPointA1());
        double distancePToC1D1DC = distance(point,vectorC1D1DC,obj.getPointC());
        double distancePToADD1A1 = distance(point,vectorADD1A1,obj.getPointA());
        double distancePToBCC1B1 = distance(point,vectorBCC1B1,obj.getPointB());

        double volumePABCD = distancePToABCD * square(obj.getPointA(), obj.getPointB(), obj.getPointC());
        double volumePA1B1C1D1 = distancePToA1B1C1D1 * square(obj.getPointA1(), obj.getPointB1(), obj.getPointC1());
        double volumePABB1A1 = distancePToABB1A1 * square(obj.getPointA(), obj.getPointB(), obj.getPointB1());
        double volumePCDD1C1 = distancePToC1D1DC * square(obj.getPointC(), obj.getPointD(), obj.getPointD1());
        double volumePADD1A1 = distancePToADD1A1 * square(obj.getPointA(), obj.getPointD(), obj.getPointD1());
        double volumePBCC1B1 = distancePToBCC1B1 * square(obj.getPointB(), obj.getPointC(), obj.getPointC1());


        double height = distancePointAB(obj.getPointA(),obj.getPointA1());
        double volumeObj = height*square(obj.getPointA(),obj.getPointB(),obj.getPointC());
        return volumeObj == (volumePA1B1C1D1 + volumePABCD + volumePABB1A1 + volumePADD1A1 + volumePBCC1B1 + volumePCDD1C1) / 3;
    }
    public void setParameter() {
        setLength(distancePointAB(pointA, pointB));
        setWidth(distancePointAB(pointA, pointD));
        setHeight(distancePointAB(pointA, pointA1));
    }

    public boolean checkPointInRectangle(Cordination pointA, Cordination pointB, Cordination pointC, Cordination pointD, Cordination pointM){
        Cordination vectorAB = makeVectorU(pointA, pointB);
        Cordination vectorBC = makeVectorU(pointB, pointC);

        Cordination vectorAM = makeVectorU(pointA, pointM);
        Cordination vectorBM = makeVectorU(pointB, pointM);
        Cordination vectorCM = makeVectorU(pointC, pointM);
        Cordination vectorDM = makeVectorU(pointD, pointM);

        // khoang cach tu M den AB
        Cordination AM_U = new Cordination();
        AM_U.setX((vectorAM.getY() * vectorAB.getZ()) - (vectorAM.getZ() * vectorAB.getY()));
        AM_U.setY((vectorAM.getZ() * vectorAB.getX()) - (vectorAM.getX() * vectorAB.getZ()));
        AM_U.setZ((vectorAM.getX() * vectorAB.getY()) - (vectorAM.getY() * vectorAB.getX()));
        // M -> BC
        Cordination BM_U = new Cordination();
        BM_U.setX((vectorBM.getY() * vectorBC.getZ()) - (vectorBM.getZ() * vectorBC.getY()));
        BM_U.setY((vectorBM.getZ() * vectorBC.getX()) - (vectorBM.getX() * vectorBC.getZ()));
        BM_U.setZ((vectorBM.getX() * vectorBC.getY()) - (vectorBM.getY() * vectorBC.getX()));
        //M -> CD
        Cordination CM_U = new Cordination();
        CM_U.setX((vectorCM.getY() * vectorAB.getZ()) - (vectorCM.getZ() * vectorAB.getY()));
        CM_U.setY((vectorCM.getZ() * vectorAB.getX()) - (vectorCM.getX() * vectorAB.getZ()));
        CM_U.setZ((vectorCM.getX() * vectorAB.getY()) - (vectorCM.getY() * vectorAB.getX()));
        //M-> AD
        Cordination DM_U = new Cordination();
        DM_U.setX((vectorDM.getY() * vectorBC.getZ()) - (vectorDM.getZ() * vectorBC.getY()));
        DM_U.setY((vectorDM.getZ() * vectorBC.getX()) - (vectorDM.getX() * vectorBC.getZ()));
        DM_U.setZ((vectorDM.getX() * vectorBC.getY()) - (vectorDM.getY() * vectorBC.getX()));

        double AB = Math.sqrt(Math.pow(vectorAB.getX(), 2) + Math.pow(vectorAB.getY(), 2) + Math.pow(vectorAB.getZ(), 2));
        double BC = Math.sqrt(Math.pow(vectorBC.getX(), 2) + Math.pow(vectorBC.getY(), 2) + Math.pow(vectorBC.getZ(), 2));

        double M1 = Math.sqrt(Math.pow(AM_U.getX(), 2) + Math.pow(AM_U.getY(), 2) + Math.pow(AM_U.getZ(), 2)) / AB;
        double M2 = Math.sqrt(Math.pow(BM_U.getX(), 2) + Math.pow(BM_U.getY(), 2) + Math.pow(BM_U.getZ(), 2)) / BC;
        double M3 = Math.sqrt(Math.pow(CM_U.getX(), 2) + Math.pow(CM_U.getY(), 2) + Math.pow(CM_U.getZ(), 2)) / AB;
        double M4 = Math.sqrt(Math.pow(DM_U.getX(), 2) + Math.pow(DM_U.getY(), 2) + Math.pow(DM_U.getZ(), 2)) / BC;

        // System.out.println("vao day ");
        if (Math.round( M1 + M2 + M3 + M4) == Math.round(distancePointAB(pointA, pointB) + distancePointAB(pointB, pointC))) {
            return true;
        } else {
            return false;
        }
    }

    public Cordination findIntersectionPoint(Cordination pointM , Cordination cam, Cordination vectorNPlane, Cordination pointInPlane)
    {
        // tao vecto chi phuong cua duong thang
        Cordination vectorU = makeVectorU(pointM, cam);
        //  System.out.println("U :"+vectorU.toString());
        // (a b c) la vec to chi phuong cua duong thang, (A B C) la vector phap tuyen cua mat phang
        // x = x1o + at, y = y1o+ bt, z = z1o + ct
        // D = -(Ax0 + Byo + Cz0), xo la diem thuoc mat phang
        //t (Aa + Bb + Cc) = - D -Ax10 -By10 - Cz1o, dat Q = (- D -Ax10 -By10 - Cz1o), (x10, y10, z10) la diem thuoc duong thang
        double D = (vectorNPlane.getX() * pointInPlane.getX() + vectorNPlane.getY() * pointInPlane.getY() + vectorNPlane.getZ() * pointInPlane.getZ()) * (-1);
        //  System.out.println(" D :"+ D);
        double Q = (-1) * (D + vectorNPlane.getX() * cam.getX() + vectorNPlane.getY() * cam.getY() + vectorNPlane.getZ() * cam.getZ());
        //  System.out.println(" Q: "+ Q);
        double T = Math.round((Q / (vectorNPlane.getX() * vectorU.getX() + vectorNPlane.getY() * vectorU.getY() + vectorNPlane.getZ() * vectorU.getZ())) * 100) / 100.0;
        //  System.out.println("T :"+T);
        Cordination intersectionPoint = new Cordination();
        intersectionPoint.setX(cam.getX() + T * vectorU.getX());
        intersectionPoint.setY(cam.getY() + T * vectorU.getY());
        intersectionPoint.setZ(cam.getZ() + T * vectorU.getZ());
        return intersectionPoint;
    }
    public boolean checkPointInVisibleArea(Cordination pointM, Cordination cam, int indexObj)
    {
        Cordination nA1B1C1D1 = makeVectorN(objectsList.get(indexObj).getPointA1(), objectsList.get(indexObj).getPointB1(), objectsList.get(indexObj).getPointC1());
        Cordination nABB1A1 = makeVectorN(objectsList.get(indexObj).getPointA(), objectsList.get(indexObj).getPointB(), objectsList.get(indexObj).getPointB1());
        Cordination nADD1A1 = makeVectorN(objectsList.get(indexObj).getPointA(), objectsList.get(indexObj).getPointD(), objectsList.get(indexObj).getPointD1());
        Cordination nBCC1B1 = makeVectorN(objectsList.get(indexObj).getPointB(), objectsList.get(indexObj).getPointB1(), objectsList.get(indexObj).getPointC1());
        Cordination nCC1D1D = makeVectorN(objectsList.get(indexObj).getPointD(), objectsList.get(indexObj).getPointD1(), objectsList.get(indexObj).getPointC1());

        Cordination vectorULine = makeVectorU(cam, pointM);
        // kiem tra xem duong co cat mat hay khong
        // xet mat A1B1C1D1
        int countCheck=0;
        if((vectorULine.getX() * nA1B1C1D1.getX()) + (vectorULine.getY() * nA1B1C1D1.getY()) + (vectorULine.getZ() * nA1B1C1D1.getZ()) !=0)
        {
            // neu cat => thi kiem tra giao diem co thuoc be mat cua vat hay k
            // tim giao diem cua duong voi mat
            Cordination intersectionPoint = findIntersectionPoint(pointM, cam, nA1B1C1D1, objectsList.get(indexObj).getPointA1());
            // kiem tra xem giao diem co thuoc mat phang cua vat hay phan keo dai cua mat phang
            if(checkPointInRectangle(objectsList.get(indexObj).getPointA1(), objectsList.get(indexObj).getPointB1(),
                    objectsList.get(indexObj).getPointC1(), objectsList.get(indexObj).getPointD1(), intersectionPoint)){
                double distanceMCam = distancePointAB(cam, pointM);
                double distanceNCam = distancePointAB(cam, intersectionPoint);
                if(distanceMCam <= distanceNCam)
                {
                }
                else {
                    countCheck++;
                }
            }
        }
        // xet mp ABB1A1
        if((vectorULine.getX() * nABB1A1.getX()) + (vectorULine.getY() * nABB1A1.getY()) + (vectorULine.getZ() * nABB1A1.getZ()) !=0)
        {
            // neu cat => thi kiem tra giao diem co thuoc be mat cua vat hay k
            // tim giao diem cua duong voi mat
            Cordination intersectionPoint = findIntersectionPoint(pointM, cam, nABB1A1, objectsList.get(indexObj).getPointA1());
            //  System.out.println(" giao diem 2 :"+ intersectionPoint.toString());
            // kiem tra xem giao diem co thuoc mat phang cua vat hay phan keo dai cua mat phang
            if(checkPointInRectangle(objectsList.get(indexObj).getPointA(), objectsList.get(indexObj).getPointB(),
                    objectsList.get(indexObj).getPointB1(), objectsList.get(indexObj).getPointA1(), intersectionPoint)){
                //  System.out.println(" co cat A1 B1 B A1");
                double distanceMCam = distancePointAB(cam, pointM);
                double distanceNCam = distancePointAB(cam, intersectionPoint);
                if(distanceMCam <= distanceNCam)
                {
                    //   System.out.println(" nhin thay 2");
                }
                else {
                    countCheck++;
                }
            }
            //  System.out.println("ABB1A1: nhin thay");

        }
        // xet mat ADD1A1
        if((vectorULine.getX() * nADD1A1.getX()) + (vectorULine.getY() * nADD1A1.getY()) + (vectorULine.getZ() * nADD1A1.getZ()) !=0)
        {
            // neu cat => thi kiem tra giao diem co thuoc be mat cua vat hay k
            // tim giao diem cua duong voi mat
            Cordination intersectionPoint = findIntersectionPoint(pointM, cam, nADD1A1, objectsList.get(indexObj).getPointA1());
            //  System.out.println(" giao diem 3 :"+ intersectionPoint.toString());
            // kiem tra xem giao diem co thuoc mat phang cua vat hay phan keo dai cua mat phang
            if(checkPointInRectangle(objectsList.get(indexObj).getPointA(), objectsList.get(indexObj).getPointD(),
                    objectsList.get(indexObj).getPointD1(), objectsList.get(indexObj).getPointA1(), intersectionPoint)){
                //  System.out.println(" co cat A D D1 A1");
                double distanceMCam = distancePointAB(cam, pointM);
                double distanceNCam = distancePointAB(cam, intersectionPoint);
                if(distanceMCam <= distanceNCam)
                {
                    //     System.out.println(" nhin thay 3");
                }
                else {
                    countCheck++;
                }
            }
            //  System.out.println("ADD1A1: nhin thay");
        }
        if((vectorULine.getX() * nBCC1B1.getX()) + (vectorULine.getY() * nBCC1B1.getY()) + (vectorULine.getZ() * nBCC1B1.getZ()) !=0)
        {
            // neu cat => thi kiem tra giao diem co thuoc be mat cua vat hay k
            // tim giao diem cua duong voi mat
            Cordination intersectionPoint = findIntersectionPoint(pointM, cam, nBCC1B1, objectsList.get(indexObj).getPointB());
            //  System.out.println(" giao diem 4 :"+ intersectionPoint.toString());
            // kiem tra xem giao diem co thuoc mat phang cua vat hay phan keo dai cua mat phang
            if(checkPointInRectangle(objectsList.get(indexObj).getPointB(), objectsList.get(indexObj).getPointC(),
                    objectsList.get(indexObj).getPointC1(), objectsList.get(indexObj).getPointB1(), intersectionPoint)){
                //   System.out.println(" co cat B B1 C1 C");
                double distanceMCam = distancePointAB(cam, pointM);
                double distanceNCam = distancePointAB(cam, intersectionPoint);
                if(distanceMCam <= distanceNCam)
                {
                    //   System.out.println("nhin thay 4");

                }
                else {
                    countCheck++;
                }
            }
            //  System.out.println("BCC1B1: nhin thay");
        }
        if((vectorULine.getX() * nCC1D1D.getX()) + (vectorULine.getY() * nCC1D1D.getY()) + (vectorULine.getZ() * nCC1D1D.getZ()) !=0)
        {
            // neu cat => thi kiem tra giao diem co thuoc be mat cua vat hay k
            // tim giao diem cua duong voi mat
            Cordination intersectionPoint = findIntersectionPoint(pointM, cam, nCC1D1D, objectsList.get(indexObj).getPointC());
            // System.out.println(" giao diem 5 :"+ intersectionPoint.toString());
            // kiem tra xem giao diem co thuoc mat phang cua vat hay phan keo dai cua mat phang
            if(checkPointInRectangle(objectsList.get(indexObj).getPointC(), objectsList.get(indexObj).getPointC1(),
                    objectsList.get(indexObj).getPointD1(), objectsList.get(indexObj).getPointD(), intersectionPoint)){
                double distanceMCam = distancePointAB(cam, pointM);
                double distanceNCam = distancePointAB(cam, intersectionPoint);
                if(distanceMCam <= distanceNCam)
                {
                }
                else {
                    countCheck++;
                }
            }
            else {
            }
        }
        if (countCheck > 0)
        {
            return false;
        }
        else {
            return true;
        }
    }

}
