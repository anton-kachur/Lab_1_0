public class Locality extends Building
{
    String locality_name;
    private String locality_type;

    Locality(String name, String type, int n) {

        super("Default name", name, n);

        locality_name = name;
        locality_type = type;
    }

    String getName() { return locality_name; }

    public String printAll() {
        System.out.println("Name of locality: " + locality_name + "\nType of locality: " + locality_type);
        return "Name of locality: " + locality_name + "\nType of locality: " + locality_type;
    }

    String printAll(boolean b) {
        if (b) {
            System.out.println("Name of locality: " + locality_name + "\nType of locality: " + locality_type);
            return "Name of locality: " + locality_name + "\nType of locality: " + locality_type;
        }else {
            System.out.println("Name of locality: " + locality_name + "\nType of locality: " + locality_type);
            System.out.println("Name of building in locality: " + name_of_building + num_building);
            return "Name of locality: " + locality_name + "\nType of locality: " + locality_type +
                    "\nName of building in locality: " + name_of_building + num_building;
        }
    }
}