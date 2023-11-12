package UI;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import System.Administrator;
import System.eWallet;
import System.Player;
import System.PlaygroundOwner;

/**
 * This class is the class that controls all the UI classes in the system, and
 * this class is used to connect all the UI classes in the system.
 *
 * @author Mohamed_El_Laithy
 */
public class SystemUI {

    static String currentUser = "A";//Current logged in user
    static int userBalance = 0;//Current user balance
    static int userIndex = 0;//Current user Index
    static String userType = "A";//Current user Type
    static Administrator admin = new Administrator();
    static ArrayList<Player> thePlayers = new ArrayList<Player>();
    static ArrayList<PlaygroundOwner> theOwners = new ArrayList<PlaygroundOwner>();
    static Scanner input = new Scanner(System.in);

    /**
     * checks if the input is string
     * @param phrase String phrase
     * @return phrase
     */
    public static String isString(String phrase) {
        if (phrase != null && !phrase.equals("") && phrase.matches("^[a-zA-Z]*$")) {
            return phrase;
        } else {
            System.out.println("please don't enter integers or special characters");
            phrase = input.nextLine();
            return isString(phrase);
        }
    }

    /**
     * Converts string to int
     * @param phrase String phrase
     * @return integer
     */
    public static int stringToInt(String phrase) {
        int integer = 0;
        if (phrase == null) {
            System.out.println("please enter value");
            phrase = input.nextLine();
            return stringToInt(phrase);
        }
        try {
            integer = Integer.parseInt(phrase);
        } catch (NumberFormatException nfe) {
            System.out.println("please enter numeric value");
            phrase = input.nextLine();
            return stringToInt(phrase);
        }
        return integer;
    }

    /**
     * checks if the input is integer
     * @param phrase String phrase
     * @return phrase
     */
    public static String isDigit(String phrase) {
        int integer = 0;
        if (phrase == null) {
            System.out.println("Please enter value");
            phrase = input.nextLine();
            return isDigit(phrase);
        }
        try {
            integer = Integer.parseInt(phrase);
        } catch (NumberFormatException nfe) {
            System.out.println("Please enter numeric value");
            phrase = input.nextLine();
            return isDigit(phrase);
        }
        return phrase;
    }

    /**
     * Account Menu function it contain Login and Register and Exit From System
     */
    public static void accountMenu() {
        System.out.println("Pick a choice");
        System.out.println("1-Log in");
        System.out.println("2-Register");
        System.out.println("3-Exit");
        String choice = input.nextLine();
        if (choice.equals("1")) {
            Login();
        } else if (choice.equals("2")) {
            register();
        } else if (choice.equals("3")) {
            System.exit(0);
        } else {
            System.out.println("Invalid input");
            System.out.println("You'll be redirected back to pick another choice");
            accountMenu();
        }
    }

    //login menu
    /**
     * Menu function it Determine the user type if owner or player or
     * administrator
     */
    public static void Menu() {

        if (SystemUI.userType.equalsIgnoreCase("owner")) {
            playgroundOwnerUI.playgroundOwnerMenu(input, userIndex, theOwners, currentUser);
        } else if (SystemUI.userType.equalsIgnoreCase("player")) {
            PlayerUI.playerMenu(input, userIndex, thePlayers, currentUser, userBalance);
        } else if (SystemUI.userType.equalsIgnoreCase("admin")) {
            AdminUI.adminMenu();
        } else {
            System.out.println("Failed to display Menu, Please log in again");
            accountMenu();
        }
    }

    /**
     * get validation code for the email
     */
    public static void getValidationCode() {
        System.out.println("Enter the validation code that was sent to your email.");
        String getCode = input.nextLine();
        System.out.println("Successfully verified!");
        accountMenu();
    }

    /**
     * Check if the email format is correct
     * @param email String email
     * @return email
     */
    public static String isEmail(String email) {
        String emailReg = "^[a-zA-Z0-9_+&-]+(?:\\." + "[a-zA-Z0-9_+&-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";
        Pattern emaill = Pattern.compile(emailReg);
        if (email == null || email.equals("")) {
            System.out.println("please enter correct form of email");
            email = input.nextLine();
            return isEmail(email);
        }
        if (emaill.matcher(email).matches()) {
            return email;
        } else {
            System.out.println("please enter correct form of email");
            email = input.nextLine();
            return isEmail(email);
        }
    }

