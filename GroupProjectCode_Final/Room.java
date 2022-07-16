import java.util.*;

public class Room {
    private String RoomName;
    private ArrayList<SearchableObject> RoomObjects;
    private ArrayList<Room> AdjacentRooms;

    public Room(String roomName, ArrayList<SearchableObject> roomObjects,
                ArrayList<Room> adjacentRooms) {
        this.RoomName = roomName;
        this.RoomObjects = roomObjects;
        this.AdjacentRooms = adjacentRooms;
    }

    public void setRoomName(String roomName) {this.RoomName = roomName;}
    public void setSearchableObjects(ArrayList<SearchableObject> objects) {this.RoomObjects = objects;}
    public void setAdjacentRoom(ArrayList<Room> rooms) {this.AdjacentRooms = rooms;}

    public String getRoomName() {return this.RoomName;}
    public String getAdjacentRooms() {
        String str = "";
        for(int i = 0; i < this.AdjacentRooms.size(); i++) {
            str += this.AdjacentRooms.get(i) + ", ";
        }
        return str;
    }

    @Override
    public String toString() {
        return getRoomName();
    }
}
