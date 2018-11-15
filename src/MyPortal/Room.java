package MyPortal;

public class Room {
    public int id;
    public String name;
    public float cost;
    public boolean isAvailable;
    public boolean isBreakfast;
    public boolean isWifi;
    public String description;

    public Room(int id, String name, float cost, boolean isBreakfast, boolean isWifi, String description) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.isBreakfast = isBreakfast;
        this.isWifi = isWifi;
        this.description = description;
    }
}
