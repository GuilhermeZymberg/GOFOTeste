package UI;

import static UI.SystemUI.accountMenu;
import static UI.SystemUI.admin;
import static UI.SystemUI.input;
import static UI.SystemUI.isString;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * this class represent the UI of Admin menu this class allow to admin to give approve to playgrounds that added by playgrounds owners
 * @author Mohamed_El_Laithy
 */
public class AdminUI {
    /**
     * Menu for the administrators Menu Functions ----
     * 1-show approve requests for playground
     * 2- suspend Playground
     * 3- unSuspend playground
     * 4- delete Playground
     * 5- show complaints
     * 6- Logout
     */
    public static void adminMenu() {
        String choice;
        String playground;
        System.out.println("Welcome to admin menu, please choose from the following");
        System.out.println("1- show approve requests for playground");
        System.out.println("2- suspend Playground");
        System.out.println("3- unSuspend playground");
        System.out.println("4- delete Playground");
        System.out.println("5- show complaints");
        System.out.println("6- Logout");
        choice = input.nextLine();
        if (choice.equals("1")) {
            admin.approvePlayground();
        } else if (choice.equals("2")) {
            System.out.println("please Enter the name of playground you want to suspend");
            playground = input.nextLine();
            playground = isString(playground);
            admin.suspendPlayground(playground);

        } else if (choice.equalsIgnoreCase("3")) {
            admin.unSuspendPlayground();
        } else if (choice.equalsIgnoreCase("4")) {
            System.out.println("Enter the name of the playground");
            playground = input.nextLine();
            playground = isString(playground);
            admin.deletePlayground(playground);
        } else if (choice.equalsIgnoreCase("5")) {
            admin.showComplaints();

        } else if (choice.equalsIgnoreCase("6")) {
            accountMenu();
        } else {
            System.out.println("Wrong input, please type pick a choice from 1-5");
        }

        adminMenu();
    }

}
