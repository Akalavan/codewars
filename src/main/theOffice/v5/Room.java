package main.theOffice.v5;

public class Room {

    String occupants;
    int chairs;

    public Room(String person, int charis) {
        this.occupants = person;
        this.chairs = charis;
    }

    public String getOccupants() {
        return occupants;
    }

    public void setOccupants(String occupants) {
        this.occupants = occupants;
    }

    public int getChairs() {
        return chairs;
    }

    public void setChairs(int chairs) {
        this.chairs = chairs;
    }
}
