package api;

import model.Customer;
import model.IRoom;
import model.Room;
import model.RoomType;
import service.CustomerService;
import service.ReservationService;

import java.util.List;
import java.util.Map;

public class AdminResource {
    private CustomerService customerService = new CustomerService();
    private ReservationService reservationService = new ReservationService();
    public Customer getCustomer(String email){
        return customerService.getCustomer(email);
    }
    public void addRoom(String roomNumber, RoomType type,Double price){
        System.out.println("Inside AdminResource");
        reservationService.addRoom(roomNumber,type,price);
    }
    public void addFreeRoom(String roomNumber, RoomType type){
        System.out.println("Inside AdminResource addFreeRoom");
        reservationService.addFreeRoom(roomNumber,type);
    }
    public void getAllRooms(){
         reservationService.printAllRooms();
    }

    public Map<String,Customer> getAllCustomers(){
        //System.out.println("AdminResource getAllCustomers()");
        //customerService.addCustomer("abcd@aa.com","AAA","JJJ");
        return customerService.getAllCustomers();
    }
    public void displayAllReservations(){

        reservationService.printAllReservation();
    }
}
