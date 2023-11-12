package System;

import System.PlayGroundSchedule;
import java.util.Scanner;
import UI.SystemUI;
/**
 * Playground class it used to sets and gets Playground data
 * @author Mohamed_El_Laithy
 */
public class Playground {

    String name;
    String owner;
    String locationGround;
    int cancellationPeriod;
    int pricePerHour;
    String statusPlayground;
    PlayGroundSchedule object;
    Scanner input = new Scanner(System.in);
    SystemUI obj = new SystemUI();

    public Playground() {
        object = new PlayGroundSchedule();
    }
    /**
     * set Cancellation Period function
     * @param time 
     */
    public void setCancellationPeriod(int time) {
        cancellationPeriod = time;
    }
    /**
     * get Cancellation Period function
     * @return cancellationPeriod
     */
    public int getCancellationPeriod() {
        return cancellationPeriod;

    }
    /**
     * booking slot from the booking schedule
     * @param player String player
     * @param time String time
     * @param day  String day
     */
    public void bookingTheSlot(String player, String time, String day) {
        if (statusPlayground.equalsIgnoreCase("available")) {
            object.bookSlot(player, time, day);
        } else {
            System.out.println("This playground isn't available yet");
        }
    }
    
    /**
     * cancel the booking of a slot
     * @param day String day
     * @param time String time
     */
    public void cancelBooking(String day, String time) {
        object.bookSlot(day, time, day);
    }
    /**
     * playground free Slots
     */
    public void freeSlots() {
        object.displayFreeSlots();
    }
    /**
     * set Booking
     */
    public void setBooking() {
        object.setschedule();
    }
    /**
     * set Owner
     * @param own String owner name
     */
    public void setOwner(String own) {
        owner = own;
    }
    /**
     * set playground Name
     * @param newName String name
     */
    public void setName(String newName) {
        name = newName;
    }
    /**
     * get playground name
     * @return name 
     */
    public String getName() {
        return name;
    }
    /**
     * set playground location
     */
    public void setLocation() {
        System.out.println("Enter the playground Location:");
        locationGround = input.nextLine();
    }
    /**
     * set playground price
     */
    public void setPrice() {
        String temp;
        System.out.println("Enter the playground price/hour:");
        temp = input.nextLine();
        pricePerHour = SystemUI.stringToInt(temp);
    }
    /**
     * set playground status as available or not available playground
     */
    public void setStatus() {
        String temp;
        temp = input.nextLine();
        if (temp.equalsIgnoreCase("available") || temp.equalsIgnoreCase("not available")) {
            statusPlayground = temp;
        } else {
            System.out.println("invalid input please enter ( available or not available)");
            setStatus();
        }
    }
    /**
     * get playground Status
     * @return statusPlayground 
     */
    public String getStatus() {
        return statusPlayground;
    }
    /**
     * get playground location
     * @return locationGround
     */
    public String getLocation() {
        return locationGround;
    }
    /**
     * get playground price
     * @return pricePerHour
     */
    public int getPrice() {
        return pricePerHour;
    }
    /**
     * get playground begin slots
     * @return begin time
     */
    public int getSlotsBegin() {
        return object.getBegin();
    }
    /**
     * get playground End slots
     * @return end time
     */
    public int getSlotsEnd() {
        return object.getEnd();
    }
    /**
     * get playground owner
     * @return owner
     */
    public String getOwner() {
        return owner;
    }
}
