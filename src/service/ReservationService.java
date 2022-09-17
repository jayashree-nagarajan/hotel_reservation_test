package service;

import model.*;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReservationService {

    private Room room;
    private FreeRoom freeRoom;
    private static List<Reservation> customerReservation= new LinkedList<Reservation>();
    private static Map<String,Room> roomCollection = new HashMap<String,Room>();
    private static Map<String,FreeRoom> freeRoomList = new HashMap<String,FreeRoom>();

    private static  Map<String,Room> emptyRoomList = new HashMap<String,Room>();
    public void addRoom(String roomNumber, RoomType type, Double price){
        room = new Room(roomNumber,price,type);
        room.setFree(true);
        roomCollection.put(room.getRoomNumber(),room);
        //emptyRoomList.add(room);
        //for( Room room : roomCollection) {
        for(Room roomId : roomCollection.values()){
            System.out.println("Rooms list:");
            System.out.println(roomId);
        }
    }
    public void addFreeRoom(String roomNumber, RoomType type){
        freeRoom = new FreeRoom(roomNumber,type);
        freeRoom.setFree(true);
        freeRoomList.put(roomNumber,freeRoom);
        //emptyRoomList.add(room);
        //for( Room room : roomCollection) {
        for(FreeRoom roomId : freeRoomList.values()){
            System.out.println("Rooms list:");
            System.out.println(roomId);
        }
        if(!freeRoomList.isEmpty()){
            roomCollection.putAll(freeRoomList);
        }
    }
    public Room getARoom(String roomId){
        //for(Room roomList : roomCollection){
        //System.out.println("Reservation Service : getARoom :" + roomCollection.get(roomId));
        return roomCollection.get(roomId);
    }
    public void reserveARoom(Customer customer,Room room,Date checkInDate,Date checkOutDate){
        //System.out.println("Inside ReservationService reserveARoom:"+customer);
        //Reservation reservation = null;
        boolean reservationSuccess = false;
        if(customer!=null){
            Reservation reservation = new Reservation(customer,room,checkInDate,checkOutDate);
            for(String emptyRoomNo : emptyRoomList.keySet()){
                if(reservation.getRoom().getRoomNumber().equals(emptyRoomNo)){
                    //System.out.println("Adding rooms to the reservation");
                    customerReservation.add(reservation);
                    reservationSuccess = true;
                }

            }
        }


        if(!reservationSuccess && customer == null){
            System.out.println("Invalid customer info!!");
        }
        else if(!reservationSuccess){
            System.out.println("Reservation failed");
        }
        else{
            System.out.println("Reservation successfull");
        }

        //System.out.println("List customerReservation :"+customerReservation);
        //System.out.println("Reserved room :"+reservation);
        //return reservation;
    }
    public Map<String,Room> findRooms(Date checkInDate,Date checkOutDate){
        //System.out.println("Checking finRooms method");
        //List<Room> emptyRoomList = new LinkedList<Room>();
        emptyRoomList.clear();
        emptyRoomList.putAll(roomCollection);
        for(Reservation resrvList : customerReservation){
            //System.out.println("Checking customer reservation.."+resrvList.getCheckInDate());
            if(resrvList.getCheckInDate().equals(checkInDate)){
                     //System.out.println("Reserved room inside findRooms:"+resrvList.getRoom());
                     emptyRoomList.remove(resrvList.getRoom().getRoomNumber());
            }

        }
        return emptyRoomList;

        }
    public List<Reservation> getCustomerReservation(Customer customer){
        List<Reservation> customerList = new LinkedList<Reservation>();
        Reservation custReservation;
        if(customer == null){
            System.out.println("Invalid customer info!!");

        }
        else{
            for(Reservation rsrv : customerReservation){
                        if(customer.equals(rsrv.getCustomer())){
                            customerList.add(rsrv);
                        }
            }

        }
        return customerList;
    }
    public void printAllReservation(){
        System.out.println("PRINT ALL RESERVATION");
        if(customerReservation.isEmpty()){
            System.out.println("No reservations yet!!");
        }
        else {
            for(Reservation reservation : customerReservation){
                System.out.println(reservation);
            }
        }

    }
    public void printAllRooms(){
        if(roomCollection.isEmpty()){
            System.out.println("No rooms available");
        }
        else {
            for(Room roomList : roomCollection.values()){
                System.out.println(roomList);
            }
        }

    }
    public boolean validateDate(String inputDate) throws Exception{
        Date checkInDate = null;
        String dateRegex = "(((0[0-9])|(1[012]))\\/((0[1-9])|([12][0-9])|(3[01]))\\/((20[012]\\d|19\\d\\d)|(1\\d|2[0123])))";
        Pattern pattern = Pattern.compile(dateRegex);
        Matcher matcher = pattern.matcher(inputDate);
        return matcher.matches();
    }


}
