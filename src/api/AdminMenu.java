package api;

import model.Customer;
import model.Room;
import model.RoomType;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AdminMenu {
    AdminResource adminResource = new AdminResource();

    public void displayAdminMenu(){
        Scanner scanner1 = new Scanner(System.in);
        try {

            System.out.println("ADMIN MENU");
            System.out.println("1. See all Customers");
            System.out.println("2. See all Rooms");
            System.out.println("3. See all Reservations");
            System.out.println("4. Add a Room");
            System.out.println("5. Back to Main Menu");
            System.out.println("Please enter your choice:");
            int userInput = scanner1.nextInt();
            switch(userInput) {
                case 1:
                    System.out.println("SEE ALL CUSTOMERS");
                     System.out.println(adminResource.getAllCustomers());
                    break;
                case 2:
                    System.out.println("SEE ALL ROOMS");
                    adminResource.getAllRooms();
                    break;
                case 3:
                    System.out.println("SEE ALL RESERVATIONS");
                    adminResource.displayAllReservations();
                    break;
                case 4:
                    Scanner addRoom = new Scanner(System.in);

                    System.out.println("Enter the room number:");
                    String roomNumber = addRoom.nextLine();
                    System.out.println("Room type : DOUBLE/SINGLE :");
                    RoomType type = RoomType.valueOf(addRoom.next());
                    System.out.println("Enter the price:");
                    Double price = addRoom.nextDouble();
                    adminResource.addRoom(roomNumber,type,price);
                    break;
                case 5:
                    break;
            }
        }
        catch(Exception e){
            e.getLocalizedMessage();
        }
        finally{
            //scanner1.close();
        }
    }
}
