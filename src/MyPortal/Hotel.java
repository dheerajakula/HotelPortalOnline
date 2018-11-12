package MyPortal;

import java.util.List;

public class Hotel {
    public String name;
    public List<Room> roomsList;

    public Hotel(String name, List<Room> roomsList) {
        this.name = name;
        this.roomsList = roomsList;
    }
}
