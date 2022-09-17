package service;

import model.Customer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerService {

    private static Map<String,Customer> customerCollection = new HashMap<String,Customer>();

    public void addCustomer(String email,String firstName,String lastName){
        //System.out.println("Inside CustomerService addCustomer()");
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customerCollection.put(email,customer);
        //CustomerService.addToMap(customerCollection,customer);

    }

   /* private static void addToMap(Map<String, Customer> customerCollection, Customer customer) {
        //System.out.println("Inside CustomerService addToMap()");
        customerCollection.put(customer.getEmail(),customer);
    }*/

    public Customer getCustomer(String customerEmail){
        Customer customer = new Customer() ;
        customer = customerCollection.get(customerEmail);
        //System.out.println("getCustomer :"+customer);
        //if(customer!=null)
          return customer;
    }
    public Map<String,Customer> getAllCustomers(){
        //System.out.println("CustomerService getAllCustomers()"+customerCollection.hashCode());
        return customerCollection;
    }

    public boolean validateEmail(String email){
        String emailRegex = "^(.+)@(.+).(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


}
