package MyPortal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
public class User {

    public String name;
    public Date dob;
    public String address;
    public String email;

    public User(String name, String doB, String address, String email) throws ParseException {
        SimpleDateFormat objSDF = new SimpleDateFormat("yyyy-MM-dd");
        this.name = name;
        this.dob = objSDF.parse(doB);
        this.address = address;
        this.email = email;
    }
}
