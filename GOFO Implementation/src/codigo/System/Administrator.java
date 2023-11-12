package System;

import java.util.ArrayList;
import java.util.Scanner;
import UI.SystemUI;

/**
 * Administrator class used to allow admin to mange system
 *
 * @author Mohamed_El_Laithy
 */
public class Administrator {

    Scanner input = new Scanner(System.in);
    String email, password;
    int choice;
    String choice2;
    static ArrayList<Playground> Approved;//���Approved playgrounds
    static ArrayList<Playground> Requested;//Requested playground to approve them
    ArrayList<Playground> suspended;//suspended playgrounds
    ArrayList<String> complaints;
    SystemUI obj = new SystemUI();

    /**
     * Default administrator
     */
    public Administrator() {
        email = "admin@gmail.com";
        password = "123";
        Approved = new ArrayList<Playground>();
        Requested = new ArrayList<Playground>();
        suspended = new ArrayList<Playground>();
        complaints = new ArrayList<String>();
    }

    /**
     * Approved playgrounds displaying
     */
    public void getApproved() {
        for (int i = 0; i < Approved.size(); i++) {
            System.out.println(Approved.get(i).getName());
        }
    }
    /**
     * get emails that send from another accounts 
     * @return email
     */
    public String getEmail() {
        return email;
    }
    /**
     * get password 
     * @return password
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * Approving the requested playgrounds from the arraylist of requested
     */
    public void approvePlayground() {
        for (int i = 0; i < Requested.size(); i++) {
            System.out.println("Owner: " + Requested.get(i).getOwner() + " Playground Name is: " + Requested.get(i).getName());
            System.out.println("Do you want to Approve this playground? (yes or no)");
            String getAns = input.nextLine();
            if (getAns.equalsIgnoreCase("yes")) {
                Approved.add(Requested.get(i));
                Requested.remove(Requested.get(i));
                i--;
            }
        }
    }
    /**
     * display All Playgrounds informations
     */
    public void displayAllPlaygrounds(){
        for (int i = 0; i < Approved.size(); i++) {
            System.out.println("PlayGround Number :" + (i+1));
            System.out.println("PlayGround Status :" + Approved.get(i).getStatus());
            System.out.println("PlayGround Name :" + Approved.get(i).getName());
            System.out.println("PlayGround Price:" + Approved.get(i).getPrice());
            System.out.println("Playground Slots Are: From " + Approved.get(i).getSlotsBegin() + " To: " + Approved.get(i).getSlotsEnd());
            System.out.println("Allowed cancellation time till " + Approved.get(i).getCancellationPeriod() + " Before the booked time");
            System.out.println("\n");    
        }
    }
    /**
     * search for playground By Name
     * @param Name Playground Name
     */
    public void searchByName(String Name){
        System.out.println("Dispaly All PlayGrounds Names.\n");
        for (int i = 0; i < Approved.size(); i++) {
            System.out.println("Playground Number "+(i+1) + " Name : " + Approved.get(i).getName() + " ");
        }
        boolean x = false;
        for (int i = 0; i < Approved.size(); i++) {
            if(Approved.get(i).getName().equals(Name)){
                System.out.println("PlayGround Number :" + (i+1));
                System.out.println("PlayGround Status :" + Approved.get(i).getStatus());
                System.out.println("PlayGround Name :" + Approved.get(i).getName());
                System.out.println("PlayGround Price:" + Approved.get(i).getPrice());
                System.out.println("Playground Slots Are: From " + Approved.get(i).getSlotsBegin() + " To: " + Approved.get(i).getSlotsEnd());
                System.out.println("Allowed cancellation time till " + Approved.get(i).getCancellationPeriod() + " Before the booked time");
                System.out.println("\n");    
                x = true;
            }
        }
        if(x == false){
            System.out.println("No Playground Have the same Name Please Try agian.\n");
        }
    }
    
