package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tester {
    public static void main(String[] args) throws Exception{
        /*try{
            Customer customer = new Customer("first","second","email");
            System.out.println(customer);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getLocalizedMessage());
        }*/
        Scanner reserveScanner = new Scanner(System.in);
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        System.out.println("Find and reserve a room");
        System.out.println("Enter the check in date (MM/dd/yyyy):");
        Date checkInDate = null;
        Date today = new Date();
        String dateInput = reserveScanner.nextLine();
        /*if (dateInput != null && dateInput.trim().length() > 0) {
            checkInDate = format.parse(dateInput);

        }*/

        String dateRegex = "(((0[0-9])|(1[012]))\\/((0[1-9])|([12][0-9])|(3[01]))\\/((20[012]\\d|19\\d\\d)|(1\\d|2[0123])))";
        Pattern pattern = Pattern.compile(dateRegex);
        Matcher matcher = pattern.matcher(dateInput);
        if(matcher.matches()){
                checkInDate = format.parse(dateInput);
                if(checkInDate.before(today)){
                    System.out.println("Enter the dates after the current date");
                }
                else{
                    System.out.println("Valid date"+checkInDate);

                }
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(checkInDate);
        calendar.add(Calendar.DATE,7);
        Date checkOutDate = calendar.getTime();
        System.out.println(checkInDate);

        int noOfDays = (int) ((checkOutDate.getTime()-checkInDate.getTime())/ (1000 * 60 * 60 * 24));
        System.out.println("no of days:"+noOfDays);


    }




}
