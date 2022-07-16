public class SearchableObject {
    private String ObjectName;
    private Room Location;
    private boolean HoldsKey;
    private String Dialogue;

    public SearchableObject(String objectName, Room location, boolean holdsKey, String dialogue) {
        this.ObjectName = objectName;
        this.Location = location;
        this.HoldsKey = holdsKey;
        this.Dialogue = dialogue;
    }

    public void setName(String name) {this.ObjectName = name;}
    public void setHoldsKey(boolean holdsKey) {this.HoldsKey = holdsKey;}
    public void setDialogue(String dialogue) {this.Dialogue = dialogue;}
    public void setLocation(Room room) {this.Location = room;}

    public String getName() {return this.ObjectName;}
    public boolean getHoldsKey() {return this.HoldsKey;}
    public String getDialogue() {return this.Dialogue;}
    public Room getLocation() {return this.Location;}

    @Override
    public String toString() {
        if(this.HoldsKey) {
            return this.ObjectName + " - HAS KEY";
        }
        else {
            return this.ObjectName + " - no key";
        }
    }
}