    /**
     * registering account for a user
     */
    public static void register() {
        String fName, lName, password, temp, email, role;
        int ID, phone;
        System.out.println("Enter the info to add new user");
        System.out.println("Enter the first name");
        fName = input.nextLine();
        fName = isString(fName);
        System.out.println("Enter the last name");
        lName = input.nextLine();
        lName = isString(lName);
        System.out.println("Enter the ID");
        temp = input.nextLine();
        ID = stringToInt(temp);
        System.out.println("Enter the password");
        password = input.nextLine();
        System.out.println("Enter the email");
        email = input.nextLine();
        email = isEmail(email);
        System.out.println("Enter the phone");
        temp = input.nextLine();
        phone = stringToInt(temp);
        System.out.println("Enter the location");
        String location;
        location = input.nextLine();
        System.out.println("Enter the role [player or playground owner]");
        while (true) {
            role = input.nextLine();
            if (role.equalsIgnoreCase("player")) {
                Player f = new Player();
                f.setBalance();
                f.setFName(fName);
                f.setLName(lName);
                f.setPassword(password);
                f.setID(ID);
                f.setRule(role);
                f.setPhone(phone);
                f.setEmail(email);
                f.setLocation(location);
                thePlayers.add(f);
                break;
            } else if (role.equalsIgnoreCase("playground owner")) {
                PlaygroundOwner f = new PlaygroundOwner();
                eWallet serve = new eWallet();
                serve.setBalance();
                f.setBalance(serve);
                f.setFName(fName);
                f.setLName(lName);
                f.setPassword(password);
                f.setID(ID);
                f.setRule(role);
                f.setPhone(phone);
                f.setEmail(email);
                f.setLocation(location);
                theOwners.add(f);
                break;
            } else {
                System.out.println("Invalid rule please Enter one of each (player or playground owner)");
            }

        }
        getValidationCode();
    }

    /**
     * logging into the user's account
     */
    public static void Login() {
        String email;
        boolean correct = false;
        System.out.println("Log in");
        System.out.println("Enter your email");
        email = input.nextLine();
        email = isEmail(email);
        System.out.println("Enter your password");
        String pass = input.nextLine();
        for (int i = 0; i < thePlayers.size(); i++) {
            if (thePlayers.get(i).getEmail().equalsIgnoreCase(email) && thePlayers.get(i).getPassword().equalsIgnoreCase(pass)) {
                SystemUI.currentUser = email;
                userBalance = thePlayers.get(i).getBalance();
                userIndex = i;
                userType = "player";
                correct = true;
                break;
            }
        }
        for (int i = 0; i < theOwners.size(); i++) {
            if (theOwners.get(i).getEmail().equalsIgnoreCase(email) && theOwners.get(i).getPassword().equalsIgnoreCase(pass)) {
                currentUser = email;
                userIndex = i;
                userType = "owner";
                correct = true;
                break;
            }
        }
        if (email.equalsIgnoreCase(admin.getEmail()) && pass.equalsIgnoreCase(admin.getPassword())) {
            currentUser = email;
            userIndex = 0;
            userType = "admin";
            userBalance = 0;
            correct = true;
        }
        if (correct) {
            System.out.println("Logged in succesfully");
            Menu();
        } else {
            System.out.println("Login Failed You'll be redirected back to pick another choice");
            accountMenu();
        }
    }

    /**
     * Complaining about something to the administrators
     */
    public static void complaintForm() {
        String personEmail, personType, complaint = null, comp;
        boolean bool = false, inputChecker = true;
        while (inputChecker) {
            System.out.println("is the person is playground owner or player?");
            personType = input.nextLine();
            if (personType.equalsIgnoreCase("playground owner")) {
                System.out.println("please enter his Email");
                personEmail = input.nextLine();
                personEmail = isEmail(personEmail);
                for (int i = 0; i < theOwners.size(); i++) {
                    if (theOwners.get(i).getEmail().equalsIgnoreCase(personEmail)) {
                        bool = true;
                        if (userType.equals("owner")) {
                            complaint = "from " + theOwners.get(userIndex).getEmail() + " about " + theOwners.get(i).getEmail() + " his complaint ";
                        } else if (userType.equals("player")) {
                            complaint = "from " + thePlayers.get(userIndex).getEmail() + " about " + theOwners.get(i).getEmail() + " his complaint ";
                        }
                        break;
                    }
                }
                if (bool) {
                    inputChecker = false;
                } else {
                    System.out.println("this user isn't found");
                    inputChecker = true;
                }

            } else if (personType.equalsIgnoreCase("player")) {
                System.out.println("please enter his Email");
                personEmail = input.nextLine();
                personEmail = isEmail(personEmail);
                for (int i = 0; i < thePlayers.size(); i++) {
                    if (thePlayers.get(i).getEmail().equalsIgnoreCase(personEmail)) {
                        if (userType.equalsIgnoreCase("owner")) {
                            complaint = "from " + theOwners.get(userIndex).getEmail() + " about " + thePlayers.get(i).getEmail() + " his complaint ";
                        } else if (userType.equalsIgnoreCase("player")) {
                            complaint = "from " + thePlayers.get(userIndex).getEmail() + " about " + thePlayers.get(i).getEmail() + " his complaint ";
                        }
                        bool = true;
                        inputChecker = false;
                        break;
                    }
                }
                if (bool) {
                    inputChecker = false;
                } else {
                    System.out.println("this user isn't found");
                    inputChecker = true;
                }
            } else {
                System.out.println("Invalid input please Enter again");
                inputChecker = true;
            }
        }
        System.out.println("User found!!");
        System.out.println("please Enter your complain");
        comp = input.nextLine();
        complaint += comp;
        admin.addComplaints(complaint);
    }
    /**
     * Main Function of System
     * @param args String[] args
     */
    public static void main(String[] args) {
        accountMenu();

    }
}
