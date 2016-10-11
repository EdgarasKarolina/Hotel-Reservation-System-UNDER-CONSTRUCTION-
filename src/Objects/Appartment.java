package Objects;

/**
 * Created by Edgaras on 19/08/2016.
 */
public class Appartment {

    int appartmentId;
    String appartmentName;
    int numberOfRooms;
    int maxNumberOfGuests;
    int whichFloor;
    int size;
    String roomInfo;

    public Appartment(int appartmentId, String appartmentName, int numberOfRooms, int maxNumberOfGuests, int whichFloor, int size, String roomInfo) {
        this.appartmentId = appartmentId;
        this.appartmentName = appartmentName;
        this.numberOfRooms = numberOfRooms;
        this.maxNumberOfGuests = maxNumberOfGuests;
        this.whichFloor = whichFloor;
        this.size = size;
        this.roomInfo = roomInfo;
    }

    public int getAppartmentId() {
        return appartmentId;
    }

    public String getAppartmentName() {return  appartmentName; }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public int getMaxNumberOfGuests() {
        return maxNumberOfGuests;
    }

    public int getWhichFloor() {
        return whichFloor;
    }

    public int getSize() {
        return size;
    }

    public String getRoomInfo() {
        return roomInfo;
    }


}
