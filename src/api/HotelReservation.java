package api;

import java.util.Scanner;

public class HotelReservation {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        MainMenu mainMenu = new MainMenu();
        AdminMenu adminMenu = new AdminMenu();
        try {
            int userInput = 0;
            do  {
                System.out.println("userInput:"+userInput);
                System.out.println("Welcome to Hotel Reservation System");
                System.out.println("1.MAIN MENU");
                System.out.println("2.ADMIN MENU");
                System.out.println("3.EXIT");
                System.out.println("Please Enter the number to select a Menu: ");
                userInput=scanner.nextInt();
                if(userInput == 1)
                {
                    mainMenu.displayMainMenu();
                }
                else if(userInput == 2){
                    adminMenu.displayAdminMenu();
                }
                else if(userInput == 3){
                    System.out.println("Program Exit!!!");
                    System.exit(0);
                }
                else{
                    System.out.println("Please enter valid input from above option");
                }

            } while(userInput > 0);
            System.out.println("after while");
            scanner.close();
        }
        catch(Exception e){
            e.getLocalizedMessage();
            e.printStackTrace();
        }
        finally{
            scanner.close();
        }
    }
}
