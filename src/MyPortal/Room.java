package MyPortal;

public class Room {
    public boolean isAvailable;
    public boolean isBreakfast;
    public boolean isWifi;
    public int cost;
    public String name;
    public String description;

    public Room(boolean isAvailable, boolean isBreakfast, boolean isWifi, int cost, String name, String description) {
        this.isAvailable = isAvailable;
        this.isBreakfast = isBreakfast;
        this.isWifi = isWifi;
        this.cost = cost;
        this.name = name;
        this.description = description;
    }
}
