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



    @Override
    public String toString() {
        return "Room Number: "+this.roomnumber+" Room Type:"+this.enumeration+" Price:"+this.price+" IsFree:"+isFree+"\n";
    }
}
