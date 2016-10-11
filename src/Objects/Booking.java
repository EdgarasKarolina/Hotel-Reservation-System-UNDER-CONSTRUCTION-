package Objects;

import java.sql.Date;

/**
 * Created by Edgaras on 21/08/2016.
 */
public class Booking {

    String appartmentName;
    Date date;
    int appartmentId;


    public Booking(String appartmentName, Date date, int appartmentId)
    {
        this.appartmentName = appartmentName;
        this.date = date;
        this.appartmentId = appartmentId;
    }

    public Date getDate() {
        return date;
    }

    public int getAppartmentId() {
        return appartmentId;
    }

    public String getAppartmentName() { return  appartmentName; }
}
