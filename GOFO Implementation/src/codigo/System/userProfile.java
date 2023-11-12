package System;

import System.eWallet;
import java.util.Scanner;
/**
 * userProfile class that contain all data for user 
 * @author Mohamed_El_Laithy
 */
public class userProfile {

    public String fName;
    public String lName;
    public int ID;
    public String password;
    public String email;
    public int phone;
    public String location;
    public String rule;
    eWallet service;
    Scanner sc = new Scanner(System.in);
    /**
     * setPayment Function
     * @param val eWallet object
     */
    public void setPayment(eWallet val) {
        service = val;
    }
    /**
     * set FirstName Function
     * @param name String name
     */
    public void setFName(String name) {
        fName = name;
    }
    /**
     * set LastName Function
     * @param name String name
     */
    public void setLName(String name) {
        lName = name;
    }
    /**
     * Set user id function
     * @param I_D int id
     */
    public void setID(int I_D) {
        ID = I_D;
    }
    /**
     * set user email function 
     * @param em String email address
     */
    public void setEmail(String em) {
        email = em;
    }
    /**
     * set user password
     * @param pass String account password
     */
    public void setPassword(String pass) {
        password = pass;
    }
    /**
     * set user phone number function
     * @param ph int phone number
     */
    public void setPhone(int ph) {
        phone = ph;
    }
    /**
     * set user location function
     * @param loc String location
     */
    public void setLocation(String loc) {
        location = loc;
    }
    /**
     * set user rule 
     * @param ru String user rule
     */
    public void setRule(String ru) {
        rule = ru;
    }
    /**
     * get user full name first name + last name  
     * @return fName + " " + lName
     */
    public String getFullName() {
        return fName + " " + lName;
    }
    /**
     * get user id 
     * @return ID
     */
    public int getID() {
        return ID;
    }
    /**
     * get user password
     * @return password
     */
    public String getPassword() {
        return password;
    }
    /**
     * get user email 
     * @return email
     */
    public String getEmail() {
        return email;
    }
    /**
     * get user phone number
     * @return phone
     */
    public int getPhone() {
        return phone;
    }
    /**
     * get user rule 
     * @return rule
     */
    public String getRule() {
        return rule;
    }

}
