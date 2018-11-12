package MyPortal;

import java.util.List;

public class City {
    public String name;
    public List<Hotel> hotelsList;

    public City(String name, List<Hotel> hotelsList) {
        this.name = name;
        this.hotelsList = hotelsList;
    }
}
