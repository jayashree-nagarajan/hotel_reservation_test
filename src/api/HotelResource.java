package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;
import service.CustomerService;
import service.ReservationService;

import java.util.Date;
import java.util.List;

public class HotelResource {
    private CustomerService customerService = new CustomerService();
    private ReservationService reservationService =new ReservationService();
    public Customer getCustomer(String email){
        return customerService.getCustomer(email);
    }
    public void createCustomer(String email,String firstName, String lastName){
        customerService.addCustomer(email,firstName,lastName);
    }
    public Room getRoom(String roomNumber){
        return reservationService.getARoom(roomNumber);
    }
    public Reservation bookARoom(String customerEmail, Room room, Date checkInDate, Date checkOutDate){

        return reservationService.reserveARoom(customerService.getCustomer(customerEmail),room,checkInDate,checkOutDate);
    }

    public List<Reservation> getCustomersReservations(String customerEmail){
        return reservationService.getCustomerReservation(customerService.getCustomer(customerEmail));
    }
    public boolean validateEmail(String email){
        return customerService.validateEmail(email);
    }

    public List<Room> findARoom(Date checkIn, Date checkOut){
        return reservationService.findRooms(checkIn,checkOut);
    }
}
