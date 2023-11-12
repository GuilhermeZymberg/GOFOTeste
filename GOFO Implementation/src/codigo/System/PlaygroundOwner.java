package System;

import System.Playground;
import System.userProfile;
import System.eWallet;
import UI.SystemUI;
import java.util.Scanner;
import java.util.Vector;
import java.util.ArrayList;

/**
 * PlaygroundOwner class and it extend from userProfile class and it user to
 * make function that fround in playground menu UI
 *
 * @author Mohamed_El_Laithy
 */
public class PlaygroundOwner extends userProfile {

    Scanner input = new Scanner(System.in);
    ArrayList<Playground> listOfPlayground;
    eWallet eWallet;
    ArrayList<String> recieveMsg;

    Playground obj = new Playground();
    SystemUI obj2 = new SystemUI();

    public PlaygroundOwner() {
        listOfPlayground = new ArrayList<Playground>();
        recieveMsg = new ArrayList<String>();
        eWallet = new eWallet();
    }

    /**
     * setBalance function to ewallet
     *
     * @param bal ewallet object
     */
    public void setBalance(eWallet bal) {
        eWallet = bal;
    }

    /**
     * get owner balance from his ewallet
     *
     * @return account Balance
     */
    public int getMyBalance() {
        return eWallet.getBalance();
    }

    /**
     * add playground function that owner user it to add playground
     *
     * @param x Playground object
     */
    public void addPlayground(Playground x) {
        listOfPlayground.add(x);
    }

    /**
     * boolean function that Checks if a playerground exists
     *
     * @param name String name
     * @return true or false
     */
    public boolean existPlayground(String name) {
        for (int i = 0; i < listOfPlayground.size(); i++) {
            if (listOfPlayground.get(i).getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * updates the info of a playground
     *
     * @param playgroundName String playgroundName
     */
    public void updatePlaygroundName(String playgroundName) {
        String newName, newStatus, newBeginning, newEnding;
        boolean found = false, bool = false;
        String temp;
        int choice = 0, playgroundIndex = 0;
        for (int i = 0; i < listOfPlayground.size(); i++) {
            if (listOfPlayground.get(i).getName().equalsIgnoreCase(playgroundName)) {
                playgroundIndex = i;
                found = true;
            }
        }
        if (found) {
            System.out.println("Choose which option you want to update");
            System.out.println("1- Update Playground Name");
            System.out.println("2- Update Plyaground Location");
            System.out.println("3- Update Plyaground price/hour");
            System.out.println("4- Update Plyaground Status");
            System.out.println("5- Update Plyaground booking time");
            temp = input.nextLine();
            temp = SystemUI.isDigit(temp);
            choice = SystemUI.stringToInt(temp);
            if (choice == 1) {
                System.out.println("Enter the new name of the playground");
                newName = input.nextLine();
                newName = SystemUI.isString(newName);
                listOfPlayground.get(playgroundIndex).setName(newName);
                System.out.println("playground name updated successfully!!");
            } else if (choice == 2) {
                listOfPlayground.get(playgroundIndex).setLocation();
                System.out.println("playground Location updated successfully!!");
            } else if (choice == 3) {
                listOfPlayground.get(playgroundIndex).setPrice();
                System.out.println("playground price updated successfully!!");
            } else if (choice == 4) {
                System.out.println("Enter the playground new Status of availability by typing ( available or not available)");
                listOfPlayground.get(playgroundIndex).setStatus();
                System.out.println("playground status updated successfully!!");

            } else if (choice == 5) {
                listOfPlayground.get(playgroundIndex).setBooking();
            }

        } else {
            System.out.println("playground name doesn't exist please enter it again");
            playgroundName = input.nextLine();
            playgroundName = SystemUI.isString(playgroundName);
            updatePlaygroundName(playgroundName);
        }

    }

    /**
     * owner update Playground Status
     *
     * @param playgroundName String playgroundName
     * @param time String time
     * @param day String day
     */
    public void updatePlaygroundStatus(String playgroundName, String time, String day) {
        boolean bool = false, inputChecker = true;
        while (inputChecker) {
            for (int i = 0; i < listOfPlayground.size(); i++) {
                if (listOfPlayground.get(i).getName().equalsIgnoreCase(playgroundName)) {
                    bool = true;
                    listOfPlayground.get(i).cancelBooking(day, time);
                    break;
                }
            }
            if (bool) {
                inputChecker = false;
            } else {
                inputChecker = true;
                System.out.println("playground name doesn't exist please enter it again");
                playgroundName = input.nextLine();
                playgroundName = SystemUI.isString(playgroundName);
            }
        }

    }

    /**
     * getListofPlayground function used to view list of owner playgrounds
     */
    public void getListofPlayground() {
        for (int i = 0; i < listOfPlayground.size(); i++) {
            System.out.println(listOfPlayground.get(i).getName());
        }
    }

    /**
     * addRecieveMsg function used to send email to another player or onwer
     *
     * @param msg String message
     */
    public void addRecieveMsg(String msg) {
        recieveMsg.add(msg);
    }

    /**
     * owner use it to make payment process
     *
     * @param playground String playground
     * @param hours int hours number
     * @return
     */
    public int payMoney(String playground, int hours) {
        int amount = 0;
        boolean bool = false;
        for (int i = 0; i < listOfPlayground.size(); i++) {
            if (listOfPlayground.get(i).getName().equalsIgnoreCase(playground)) {
                bool = true;
                amount = listOfPlayground.get(i).getPrice() * hours;
                break;
            }
        }
        if (bool) {
            eWallet.withdraw(amount);
            return amount;
        } else {
            System.out.println("playground doesn't exist please enter it's name again");
            playground = input.nextLine();
            playground = SystemUI.isString(playground);
            return payMoney(playground, hours);
        }

    }

    /**
     * Display all messages that he receive it as a mails
     */
    public void displayRecieveMsg() {
        for (int i = 0; i < recieveMsg.size(); i++) {
            System.out.println(recieveMsg.get(i));
        }
    }

}
