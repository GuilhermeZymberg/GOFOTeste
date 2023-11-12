package System;

import java.util.Scanner;
import UI.SystemUI;

/**
 * eWallet class for user it allow to user to deposit amount or withdraw amount
 *
 * @author Mohamed_El_Laithy
 */
public class eWallet {

    SystemUI obj = new SystemUI();
    int balance;
    Scanner input = new Scanner(System.in);

    /**
     * set user balance without parameter it user to read balance from user and
     * convert to to int if it's not int parameter
     */
    public void setBalance() {
        String temp;
        System.out.println("Enter your balance");
        temp = input.nextLine();
        balance = SystemUI.stringToInt(temp);
    }

    /**
     * set user Balance function
     *
     * @param bal int balance
     */
    public void setBalance(int bal) {
        balance = bal;
    }

    /**
     * deposit amount from ewallet
     *
     * @param value int value or amount
     */
    public void deposit(int value) {
        balance += value;
    }

    /**
     * withdraw amount from ewallet
     *
     * @param value int value or amount
     */
    public void withdraw(int value) {
        balance -= value;
    }

    /**
     * get user balance
     *
     * @return balance 
     */
    public int getBalance() {
        return balance;
    }

}
