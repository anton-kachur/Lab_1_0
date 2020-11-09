import java.util.ArrayList;
import java.util.Random;

class MapCreator extends Java_lab1.MyException
{
    //композиция и ассоциация
    private Map map;
    private Random random = new Random();

    MapCreator () {
        map = new Map();
    }

     void setRoads(int n, boolean b) throws Java_lab1.MyException {
        if (n < 0) throw new Java_lab1.MyException("The number is less than 1", n);
        for (int i=0; i<n; i++) {
            if (b) {
                System.out.println("\nTypes of roads: ");
                for (int j = 0; j< Java_lab1.road_types.length; j++) {
                    System.out.println(j+") "+ Java_lab1.road_types[j]);
                }
                System.out.println("\nEnter road type and number of lanes: ");
                map.roads.add(new Road(Java_lab1.road_types[Java_lab1.input.nextInt()], Java_lab1.input.nextInt()));

            }
            else
                map.roads.add(new Road(Java_lab1.road_types[random.nextInt(Java_lab1.road_types.length)], random.nextInt(7)));
        }
    }

     void setReservoirs(int n, boolean b) throws Java_lab1.MyException {
        if (n < 0) throw new Java_lab1.MyException("The number is less than 1", n);
        for (int i=0; i<n; i++) {
            if (b) {
                System.out.println("\nTypes of reservoirs: ");
                for (int j = 0; j< Java_lab1.reservoir_types.length; j++) {
                    System.out.println(j+") "+ Java_lab1.reservoir_types[j]);
                }
                System.out.println("\nEnter reservoir type and its depth: ");
                map.reservoirs.add(new Reservoir(Java_lab1.reservoir_types[Java_lab1.input.nextInt()], Java_lab1.input.nextDouble()));

            }
            else
                map.reservoirs.add(new Reservoir(Java_lab1.reservoir_types[random.nextInt(Java_lab1.reservoir_types.length)], random.nextInt(1000)));
        }
    }
     void setBuildings(int n, boolean b) throws Java_lab1.MyException {
        if (n < 0) throw new Java_lab1.MyException("The number is less than 1", n);
        for (int i=0; i<n; i++) {
            if (b) {
                System.out.println("\nEnter name of building and name of locality: ");
                map.buildings.add(new Building(Java_lab1.input.nextLine(), Java_lab1.input.nextLine(), random.nextInt(50)));
            }
            else
                map.buildings.add(new Building(Java_lab1.generateName(), Java_lab1.locality_types[random.nextInt(Java_lab1.locality_types.length)], random.nextInt(50)));
        }
    }
     ArrayList setLocalities(int n, boolean b) throws Java_lab1.MyException {
        if (n < 0) throw new Java_lab1.MyException("The number is less than 1", n);
        for (int i=0; i<n; i++) {
            if (b) {
                System.out.println("\nEnter name and type of locality: ");
                map.localities.add(new Locality(Java_lab1.input.nextLine(), Java_lab1.input.nextLine(), random.nextInt(50)));
            }
            else
                map.localities.add(new Locality(Java_lab1.generateName(), Java_lab1.locality_types[random.nextInt(Java_lab1.locality_types.length)], random.nextInt(50)));
        }
        return map.localities;
    }
     void setTrees(int n, boolean b) throws Java_lab1.MyException {
        if (n < 0) throw new Java_lab1.MyException("The number is less than 1", n);
        for (int i=0; i<n; i++) {
            if (b) {
                System.out.println("\nEnter name and type of trees: ");
                map.trees.add(new Trees(Java_lab1.input.nextLine(), Java_lab1.input.nextLine()));
            }
            else
                map.trees.add(new Trees("Something", Java_lab1.trees_types[random.nextInt(Java_lab1.trees_types.length)]));
        }
    }
     void setRelief(int n, boolean b) throws Java_lab1.MyException {
        if (n < 0) throw new Java_lab1.MyException("The number is less than 1", n);
        for (int i=0; i<n; i++) {
            if (b) {
                System.out.println("\nEnter name and height of relief: ");
                map.reliefs.add(new Map.Relief(Java_lab1.input.nextInt(), Java_lab1.input.nextLine()));
            }
            else
                map.reliefs.add(new Map.Relief(random.nextInt(5000), "Something"));
        }
    }
    String setScale(Scale s, int n) {
        map.scale = s;
        map.timezone = map.scale.setTimeZone(n);
        return "Scale: " + map.scale + "\n" + map.timezone;
    }

   Map resultMap() { return map; }
}