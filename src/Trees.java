class Trees
{
    private String name;
    private String type;

    Trees(String name, String type) {
        this.name = name;
        this.type = type;
    }

    String printAll() {
        System.out.println("Name: " + name + "\nType: " + type);
        return "Name: " + name + "\nType: " + type;
    }
}