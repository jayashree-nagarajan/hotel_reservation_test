package model;

public class FreeRoom extends Room{
    private final double price = 0;
    public FreeRoom(String roomnumber, RoomType enumeration) {
        super();
        this.setRoomnumber(roomnumber);
        this.setEnumeration(enumeration);
        this.setPrice(price);
        this.setFree(true);
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
