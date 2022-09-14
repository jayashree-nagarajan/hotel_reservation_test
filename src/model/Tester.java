package model;

public class Tester {
    public static void main(String[] args){
        try{
            Customer customer = new Customer("first","second","email");
            System.out.println(customer);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getLocalizedMessage());
        }
    }
}
