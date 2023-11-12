package System;

import System.eWallet;
import static System.Administrator.Approved;

import UI.SystemUI;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Player class and it extends from userProfile class to get player data
 *
 * @author Mohamed_El_Laithy
 */
public class Player extends userProfile {

    Scanner input = new Scanner(System.in);
    ArrayList<ArrayList<String>> Bookedslots;
    ArrayList<Player> team;
    ArrayList<String> Inbox;
    eWallet eWallet;
    SystemUI obj = new SystemUI();

    public Player() {
        Bookedslots = new ArrayList<>();
        team = new ArrayList<Player>();
        Inbox = new ArrayList<>();
        eWallet = new eWallet();
    }

    /**
     * set player Balance in account ewallet
     *
     * @param bal balance
     */
    public void setBalance(int bal) {
        eWallet.setBalance(bal);
    }

    /**
     * set player balance, it used to read balance as input from player
     */
    public void setBalance() {
        String temp;
        int bal;
        System.out.println("Enter your balance");
        temp = input.nextLine();
        bal = SystemUI.stringToInt(temp);
        eWallet.setBalance(bal);
    }

    /**
     * player Cancel Booking in cancellation period time
     *
     * @param playground String playground
     * @param time String time 
     */
    public void CancelBooking(String playground, String time) {
        for (int i = 0; i < Bookedslots.size(); i++) {
            if (Bookedslots.get(i).get(0).equalsIgnoreCase(playground)) {
                Bookedslots.remove(i);
            }
        }
    }

    /**
     * get player balance from ewallet
     *
     * @return balance
     */
    public int getBalance() {
        return eWallet.getBalance();
    }

    /**
     * get available slots for playground
     *
     * @param time String time
     * @param playground String playground
     */
    public void bookingSlots(String time, String playground) {
        for (int i = 0; i < Bookedslots.size(); i++) {
            if (Bookedslots.get(i).get(0) != null) {
                Bookedslots.get(i).add(time);
                Bookedslots.get(i).add(playground);
                break;
            }
        }
    }

    /**
     * creating team of my choice.
     *
     * @param x player object
     */
    public void createTeam(Player x) {
        team.add(x);
    }

    /**
     * editing the player's info
     */
    public void editPlayerinfo() {
        int integerValue = 0;
        String choice;
        String stringValue;
        System.out.println("1- Edit First name");
        System.out.println("2- Edit Last name");
        System.out.println("3- Edit setID");
        System.out.println("4- Edit setEmail");
        System.out.println("5- Edit setPhone");
        System.out.println("6- Edit setLocation");
        System.out.println("7- Edit setPassword");
        while (true) {
            choice = input.nextLine();
            if (choice.equals("1")) {
                System.out.println("Enter the new first name");
                stringValue = input.nextLine();
                stringValue = SystemUI.isString(stringValue);
                setFName(stringValue);
                break;
            } else if (choice.equals("2")) {
                System.out.println("Enter the new last name");
                stringValue = input.nextLine();
                stringValue = SystemUI.isString(stringValue);
                setLName(stringValue);
                break;
            } else if (choice.equals("3")) {
                System.out.println("Enter the new ID");
                stringValue = input.nextLine();
                integerValue = SystemUI.stringToInt(stringValue);
                setID(integerValue);
                break;
            } else if (choice.equals("4")) {
                System.out.println("Enter the new Email");
                stringValue = input.nextLine();
                stringValue = SystemUI.isEmail(stringValue);
                setEmail(stringValue);
                break;
            } else if (choice.equals("5")) {
                System.out.println("Enter the new Phone");
                stringValue = input.nextLine();
                integerValue = SystemUI.stringToInt(stringValue);
                setPhone(integerValue);
                break;
            } else if (choice.equals("6")) {
                System.out.println("Enter the new location");
                stringValue = input.nextLine();
                setLocation(stringValue);
                break;
            } else if (choice.equals("7")) {
                System.out.println("Enter the new password");
                stringValue = input.nextLine();
                setPassword(stringValue);
                break;
            } else {
                System.out.println("please choose from 1 to 7");
            }
        }
    }

    /**
     * depositing money to my account
     *
     * @param amount int amount
     */
    public void getMoney(int amount) {
        eWallet.deposit(amount);
    }

    /**
     * used to send emails to team
     *
     * @param x String parameter x 
     */
    public void addInbox(String x) {
        Inbox.add(x);
    }

    /**
     * used to show all emails from inbox
     */
    public void viewInbox() {
        if (Inbox.size() == 0) {
            System.out.println("Your Inbox is Empty");
        } else {
            for (int i = 0; i < Inbox.size(); i++) {
                System.out.println("Message No." + (i + 1) + ": " + Inbox.get(i));
            }
        }

    }

}
