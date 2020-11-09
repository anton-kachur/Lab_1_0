import java.lang.String;
import java.util.*;
import java.lang.*;

//Anton Kachur TI-82
//Task: 7.Create a map using Java

public class Java_lab1 {

    static class MyException extends Exception{
        private int number;
        int getNumber(){return number;}

        MyException() {}
        MyException(String message, int num){
            super(message);
            number = num;
        }
    }

    static String [] road_types = {"Dirt", "Asphalt", "Paving stone"};
    static String [] reservoir_types = {"Lake", "Sea", "Swamp", "River"};
    static String [] locality_types = {"City", "Village", "Settlement"};
    static String [] trees_types = {"Forest", "Steppe", "Forest-steppe"};
    static String [] relief_types = {"Lowland", "Elevation", "Plateau", "Mountain", "Hollow"};
    static Scanner input = new Scanner(System.in);


    //**************************Generates random name************************************************
    static String generateName() {
        Random random = new Random();
        StringBuilder name = new StringBuilder();

        for (int i=0; i<random.nextInt(50)+2; i++) {
            name.append(Character.toString((char)random.nextInt(25)+97));
        }

        System.out.println(name.toString());

        return name.toString().substring(0, 1).toUpperCase() + name.toString().substring(1);
    }


    public static void main (String []args)
    {
        MapCreator new_map = new MapCreator();
        App app = new App(new_map);
        System.out.println("What kind of map do you want?\n1->Random map;\n2->Custom map;\nYour choice: ");

        switch (input.nextInt()) {
            case 1: app.makeMap(1); break;
            case 2: app.makeMap(2); break;
            default: System.out.println("Invalid input"); break;
        }

    }
}
