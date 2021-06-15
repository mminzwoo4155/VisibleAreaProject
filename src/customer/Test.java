package customer;

import java.util.Scanner;
import object.Things;

public class Test {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\Laptop88_LTV\\Documents\\OOLT lab\\OOLT_Project\\input.txt";
        Things thing = new Things();
        // MENU
        Scanner choose = new Scanner(System.in);
        boolean read = false;
        boolean cont = true;
        double x,y,z;
        do {
            System.out.println("------------------MENU MANAGEMENT APPLICATION---------------");
            System.out.println("------------------------------------------------------------");
            System.out.println("1.Read input file.");
            System.out.println("2.Percent of volume of visible,the point in the object,invisible outside the object.");
            System.out.println("0.Exit.");
            System.out.println("Please choose a number:[0-2]");
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
                        thing.percent();
                        break;
                    }
                case 0:
                    System.out.println("Goodbye");
                    cont = false;
                    break;
                default:
                    System.out.println("You have entered an invalid number!!! Please choose again.");
                    break;
            }
        } while (cont);
        System.exit(0);
    }
}

