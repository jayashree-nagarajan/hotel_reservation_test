package model;

public class FreeRoom extends Room{

    public FreeRoom(String roomnumber, Double price, RoomType enumeration) {
        super(roomnumber, (double)0 , enumeration);
        this.setFree(true);
    }

    @Override
    public String toString(){
        return super.toString()+"Free Room class";
    }
}
