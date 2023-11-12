package UI;

import static UI.SystemUI.accountMenu;
import static UI.SystemUI.complaintForm;
import static UI.SystemUI.isDigit;
import static UI.SystemUI.isEmail;
import static UI.SystemUI.isString;
import static UI.SystemUI.stringToInt;
import System.Player;
import static UI.SystemUI.admin;
import static UI.SystemUI.input;
import static UI.SystemUI.theOwners;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * this class represent the UI of Player menu this class allow to Player Make Some functions like ---
 * 
 * 1- Deposit money
 * 2- check your balance
 * 3- Booking playground
 * 4- create team
 * 5- cancel Booking
 * 6- Edit your information
 * 7- add complaints
 * 8- view inbox
 * 9- Logout
 * @author Mohamed_El_Laithy
 */
public class PlayerUI {
    
    /**
     * Menu for the players
     * @param input
     * @param userIndex
     * @param thePlayers
     * @param currentUser
     * @param userBalance 
     */
    public static void playerMenu(Scanner input ,int userIndex, ArrayList<Player> thePlayers,String currentUser,int userBalance) {
        int balance = 0, teamNum = 0;
        String choice, temp;
        System.out.println("Welcome to player menu, please choose from the following");
        System.out.println("1- Deposit money");
        System.out.println("2- check your balance");
        System.out.println("3- Booking playground");
        System.out.println("4- create team");
        System.out.println("5- cancel Booking");
        System.out.println("6- Edit your information");
        System.out.println("7- add complaints");
        System.out.println("8- view your mails");
        System.out.println("9- display all playgrounds");
        System.out.println("10- Search For Plauground By Name");
        System.out.println("11- Search For Plauground By Location");
        System.out.println("12- Logout");
        choice = input.nextLine();
        if (choice.equals("1")) {
            System.out.println("Enter the amount to deposit");
            temp = input.nextLine();
            balance = stringToInt(temp);
            thePlayers.get(userIndex).getMoney(balance);
        } else if (choice.equals("2")) {
            System.out.println("Your balance is: " + thePlayers.get(userIndex).getBalance());
        } else if (choice.equals("3")) {
            Booking(input ,userIndex,thePlayers,currentUser,userBalance);
        } else if (choice.equals("4")) {

            System.out.println("Enter the Number of team members you want to create (from 1 to 5) ");
            while (true) {
                temp = input.nextLine();
                teamNum = stringToInt(temp);
                if (teamNum >= 1 && teamNum <= 5) {
                    for (int i = 0; i < teamNum; i++) {
                        createTeam(thePlayers,currentUser);
                    }
                    break;
                } else {
                    System.out.println("please enter number from 1 to 5");
                }
            }
            playerMenu(input ,userIndex,thePlayers,currentUser,userBalance);
        } else if (choice.equals("5")) {
            playerCancelBooking(currentUser);
        } else if (choice.equals("6")) {
            thePlayers.get(userIndex).editPlayerinfo();
        } else if (choice.equals("7")) {
            complaintForm();
        } else if (choice.equals("8")) {
            thePlayers.get(userIndex).viewInbox();
        }else if (choice.equals("9")) {
            admin.displayAllPlaygrounds();
        }else if (choice.equals("10")) {
            admin.displayAllavailablePlaygroundsNames();
            System.out.println("\nEnter the Playground Name :");
            String PName = input.nextLine();
            admin.searchByName(PName);
        }else if (choice.equals("11")) {
            System.out.println("\nEnter the Playground Location :");
            admin.displayAllavailablePlaygroundsLocations();
            String PLoc = input.nextLine();
            admin.searchByLocation(PLoc);
        }else if (choice.equals("12")) {
            accountMenu();
        } else {
            System.out.println("invalid input please choose number from 1 to  10 ");

        }
        playerMenu(input ,userIndex,thePlayers,currentUser,userBalance);
    }
    //Booking a slot for the player

    public static void Booking(Scanner input ,int userIndex, ArrayList<Player> thePlayers,String currentUser,int userBalance) {
        Player object = null;
        System.out.println("Do you want to look for a playground by:");
        System.out.println("1-Location");
        System.out.println("2-Playground name");
        String getChoice = input.nextLine();
        if (getChoice.equals("1")) {
            admin.displayAllavailablePlaygroundsLocations();
            System.out.println("Enter the location");
            String getLoc = input.nextLine();
            int cost = admin.bookByLocation(getLoc, currentUser, userBalance);
            thePlayers.get(userIndex).setBalance(userBalance - cost);
        } else if (getChoice.equals("2")) {
            admin.displayAllavailablePlaygroundsNames();
            System.out.println("Enter the playground name:");
            String getName = input.nextLine();
            getName = isString(getName);
            int cost = admin.bookByName(getName, currentUser, userBalance);
            thePlayers.get(userIndex).setBalance(userBalance - cost);
        } else {
            System.out.println("please enter 1 or 2");
            Booking(input ,userIndex,thePlayers,currentUser,userBalance);
        }
    }
    
    
    //creates team of the player
    public static void createTeam(ArrayList<Player> thePlayers,String currentUser) {
        System.out.println("Type the email of the player: ");
        boolean found = false;
        String getRequest = input.nextLine();
        getRequest = isEmail(getRequest);
        for (int i = 0; i < thePlayers.size(); i++) {
            if (thePlayers.get(i).getEmail().equalsIgnoreCase(getRequest)) {
                System.out.println("Added to the team");
                found = true;
                thePlayers.get(i).addInbox("Email: " + currentUser + " Added you to his Team");
                for (int j = 0; j < thePlayers.size(); j++) {
                    if (thePlayers.get(j).getEmail().equalsIgnoreCase(currentUser)) {
                        thePlayers.get(j).createTeam(thePlayers.get(i));
                        break;
                    }
                }
                break;
            }
        }
        if (found == false) {
            System.out.println("This Email isn't exist please try again");
            createTeam(thePlayers,currentUser);
        }
    }
    
    //player requests playground owner to cancel booking of his booked slots

    public static void playerCancelBooking(String currentUser ) {
        String playground, time, day, temp;
        int hours;
        System.out.println("Enter the name of the playground");
        playground = input.nextLine();
        playground = isString(playground);
        System.out.println("Enter the time you have booked");
        time = input.nextLine();
        time = isDigit(time);
        System.out.println("Enter the day you have booked in");
        day = input.nextLine();
        day = isString(day);
        System.out.println("Enter how many hours did you book");
        temp = input.nextLine();
        hours = stringToInt(temp);
        for (int i = 0; i < theOwners.size(); i++) {
            if (theOwners.get(i).existPlayground(playground)) {
                theOwners.get(i).addRecieveMsg(currentUser);

                DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                String msg = "I want to cancel my booking at playground name: " + playground + " At time " + time + " At Day " + day + " , I have booked " + hours + " hours" + " This Msg was sent at " + dateFormat.format(now);
                theOwners.get(i).addRecieveMsg(msg);
            }
        }
    }
    
    //Checks if a player exists
    public static boolean isExistPlayer(ArrayList<Player> thePlayers,String name) {
        for (int i = 0; i < thePlayers.size(); i++) {
            if (name.equalsIgnoreCase(thePlayers.get(i).getEmail())) {
                return true;
            }
        }
        return false;
    }
    
}
