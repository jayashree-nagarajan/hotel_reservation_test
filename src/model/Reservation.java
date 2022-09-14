package model;

import java.util.Date;

public class Reservation {
    private Customer customer;
    private Room room;
    private Date checkInDate;
    private Date checkOutDate;

    public Reservation(Customer customer,Room room,Date checkInDate,Date checkOutDate){
        super();
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString(){
        return "Customer :"+customer+" room:"+room+" checkInDate:"+checkInDate+" checkOutDate:"+checkOutDate;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public IRoom getRoom() {
        return room;
    }
}
