package UI;


import System.Playground;
import System.PlaygroundOwner;
import static UI.SystemUI.accountMenu;
import static UI.SystemUI.admin;
import static UI.SystemUI.complaintForm;
import static UI.SystemUI.isDigit;
import static UI.SystemUI.isString;
import static UI.SystemUI.stringToInt;
import static UI.SystemUI.thePlayers;
import static UI.PlayerUI.isExistPlayer;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * this class represent the UI of Playergound owner menu this class allow to Playergound owner Make Some functions like ---
 * 
 * 1- add playground
 * 2- update playground
 * 3- check wallet
 * 4- show your list of playgrounds
 * 5- add complaints
 * 6- show messages
 * 7- Cancel booking
 * 8- Logout
 * @author Mohamed_El_Laithy
 */
public class playgroundOwnerUI {
    
    //Menu for the playground owners
    public static void playgroundOwnerMenu(Scanner input ,int userIndex, ArrayList<PlaygroundOwner> theOwners,String currentUser) {
        String choice, playground;
        System.out.println("Welcome to playground owner profile, please choose from the following");
        System.out.println("1- add playground");
        System.out.println("2- update playground");
        System.out.println("3- check wallet");
        System.out.println("4- show your list of playgrounds");
        System.out.println("5- add complaints");
        System.out.println("6- show messages");
        System.out.println("7- Cancel booking");
        System.out.println("8- Logout");
        choice = input.nextLine();
        if (choice.equals("1")) {
            addPlayground(input ,theOwners,currentUser);
        } else if (choice.equals("2")) {
            System.out.println("Enter the name of playground you want to replace");
            playground = input.nextLine();
            playground = isString(playground);
            theOwners.get(userIndex).updatePlaygroundName(playground);
        } else if (choice.equals("3")) {
            for (int i = 0; i < theOwners.size(); i++) {
                if (theOwners.get(i).getEmail().equalsIgnoreCase(currentUser)) {
                    System.out.println("Your balance is " + theOwners.get(i).getMyBalance());
                    break;
                }
            }
        } else if (choice.equals("4")) {
            System.out.println("Your playgrounds list is:- ");
            theOwners.get(userIndex).getListofPlayground();
        } else if (choice.equals("5")) {
            complaintForm();
        } else if (choice.equals("6")) {
            theOwners.get(userIndex).displayRecieveMsg();
        } else if (choice.equals("7")) {
            ownerCancelBooking(input ,theOwners,currentUser);
        } else if (choice.equals("8")) {
            accountMenu();
        } else {
            System.out.println("invalid input please choose number from 1 to  7 ");
        }
        playgroundOwnerMenu(input , userIndex,theOwners,currentUser);
    }
    //registering playground and adding it to the playground owner's list of playgrounds, then requesting for approve
    public static void addPlayground(Scanner input , ArrayList<PlaygroundOwner> theOwners,String currentUser) {
        boolean check = false;
        String name;
        for (int i = 0; i < theOwners.size(); i++) {
            if (theOwners.get(i).getEmail().equalsIgnoreCase(currentUser)) {
                check = true;
                Playground newGround = new Playground();
                System.out.println("Enter the playground name: ");
                String getName = input.nextLine();
                while (true) {
                    boolean checkExistence = playgroundExists(theOwners,getName);
                    if (checkExistence) {
                        System.out.println("This name already exists please enter another name");
                        getName = input.nextLine();
                    } else {
                        break;
                    }
                }
                newGround.setName(getName);
                newGround.setLocation();
                newGround.setPrice();
                System.out.println("Enter the playground Status of availability by typing ( available or not available)");
                newGround.setStatus();
                newGround.setOwner(currentUser);
                newGround.setBooking();
                System.out.println("Enter the allowed cancellation time before the booking time (In hours)");
                String getHours = input.nextLine();
                getHours = isDigit(getHours);
                newGround.setCancellationPeriod(Integer.parseInt(getHours));
                theOwners.get(i).addPlayground(newGround);
                admin.playgroundRequests(newGround);
            }
        }
        if (check) {
            System.out.println("Added the playground");
        } else {
            System.out.println("Failed to add the playground");
        }
    }
    //Owners choice if the player exceeded the allowed time to cancel booking or not and decides if he'll cancell booking
        public static void ownerCancelBooking(Scanner input , ArrayList<PlaygroundOwner> theOwners,String currentUser) {
        String player, time, day, temp, playground;
        int hours = 0;
        System.out.println("The following Information is required to cancel booking.");
        System.out.println("Enter the player email");
        player = input.nextLine();
        while (true) {
            if (!isExistPlayer(thePlayers,player)) {
                System.out.println("This player doesn't exist, Please enter his correct email");
                player = input.nextLine();
            } else {
                break;
            }
        }
        System.out.println("Enter his booking time");
        time = input.nextLine();
        time = isDigit(time);
        System.out.println("Enter his booking day");
        day = input.nextLine();
        day = isString(day);
        System.out.println("Enter how many hours did he book");
        temp = input.nextLine();
        hours = stringToInt(temp);
        System.out.println("Enter the playground name");
        playground = input.nextLine();
        playground = isString(playground);
        for (int i = 0; i < theOwners.size(); i++) {
            if (theOwners.get(i).getEmail().equalsIgnoreCase(currentUser)) {
                for (int j = 0; j < hours; j++) {
                    int getTime = j + Integer.parseInt(time);
                    time = Integer.toString(getTime);
                    theOwners.get(i).updatePlaygroundStatus(playground, time, day);
                }
                int amount = theOwners.get(i).payMoney(playground, hours);
                for (int j = 0; j < thePlayers.size(); j++) {
                    if (thePlayers.get(i).getEmail().equalsIgnoreCase(player)) {
                        thePlayers.get(i).getMoney(amount);
                        thePlayers.get(i).CancelBooking(playground, time);
                        break;
                    }
                }
                System.out.println("Successfully cancelled the booking");
                System.out.println("A transaction with value " + amount + " Have been transferred from your balance to " + player);
                break;
            }
        }
    }
    //Checks if this playground exists

    public static boolean playgroundExists(ArrayList<PlaygroundOwner> theOwners,String playground) {
        for (int i = 0; i < theOwners.size(); i++) {
            if (theOwners.get(i).existPlayground(playground)) {
                return true;
            }
        }
        return false;
    }
    
}
