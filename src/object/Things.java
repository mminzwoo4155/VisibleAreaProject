package object;

import customer.Camera;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Things {
    private final ArrayList<Camera> cameraList = new ArrayList<>();
    private final Calculate obj = new Calculate();
    protected int numberOfObjects, numberOfCameras;

    public Things() {}

    //Read input file
    public boolean readInputFile(String fileName) {
        String[] inputLines = new String[100];
        int[] count = {0}; //count là bien đem xem da in toi dong nao
        try(Stream<String> stream = Files.lines(Paths.get(fileName))){
            stream.forEach(line ->{
//              line la tung dong trong file
                inputLines[count[0]++] = line;
//                System.out.println(inputLines[count[0]++]);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        numberOfObjects = Integer.parseInt(inputLines[1]);  //so luong vat the trong phong
        numberOfCameras = Integer.parseInt(inputLines[numberOfObjects + 2]);  //so luong camera trong phong
        String tmp, tmp2;

        //Read the first line and set paramaters of room
        tmp = inputLines[0].replace('(', ',');
        tmp2 = tmp.replace(')', ',');
        String[] corTmp = tmp2.split(",");
        double corX;
        double corY;
        double corZ;    //cac toa do x,y,z

        Calculate room =new Calculate();
        //Point A
        corX = Double.parseDouble(corTmp[1]);
        corY = Double.parseDouble(corTmp[2].trim());
        corZ = Double.parseDouble(corTmp[3].trim());
        room.setPointA(new Cordination(corX, corY, corZ));
        //Point B
        corX = Double.parseDouble(corTmp[5]);
        corY = Double.parseDouble(corTmp[6].trim());
        corZ = Double.parseDouble(corTmp[7].trim());
        room.setPointB(new Cordination(corX, corY, corZ));
        //Point C

        corX = Double.parseDouble(corTmp[9]);
        corY = Double.parseDouble(corTmp[10].trim());
        corZ = Double.parseDouble(corTmp[11].trim());
        room.setPointC(new Cordination(corX, corY, corZ));
        //Point D
        corX = Double.parseDouble(corTmp[13]);
        corY = Double.parseDouble(corTmp[14].trim());
        corZ = Double.parseDouble(corTmp[15].trim());
        room.setPointD(new Cordination(corX, corY, corZ));
        //Point A1
        corX = Double.parseDouble(corTmp[17]);
        corY = Double.parseDouble(corTmp[18].trim());
        corZ = Double.parseDouble(corTmp[19].trim());
        room.setPointA1(new Cordination(corX, corY, corZ));
        //Point B1
        corX = Double.parseDouble(corTmp[21]);
        corY = Double.parseDouble(corTmp[22].trim());
        corZ = Double.parseDouble(corTmp[23].trim());
        room.setPointB1(new Cordination(corX, corY, corZ));
        //Point C1
        corX = Double.parseDouble(corTmp[25]);
        corY = Double.parseDouble(corTmp[26].trim());
        corZ = Double.parseDouble(corTmp[27].trim());
        room.setPointC1(new Cordination(corX, corY, corZ));
        //Point D1
        corX = Double.parseDouble(corTmp[29]);
        corY = Double.parseDouble(corTmp[30].trim());
        corZ = Double.parseDouble(corTmp[31].trim());
        room.setPointD1(new Cordination(corX, corY, corZ));
        //Set parameters
        // check room có hợp lệ hay không
        if (room.getPointA1().getZ() != room.getPointB1().getZ() || room.getPointA1().getZ() != room.getPointC1().getZ()
                || room.getPointA1().getZ() != room.getPointD1().getZ()) {
            System.out.println("Toa do can phong khong hop le");
            return false;
        } else {
            if (obj.checkRectangle(room.pointA, room.pointB, room.pointC, room.pointD)) {
                room.setParameter();
                Calculate.objectsList.add(room);
            } else {
                System.out.println("Can phong khong phai la hinh hop chu nhat");
                return false;
            }
        }
        //Read and add objects
        for (int i = 2; i<2+ numberOfObjects; i++) {
            tmp = inputLines[i].replace('(', ',');
            tmp2 = tmp.replace(')', ',');
            corTmp = tmp2.split(",");
            int id = i-2;

            Calculate object = new Calculate();
            //Point A
            corX = Double.parseDouble(corTmp[1]);
            corY = Double.parseDouble(corTmp[2].trim());
            corZ = Double.parseDouble(corTmp[3].trim());
            object.setPointA(new Cordination(corX, corY, corZ));
            //Point B
            corX = Double.parseDouble(corTmp[5]);
            corY = Double.parseDouble(corTmp[6].trim());
            corZ = Double.parseDouble(corTmp[7].trim());
            object.setPointB(new Cordination(corX, corY, corZ));
            //Point C
            corX = Double.parseDouble(corTmp[9]);
            corY = Double.parseDouble(corTmp[10].trim());
            corZ = Double.parseDouble(corTmp[11].trim());
            object.setPointC(new Cordination(corX, corY, corZ));
            //Point D
            corX = Double.parseDouble(corTmp[13]);
            corY = Double.parseDouble(corTmp[14].trim());
            corZ = Double.parseDouble(corTmp[15].trim());
            object.setPointD(new Cordination(corX, corY, corZ));
            //Point A1
            corX = Double.parseDouble(corTmp[17]);
            corY = Double.parseDouble(corTmp[18].trim());
            corZ = Double.parseDouble(corTmp[19].trim());
            object.setPointA1(new Cordination(corX, corY, corZ));
            //Point B1
            corX = Double.parseDouble(corTmp[21]);
            corY = Double.parseDouble(corTmp[22].trim());
            corZ = Double.parseDouble(corTmp[23].trim());
            object.setPointB1(new Cordination(corX, corY, corZ));
            //Point C1
            corX = Double.parseDouble(corTmp[25]);
            corY = Double.parseDouble(corTmp[26].trim());
            corZ = Double.parseDouble(corTmp[27].trim());
            object.setPointC1(new Cordination(corX, corY, corZ));
            //Point D1
            corX = Double.parseDouble(corTmp[29]);
            corY = Double.parseDouble(corTmp[30].trim());
            corZ = Double.parseDouble(corTmp[31].trim());
            object.setPointD1(new Cordination(corX, corY, corZ));
            //Set parameters of object

            //Add to objects
            double Z = object.getPointA1().getZ();
            if ( Z <= 0 || object.getPointB1().getZ() != Z || object.getPointC1().getZ() != Z || object.getPointD1().getZ() != Z ) {
                System.out.println("Vat the #" + id + " khong hop le");
            } else {
                // check hcn
                if (obj.checkRectangle(object.getPointA(), object.getPointB(), object.getPointC(), object.getPointD())) {
                    object.setParameter();
                    Calculate.objectsList.add(object);
                    int index = Calculate.objectsList.indexOf(object);
                    int check = obj.checkInRoom(obj, index);
                    if(check == 1) {
                        System.out.println(" vat nay dung that la nam tren san roi");
                    }
                    else if(check == 2)
                    {
                        System.out.println(" vat nay nam tren vat khac");
                    }
                    else {
                        Calculate.objectsList.remove(object);
                        System.out.println("Vat the #" + id + " khong hop le !!");
                    }
                } else {
                    System.out.println("Vat the #" + id + " khong hop le, khong phai la hinh chu nhat");
                }
            }
        }
        //Read and add cameras
        for (int i = numberOfObjects +3; i< numberOfObjects + numberOfCameras +3; i++) {
            int id = i - numberOfObjects -3;
            tmp = inputLines[i].replace('(', ' ');
            tmp2 = tmp.replace(')', ' ');
            String tmp3 = tmp2.replace(',',' ');
//            System.out.println(tmp3);
            corTmp = tmp3.split("\\s");
            corX = Double.parseDouble(corTmp[1]);
            corY = Double.parseDouble(corTmp[3]);
            corZ = Double.parseDouble(corTmp[5]);
            double sightCorner;
            sightCorner = Double.parseDouble(corTmp[7]);
            //Add to cameras
            if ((corX == Calculate.objectsList.get(0).getLength())&& (corY <=  Calculate.objectsList.get(0).getWidth() &&
                    (corZ <= Calculate.objectsList.get(0).getHeight()))  || ((corY == Calculate.objectsList.get(0).getWidth())
                    && (corX<= Calculate.objectsList.get(0).getHeight()) && (corZ <= Calculate.objectsList.get(0).getHeight()))  ||
                    ((corX==0) && (corY <= Calculate.objectsList.get(0).getWidth()) && (corZ <= Calculate.objectsList.get(0).getHeight())) ||
                    ((corY == 0) && (corX <= Calculate.objectsList.get(0).getLength()) && (corZ <= Calculate.objectsList.get(0).getHeight())) ){
                cameraList.add(new Camera(corX, corY, corZ, sightCorner));
                cameraList.get(id).setParameter();
            } else {
                System.out.println("Camera #" + id + "khong hop le");
            }
        }
        return true;
    }
    public int testFuncCheckInVisibleArea (Cordination point) {
        int id = 0;
        int result = 0;
        for (Camera camera : cameraList) {
            // check diem nam trong can phong
            if (obj.checkPointInObject(point, Calculate.objectsList.get(0))) {
                // check nam trong vung nhin thay cua camera hay khong
                if (camera.checkInVisibleArea(point)) {
                    // check diem co nam trong vat hay khong
                    for (int i = 1; i < Calculate.objectsList.size(); i++) {
                        if (obj.checkPointInObject(point, Calculate.objectsList.get(i))) {
                            return result = -1;
                        }
                        // xet dieu kien nhin thay
                        if(!obj.checkPointInVisibleArea(point, camera, i)){
                            result +=1;
                        }
                    }
                }
                else {
                    result += 1;
                }
                id++;
            }
        }

        return result;
    }
    public void percent()
    {
        Calculate obj = new Calculate();
        double numberPointOfRoom = obj.volumeOfObject(obj, 0) / (0.01 * 0.01 * 0.01);
        int number = (int) ( Math.round(numberPointOfRoom)) ;
        double numberPointOfObj = obj.volumeOfObject(obj, 1) / (0.01 * 0.01 * 0.01);
        int numberObj = (int) ( Math.round(numberPointOfObj)) ;
        // dem diem nhin thay
        int countCheck = 0;
        // dem diem ben trong vat
        int countCheck1 =0;
        // dem diem ko nhin thay ngoai vat
        int countCheck2 = 0;
        for( double x = 0.0 ; x < Calculate.objectsList.get(0).getLength() ; x += 0.01 )
        {
            for ( double y = 0.0 ; y < Calculate.objectsList.get(0).getWidth() ; y += 0.01)
            {
                for (double z = 0.0 ; z < Calculate.objectsList.get(0).getHeight() ; z += 0.01)
                {
                    Cordination pointCheck = new Cordination(x , y, z);
                    int check = testFuncCheckInVisibleArea(pointCheck);
                    if( check == -1)
                    {
                        countCheck1++;
                    }
                    else if( check == numberOfCameras)
                    {
                        countCheck2 ++;
                    }
                    else {
                        countCheck++;
                    }
                }
            }
        }
//        System.out.println("countCheck :"+ countCheck);
//        System.out.println("countCheck1 :"+ countCheck1);
//        System.out.println("countCheck2 :"+ countCheck2);
//        System.out.println("number point :"+ number);
//        System.out.println("number Obj :"+ numberObj);
        int percent = countCheck* 100 /number ;
        int percent1 = countCheck1 * 100 / number ;
        int percent2 = countCheck2 * 100 / number ;
        System.out.println("Phan tram the tich nhin thay duoc : " + percent + "%.");
        System.out.println("Phan tram the tich diem nam trong vat : " + percent1 + "%.");
        System.out.println("Phan tram the tich ko nhin thay ben ngoai vat : " + percent2 + "%.");
    }

    public void printParameters() {
        Calculate obj = new Calculate();
        //Print room
        System.out.println("Room: ");
        obj.objectsList.get(0).printParameters();
        //Print objects
        for (int i=0; i<numberOfObjects; i++) {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Object #" + i + ": ");
            obj.objectsList.get(i+1).printParameters();
        }
        //Print cameras
        for (int i=0; i<numberOfCameras; i++) {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Camera #" + i + ": ");
            cameraList.get(i).printParameter();
        }
    }

    public int getNumberOfObjects() {
        return numberOfObjects;
    }
}
