package customer;

import object.Cordination;
import object.Things;
import java.util.Scanner;

public class VisibleArea {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\Laptop88_LTV\\Documents\\OOLT lab\\OOLT_Project\\input.txt";
        Things thing = new Things();
        // MENU
        Scanner choose = new Scanner(System.in);
        Scanner inputPoint = new Scanner(System.in);
        boolean read = false;
        boolean cont = true;
        do {
            System.out.println("------------------MENU MANAGEMENT APPLICATION---------------");
            System.out.println("------------------------------------------------------------");
            System.out.println("1.Read input file.");
            System.out.println("2.Print all parameters of the room.");
            System.out.println("3.Check one point is visible or invisible.");
            System.out.println("4.Percent of volume of visible,the point in the object,invisible outside the object.");
            System.out.println("0.Exit.");
            System.out.println("Please choose a number:[0-4]");
            int k = choose.nextInt();
            switch (k) {
                case 1:
                    thing.readInputFile(fileName);
                    read = true;
                    break;
                case 2:
                    if(read == false) {
                        System.out.println("You have not read the input file.");
                        break;
                    }
                    else {
                        thing.printParameters();
                        break;
                    }
                case 3:
                    if(read == false) {
                        System.out.println("You have not read the input file.");
                        break;
                    }
                    else {
                        double x,y,z;
                        System.out.println("Enter x-Cordination of the point:");
                        x = inputPoint.nextDouble();
                        System.out.println("Enter the y-Cordination of the point:");
                        y = inputPoint.nextDouble();
                        System.out.println("Enter the z-Cordination of the point:");
                        z = inputPoint.nextDouble();
                        int result = thing.testFuncCheckInVisibleArea(new Cordination(x,y,z));
                        if (result == -1) {
                            System.out.println("This point is invisible inside the object.");
                        }
                        else if (result == thing.getNumberOfObjects()) {
                            System.out.println("This point is invisible outside objects.");
                        }
                        else {
                            System.out.println("This point is visible.");
                        }
                        break;
                    }
                case 4:
                    if(read == false) {
                        System.out.println("You have not read the input file.");
                        break;
                    }
                    else {
                        thing.percent();
                        break;
                    }
                case 0:
                    System.out.println("Goodbye!");
                    cont = false;
                    break;
                default:
                    System.out.println("You have entered an invalid number!!! Please choose again!!");
                    break;
            }
        } while (cont);
        System.exit(0);
    }
}
