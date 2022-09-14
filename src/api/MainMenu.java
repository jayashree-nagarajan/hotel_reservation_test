package api;

import model.IRoom;
import model.Room;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args){
        HotelResource hotelResource = new HotelResource();
        AdminMenu adminMenu = new AdminMenu();
        Scanner scanner = new Scanner(System.in);
        boolean active = true;
        try{
            do {
                System.out.println("MAIN MENU");
                System.out.println("1. Find and reserve a room");
                System.out.println("2. See my reservations");
                System.out.println("3. Create an account");
                System.out.println("4. Admin");
                System.out.println("5. Exit");
                System.out.println("Please enter your choice:");
                int userInput = scanner.nextInt();
                switch (userInput) {
                    case 1:
                        Scanner reserveScanner = new Scanner(System.in);
                        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
                        System.out.println("Find and reserve a room");
                        System.out.println("Enter the check in date (MM/dd/yyyy):");
                        Date checkInDate = null;
                        String dateInput = reserveScanner.nextLine();
                        if (dateInput != null && dateInput.trim().length() > 0) {
                            checkInDate = format.parse(dateInput);
                        }
                        System.out.println("Enter the check out date (MM/dd/yyyy):");
                        Date checkOutDate = null;
                        String chkOutDate = reserveScanner.nextLine();
                        if (chkOutDate != null && chkOutDate.trim().length() > 0) {
                            checkOutDate = format.parse(chkOutDate);
                        }
                        List<Room> roomList = hotelResource.findARoom(checkInDate, checkOutDate);
                        System.out.println(roomList);
                        System.out.println("Enter the customer email :");
                        String customerEmail = reserveScanner.nextLine();
                        while(hotelResource.validateEmail(customerEmail) == false){
                            System.out.println("Please enter the valid email (xyz@domain.com):");
                            customerEmail = reserveScanner.nextLine();
                        }

                        System.out.println("Enter the room number to book:");
                        String roomNumber = reserveScanner.nextLine();
                        hotelResource.bookARoom(customerEmail, hotelResource.getRoom(roomNumber), checkInDate, checkOutDate);
                        break;
                    case 2:
                        System.out.println("SEE MY RESERVATION");
                        System.out.println("Please Enter your email:");
                        Scanner displayCustScanner = new Scanner(System.in);
                        String custInputEmail = displayCustScanner.nextLine();
                        System.out.println("Customers Reservation:\n" + hotelResource.getCustomersReservations(custInputEmail));
                        break;
                    case 3:
                        Scanner customerInput = new Scanner(System.in);
                        System.out.println("Enter Customer Firstname :");
                        String custFirstName = customerInput.nextLine();
                        System.out.println("Enter Customer LastName :");
                        String custLastName = customerInput.nextLine();
                        System.out.println("Enter Customer Email :");
                        String custEmail = customerInput.nextLine();
                        while(hotelResource.validateEmail(custEmail) == false){
                            System.out.println("Please enter the valid email (xyz@domain.com):");
                            custEmail = customerInput.nextLine();
                        }
                        hotelResource.createCustomer(custEmail, custFirstName, custLastName);
                        break;
                    case 4:
                        adminMenu.displayAdminMenu();
                        break;
                    case 5:
                        System.exit(0);
                }
            }while(active);
        }
        catch(Exception e){
            e.getLocalizedMessage();
        }
        finally{
            //scanner.close();
        }


    }



    public void displayMainMenu(){




    }
}
