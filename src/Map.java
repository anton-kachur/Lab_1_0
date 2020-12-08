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

    Integer sumOfReliefs() {
        return reliefs.stream().mapToInt(x -> x.getHeight()).sum();
    }

    String maxOfReliefs() {
        Relief r = reliefs.stream().max(Comparator.comparing(Relief::getHeight)).orElseThrow(NoSuchElementException::new);
        return r.getType() + " " + r.getHeight();
    }

    String averageOfReliefs() {
        return " " + reliefs.stream().mapToInt((x) -> x.getHeight()).summaryStatistics().getAverage();
    }

    List<Relief> mapCondition() {
        List<Relief> result = reliefs.stream().map(temp -> {
            Relief obj = new Relief(temp.getHeight(), temp.getType());
            if ("Mountain".equals(temp.getType())) {
                obj.setMessage("High relief");
            }
            else {
                obj.setMessage("Low relief");
            }

            return obj;
        }).collect(Collectors.toList());

        return result;
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




    String getMostPopular() {
        ArrayList<Building> b = new ArrayList<>();

        for (int i=1; i<buildings.size(); i++) {
            b.add(new Locality(buildings.get(i-1).getName_of_locality(), buildings.get(i-1).getName_of_building(), buildings.get(i-1).getNum_building()));
        }

        return b.stream().collect(Collectors.groupingBy(Building::getName_of_locality, Collectors.counting())).entrySet().stream().max(Comparator.comparing(java.util.Map.Entry::getValue)).get().getKey();

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


        System.out.println("Sum of reliefs: "+sumOfReliefs());
        System.out.println("Max of reliefs: "+maxOfReliefs());
        System.out.println("Average of reliefs: "+averageOfReliefs());
        System.out.println("Map with conditions: ");

        List<Relief> res = mapCondition();

        for (int i = 0; i<res.size(); i++) {
            System.out.println(res.get(i).getType());
            System.out.println(res.get(i).getHeight());
            System.out.println(res.get(i).getMessage());
        }

        System.out.println("Most popular name: "+getMostPopular());



        return false;
    }
}
