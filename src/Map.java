import java.util.*;
import java.util.stream.Collectors;


class Map
{
    //*************************************************************************************************
    //**********************Nested class, because each map has its own relief**************************
    //*************************************************************************************************
    static class Relief
    {
        private String name;
        private int height;
        private String message;

        //*********Sets name of relief based on its height above the sea level***************************
        Relief(int h, String name_rel) {
            name = name_rel;
            height = h;
            message = "";
            if (height > 0 && height < 200) name = Java_lab1.relief_types[0];
            else if (height > 200 && height < 500) name = Java_lab1.relief_types[1];
            else if (height > 500 && height < 2000) name = Java_lab1.relief_types[2];
            else if (height > 2000) name = Java_lab1.relief_types[3];
            else name = Java_lab1.relief_types[4];
        }

        int getHeight() {
            return height;
        }

        void setMessage(String s) {
            message = s;
        }

        String getMessage() {
            return message;
        }

        String getType() {
            return name;
        }

        String printAll() {
            System.out.println("Name of relief: " + name + "\nMeasure of relief: " + height);
            return "Name of relief: " + name + "\nMeasure of relief: " + height;
        }

    }




    //***********************ArrayLists which contain map components**************************************
    Scale scale;
    String timezone;
    ArrayList<Road> roads = new ArrayList<>();
    ArrayList<Reservoir> reservoirs = new ArrayList<>();
    ArrayList<Building> buildings = new ArrayList<>();
    ArrayList<Locality> localities = new ArrayList<>();
    ArrayList<Trees> trees = new ArrayList<>();
    ArrayList<Relief> reliefs = new ArrayList<>();

    //*************Function, that represents the list of localities on alphabetical order*****************

    ArrayList listOfLocalities() {
        if (localities.size() < 1) {
            System.out.println("\nThere is no localities\n");
        } else {
            Collections.sort(localities, Comparator.comparing(Locality::getName));
            System.out.println("All localities in alphabetic order: ");

            for (int i=0; i<localities.size(); i++)
                System.out.println(localities.get(i).locality_name);
        }
        return localities;
    }

    Locality findDuplicates() {
        if (localities.size() < 1) {
            System.out.println("\nThere is no localities\n");
        } else {
            for (int i=1; i<localities.size(); i++) {
                if (localities.get(i-1).getName().equals(localities.get(i).getName())) {
                    System.out.println("There are duplicates: "+localities.get(i-1));
                    return localities.get(i);
                }
            }

        }
        return null;
    }


    private boolean equals(Map obj) {
        return obj==null;
    }

    //**************Methods for setting map components and representing them*****************************
    boolean printMap() {
        if (equals(this)) {
            System.out.println("Map is empty!");
            return true;
        }
        for (Road i : roads) i.printAll();
        for (Reservoir i : reservoirs) i.printAll();
        for (Building i : buildings) i.printAll();

        //With string concatenation with the other types
        for (Locality i : localities) i.printAll();
        //And not
        for (Locality i : localities) i.printAll(false);

        for (Trees i : trees) i.printAll();
        for (Relief i : reliefs) i.printAll();
        System.out.println("Map scale: "+scale+" Timezone: "+timezone);

        return false;
    }
}