    /**
     * search for playground By Location
     * @param Location Playground Location
     */
    public void searchByLocation(String Location){
        System.out.println("Dispaly All PlayGrounds Location.\n");
        for (int i = 0; i < Approved.size(); i++) {
            System.out.println("Playground Number "+( i+1) + " Location : " + Approved.get(i).getLocation()+ " ");
        }
        boolean x = false;
        for (int i = 0; i < Approved.size(); i++) {
            if(Approved.get(i).getLocation().equals(Location)){
                System.out.println("PlayGround Number :" + (i+1));
                System.out.println("PlayGround Status :" + Approved.get(i).getStatus());
                System.out.println("PlayGround Name :" + Approved.get(i).getName());
                System.out.println("PlayGround Price:" + Approved.get(i).getPrice());
                System.out.println("Playground Slots Are: From " + Approved.get(i).getSlotsBegin() + " To: " + Approved.get(i).getSlotsEnd());
                System.out.println("Allowed cancellation time till " + Approved.get(i).getCancellationPeriod() + " Before the booked time");
                System.out.println("\n");    
                x = true;
            }
        }
        if(x == false){
            System.out.println("No Playground Have the same Location Please Try agian.\n");
        }
    }
    /**
     * display All Playgrounds Locations it used in when player want to book Playground 
     */
    public void displayAllavailablePlaygroundsLocations(){
        System.out.println("Dispaly All PlayGrounds Location.");
        for (int i = 0; i < Approved.size(); i++) {
            if(Approved.get(i).statusPlayground.equalsIgnoreCase("available"))
                System.out.println("Playground Number:"+( i+1) + "Location :" + Approved.get(i).getLocation());
        }
    }
    /**
     * display All Playgrounds Names it used in when player want to book Playground 
     */
    
    public void displayAllavailablePlaygroundsNames(){
        System.out.println("Dispaly All PlayGrounds Names.");
        for (int i = 0; i < Approved.size(); i++){
            if(Approved.get(i).statusPlayground.equalsIgnoreCase("available"))
                System.out.println("Playground Number:"+( i+1) + "Name :" + Approved.get(i).getName()+ " ");
        }
    }
    
    /**
     * booking slot for a player by finding it's location
     * @param loc String loc
     * @param player String player
     * @param balance int balance
     * @return arraylist
     */
    public int bookByLocation(String loc, String player, int balance) {
        boolean bool = false, inputChecker = true;
        int playgroundSlot = 0;
        String temp;
        System.out.println("Playground in this Area: " + "        (Pick a playground by it's index)");
        while (inputChecker) {
            for (int i = 0; i < Approved.size(); i++) {
                if (Approved.get(i).getLocation().equalsIgnoreCase(loc)) {
                    playgroundSlot = i;
                    bool = true;
                    System.out.println("                     " + (i + 1));
                    System.out.println(Approved.get(i).getName());
                    System.out.println(Approved.get(i).getPrice());
                    System.out.println("Slots Are: From " + Approved.get(i).getSlotsBegin() + " To: " + Approved.get(i).getSlotsEnd());
                    System.out.println("Allowed cancellation time till " + Approved.get(i).getCancellationPeriod() + " Before the booked time");
                }
            }
            if (bool) {
                inputChecker = false;
            } else {
                System.out.println("there is no playground in this location please enter location again");
                loc = input.nextLine();
                inputChecker = true;
            }
        }
        temp = input.nextLine();
        int getInput = SystemUI.stringToInt(temp);
        int hoursBooked;
        System.out.println("How many hours Do you want to book");
        temp = input.nextLine();
        int getAns = SystemUI.stringToInt(temp);
        System.out.println("Enter the day you want to book");
        String getDay = input.nextLine();
        //getDay = Application.isString(getDay);
        if (balance > (Approved.get(getInput - 1).getPrice() * getAns)) {
            if (getInput + getAns > Approved.get(playgroundSlot).getSlotsEnd()) {
                System.out.println("you cant book at this time as it exceeds the booking available time");
                return 0;
            }
            hoursBooked = getAns;
            for (int i = Approved.get(getInput - 1).getSlotsBegin(); i < (Approved.get(getInput - 1).getSlotsBegin() + 1); i++) {
                Approved.get(getInput - 1).bookingTheSlot(player, Integer.toString(i), getDay);
            }
            return Approved.get(getInput - 1).getPrice() * hoursBooked;
        } else {
            System.out.println("You don't have enough money");
            return 0;
        }

    }
    
