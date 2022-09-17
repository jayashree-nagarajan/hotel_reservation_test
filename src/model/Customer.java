package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {
    private String firstName;
    private String lastName;
    private String email;

    public Customer(){

    }
    public Customer(String firstName,String lastName,String email){
            super();
               this.firstName = firstName;
                this.lastName = lastName;
                this.email = email;


    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString(){
        return "\tNAME : "+firstName+" "+lastName+"\tEMAIL :"+email+"\n";
    }

    @Override
    public int hashCode() {
        int hash = (this.email == null ? 0 : this.email.hashCode()) +
                (this.firstName == null ? 0 : this.firstName.hashCode());
        //System.out.println("Overriding hashCode :"+hash);
        return hash;
    }
    @Override
    public boolean equals(Object object) {
        Customer customer = (Customer) object;

        if(customer.getFirstName().equals(firstName) && customer.getLastName().equals(lastName) && customer.getEmail().equals(email))
            return true;
        else
            return false;
  }

}


