package api;

import model.IRoom;
import model.Reservation;
import model.Room;
import service.ReservationService;

import java.text.SimpleDateFormat;
import java.util.*;

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
                        Date today =new Date();
                        System.out.println("Find and reserve a room");

                        Date checkInDate = null;
                        boolean validateCheckInDate = true;
                        String dateInput;
                        while(validateCheckInDate){
                            System.out.println("Enter the check in date (MM/dd/yyyy):");
                            dateInput = reserveScanner.nextLine();
                            if(hotelResource.validateDate(dateInput)){
                                if (dateInput != null && dateInput.trim().length() > 0) {
                                    checkInDate = format.parse(dateInput);
                                    if(checkInDate.before(today)){
                                        System.out.println("Please enter a valid date after "+today);
                                        validateCheckInDate = true;
                                    }
                                    else {
                                        validateCheckInDate = false;
                                    }

                                }
                            }
                            else{
                                validateCheckInDate = true;

                            }

                        }
                        boolean validateCheckOutDate = true;
                        Date checkOutDate = null;
                        while(validateCheckOutDate){
                            System.out.println("Enter the check out date (MM/dd/yyyy):");
                            String chkOutDate = reserveScanner.nextLine();
                            if(hotelResource.validateDate(chkOutDate)){
                                if (chkOutDate != null && chkOutDate.trim().length() > 0) {
                                    checkOutDate = format.parse(chkOutDate);
                                    if(checkOutDate.before(checkInDate)){
                                        System.out.println("Please enter the valid checkout date after "+checkInDate);
                                        validateCheckOutDate= true;
                                    }
                                    else{
                                        validateCheckOutDate = false;
                                    }
                                }
                            }
                            else{
                                validateCheckOutDate = true;
                            }

                        }


                        Map<String,Room> roomList = hotelResource.findARoom(checkInDate, checkOutDate);
                        Calendar calendar = Calendar.getInstance();

                        if(roomList.isEmpty()){
                            Date newInDate;
                            calendar.setTime(checkInDate);
                            calendar.add(Calendar.DATE,7);
                            newInDate = calendar.getTime();
                            System.out.println("No rooms available on the selected dates. ");
                            System.out.println("Do you want to check rooms for "+newInDate);
                            System.out.println("Enter y for yes \n n for no:");
                            String option = reserveScanner.nextLine();
                            if(option.equals("y")){
                                checkInDate = newInDate;
                                calendar.setTime(checkOutDate);
                                calendar.add(Calendar.DATE,7);
                                checkOutDate = calendar.getTime();
                                //System.out.println("New Dates : "+checkInDate+checkOutDate);
                            }
                            else{
                                break;
                            }
                        }
                        roomList = hotelResource.findARoom(checkInDate, checkOutDate);
                        System.out.println("Rooms available for booking :\n"+roomList);
                        if(roomList.isEmpty()){
                            System.out.println("No rooms available");
                            break;
                        }
                        System.out.println("Enter the customer email :");
                        String customerEmail = reserveScanner.nextLine();
                        while(!hotelResource.validateEmail(customerEmail)){
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
                        while(!hotelResource.validateEmail(custEmail)){
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
