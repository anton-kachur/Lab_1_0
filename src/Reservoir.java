class Reservoir
{
    private String reservoir_type;
    private double depth;

    Reservoir(String type, double d) {
        reservoir_type = type;
        depth = d;
    }

    String printAll() {
        System.out.println("Reservoir type: " + reservoir_type + "\nDepth: " + depth);
        return "Reservoir type: " + reservoir_type + "\nDepth: " + depth;
    }
}