    /**
     * booking a slot for a player in a playground booking slots by the playground's name
     * @param playground String playground
     * @param player String player name
     * @param balance int balance
     * @return arraylist
     */
    public int bookByName(String playground, String player, int balance) {
        String temp;
        boolean inputChecker = true, bool = false;
        int playgroundSlot = 0, hoursBooked = 0, getAns = 0;
        while (inputChecker) {
            for (int i = 0; i < Approved.size(); i++) {
                if (Approved.get(i).getName().equalsIgnoreCase(playground)) {
                    bool = true;
                    playgroundSlot = i;
                    System.out.println(Approved.get(i).getName());
                    System.out.println(Approved.get(i).getPrice());
                    System.out.println("Free slots: ");
                    Approved.get(i).freeSlots();
                    break;
                }
            }
            if (bool) {
                inputChecker = false;
            } else {
                System.out.println("playground doesn't exist please enter it's name again");
                playground = input.nextLine();
                playground = SystemUI.isString(playground);
                inputChecker = true;
            }
        }
        System.out.println("Enter the time you want to book in");
        temp = input.nextLine();
        int getInput = SystemUI.stringToInt(temp);
        System.out.println("How many hours Do you want to book");
        temp = input.nextLine();
        getAns = SystemUI.stringToInt(temp);
        System.out.println("Enter the day you want to book in");
        String getDay = input.nextLine();
        //getDay = Application.isString(getDay);

        if (balance > (Approved.get(playgroundSlot).getPrice() * getAns)) {
            hoursBooked = getAns;
            if (getInput + getAns > Approved.get(playgroundSlot).getSlotsEnd()) {
                System.out.println("you cant book at this time as it exceeds the booking available time");
                return 0;
            }
            for (int i = getInput; i < (getInput + getAns); i++) {

                Approved.get(playgroundSlot).bookingTheSlot(player, Integer.toString(i), getDay);
            }
            System.out.println("Cost is: " + Approved.get(playgroundSlot).getPrice() * hoursBooked);
            return Approved.get(playgroundSlot).getPrice() * hoursBooked;
        } else {
            System.out.println("You don't have enough money");
            return 0;
        }
    }
    /**
     * addComplaints that he receive it in Complaints arraylist
     * @param complain String complain msg
     */
    public void addComplaints(String complain) {
        complaints.add(complain);
    }
    
    /**
     * Suspending a playground for an action made by them, it's decided by the administrator
     * @param playground String playground name
     */
    public void suspendPlayground(String playground) {
        boolean bool = true;
        for (int i = 0; i < Approved.size(); i++) {
            if (Approved.get(i).getName().equalsIgnoreCase(playground)) {
                suspended.add(Approved.get(i));
                Approved.remove(i);
                bool = false;
                System.out.println("the playground is suspended successfully!!");
            }
        }
        if (bool) {
            System.out.println("the playground isn't found please enter it's name correctly");
            playground = input.nextLine();
            suspendPlayground(playground);
        }

    }
    
    /**
     * deleting a playground
     * @param playground String playground name
     */
    public void deletePlayground(String playground) {
        boolean bool = true;
        for (int i = 0; i < Approved.size(); i++) {
            if (Approved.get(i).getName().equalsIgnoreCase(playground)) {
                Approved.remove(i);
                bool = false;
                System.out.println("the playground is deleted successfully!!");

            }
        }
        if (bool) {
            System.out.println("the playground isn't found please enter it's name correctly");
            playground = input.nextLine();
            deletePlayground(playground);
        }
    }
    /**
     * Show all playgroundRequests and allow to add it or not 
     * @param x playground object
     */
    public void playgroundRequests(Playground x) {
        Requested.add(x);
    }
    /**
     * show Complaints list from users 
     */
    public void showComplaints() {
        System.out.println("The complaints list is: ");

        for (int i = 0; i < complaints.size(); i++) {
            System.out.println(i + 1 + complaints.get(i));
        }
    }
    
    /**
     * removing the suspended playground from suspended list and moving it to approved list.
     */
    public void unSuspendPlayground() {
        for (int i = 0; i < suspended.size(); i++) {
            System.out.println("Suspended playground name: " + suspended.get(i).getName());
            System.out.println("Do you want to unsuspend it?(yes or no)");
            String getAns = input.nextLine();
            while (true) {
                if (getAns.equalsIgnoreCase("yes")) {
                    Approved.add(suspended.get(i));
                    suspended.remove(i);
                    break;
                } else if (getAns.equalsIgnoreCase("no")) {
                    break;
                } else {
                    System.out.println("Wrong choice,please pick (yes or no)");
                    getAns = input.nextLine();
                }
            }
        }
    }
}
