package model;

public class Room implements IRoom{
    private String roomnumber;
    private Double price;
    private RoomType enumeration;

    private boolean isFree;

    public Room(String roomnumber,Double price,RoomType enumeration){
        super();
        this.roomnumber = roomnumber;
        this.price = price;
        this.enumeration = enumeration;
    }
    public Room(){
        super();
    }

    @Override
    public String getRoomNumber(){
        return roomnumber;
    }

    @Override
    public Double getRoomPrice(){
        return price;
    }

    @Override
    public RoomType getRoomType() {
        return enumeration;
    }

    @Override
    public boolean isFree() {
        return this.isFree;
    }

    public void setFree(boolean isEmpty){
        this.isFree = isEmpty;
    }

    public void setRoomnumber(String roomnumber) {
        this.roomnumber = roomnumber;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setEnumeration(RoomType enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public String toString() {
        return "ROOM NUMBER: "+this.roomnumber+" ROOM TYPE:"+this.enumeration+" PRICE:"+this.price+"\n";
    }
}
