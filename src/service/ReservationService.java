package service;

import model.*;

import java.util.*;

public class ReservationService {

    private Room room;
    private static List<Reservation> customerReservation= new LinkedList<Reservation>();
    private static List<Room> roomCollection = new LinkedList<Room>();

    private static  List<FreeRoom> freeRoomList = new LinkedList<FreeRoom>();
    public void addRoom(String roomNumber, RoomType type, Double price){
        room = new Room(roomNumber,price,type);
        room.setFree(true);
        roomCollection.add(room);
        for( Room room : roomCollection) {
            System.out.println("Rooms list:");
            System.out.println(room);
        }
    }
    public Room getARoom(String roomId){
        for(Room roomList : roomCollection){
            if (roomList.getRoomNumber().equals(roomId)){
                room = roomList;
            }
        }
        System.out.println("Reservation Service : getARoom :" + room);
        return room;
    }
    public Reservation reserveARoom(Customer customer,Room room,Date checkInDate,Date checkOutDate){
        System.out.println("Inside ReservationService reserveARoom:");
        Reservation reservation = new Reservation(customer,room,checkInDate,checkOutDate);
        System.out.println(room.isFree());
        if(room.isFree()) {
            room.setFree(false);
            customerReservation.add(reservation);
        }
        System.out.println("List customerReservation :"+customerReservation);
        System.out.println("Reserved room :"+reservation);
        return reservation;
    }
    public List<Room> findRooms(Date checkInDate,Date checkOutDate){
        List<Room> emptyRoomList = new LinkedList<Room>();
        for(Room room : roomCollection){
            System.out.println("Find Rooms : isEmpty --"+room.isFree());
            if(room.isFree()){
                emptyRoomList.add(room);
            }
        }
        return emptyRoomList;
    }
    public List<Reservation> getCustomerReservation(Customer customer){

        return customerReservation;
    }
    public void printAllReservation(){
        System.out.println("PRINT ALL RESERVATION");
        for(Reservation reservation : customerReservation){
            System.out.println(reservation);
        }
    }
    public void printAllRooms(){
        for(Room roomList : roomCollection){
            System.out.println(roomList);
        }
    }


}
