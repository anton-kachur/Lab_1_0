class Road
{
    private String road_type;
    private int number_of_lanes;

    Road(String type, int num) {
        road_type = type;
        number_of_lanes = num;
    }

    String printAll() {
        System.out.println("Road type: " + road_type + "\nNumber of lanes: " + number_of_lanes);
        return "Road type: " + road_type + "\nNumber of lanes: " + number_of_lanes;
    }
}
