package com.mriduava;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Scanner;

public class Greenline {
    private ArrayList<User> users = new ArrayList<>();
    private static String COMPANY_NAME = "GREEN LINE";

    /**
     * To Apply the Singleton design patter
     * The constructor is private
     * To create only one object, getInstance function
     * has been created.
     */
    private static Greenline greenline;
    private Greenline(String companyName){
        this.COMPANY_NAME = companyName;
    }

    public static Greenline getInstance(){
        if (greenline == null){
            greenline = new Greenline(COMPANY_NAME);
            System.out.println("====================================");
            System.out.println(COMPANY_NAME);
            greenline.promptMenu();
        }
        return greenline;
    }

    /**
     * To display menu items and
     */
    public void promptMenu() {
        MainMenu.MenuItems menuItems;
        do {
            menuItems = MainMenu.showMenuAndGetChoice();
            switch (menuItems) {
                case USER_REGISTRATION:
                    registerUser();
                    break;
                case USER_LOGIN:
                    loginUser();
                    break;
                case BUSES_DESTINATIONS:
                    showBusInfo();
                    break;
                case ALL_USERS:
                    showUsers();
                    break;
                case RENTED_BUSES:
                    showRentedBuses();
                    break;
                case EXIT:
                    System.out.println("PROGRAM IS SHUTTING DOWN");
                    break;
            }
        } while (menuItems != menuItems.EXIT);
    }

    /**
     * To Register User
     */
    public void registerUser(){
        System.out.println("USER REGISTRATION" +
                "\n=======================");
        Scanner scan = new Scanner(System.in);
        System.out.println("WRITE A ROLE ('ADMIN', 'DRIVER', 'PASSENGER'): ");
        String role = scan.nextLine();
        String name, id;
        boolean userName;
        do {
            System.out.println("USERNAME: ");
            name = scan.nextLine();
            if (!existUsername(name)){
                boolean isNumber;
                do {
                    System.out.println("PIN CODE (4 digit): ");
                    String regex = "\\d+";
                    id = scan.nextLine();
                    if (id.length() == 4 && id.matches(regex)) {
                        int id2 = Integer.valueOf(id);
                        if (role.toLowerCase().equals("admin")){
                            Employee admin = new Admin(name, id2, role);
                            users.add(admin);
                        } else if(role.toLowerCase().equals("driver")){
                            Employee driver = new Driver(name, id2, role);
                            users.add(driver);
                        }else if(role.toLowerCase().equals("passenger")){
                            User passenger = new Passenger(name, id2, role);
                            users.add(passenger);
                        }else {
                            System.out.println("OBS! Registration failed! \nWrite your correct role!");
                        }
                        break;
                    } else {
                        isNumber = false;
                        System.out.println("Please enter a 4 digit number...");
                    }
                } while (!(isNumber));
                break;
            }else {
                userName = false;
                System.out.println("This username is used.");
            }
        }while (!userName);
    }

    public void showUsers(){
        if (users != null){
            for (User user: users){
                System.out.println(user.toString());
            }
        }
    }

    /**
     * To Login User
     */
    public void loginUser(){
        System.out.println("USER LOGIN" +
                "\n================");
        Scanner scan = new Scanner(System.in);
        String name, id;
        System.out.println("ENTER THE USERNAME: ");
        name = scan.nextLine();
        if (existUsername(name)){
            boolean isNumber;
            int tryCount = 1;
            do {
                System.out.println("PIN CODE (4 digit): ");
                String regex = "\\d+";
                id = scan.nextLine();
                if (id.length() == 4 && id.matches(regex)) {
                    int id2 = Integer.parseInt(id);
                    if (existUser(name, id2)){
                        isNumber = true;
                        System.out.println("Hello " + name.toUpperCase() + " !");
                    }else {
                        isNumber = false;
                        if (tryCount < 3){
                            System.out.println("Pincode is wrong\nTry again...");
                            tryCount++;
                        }else {
                            System.out.println("Sorry! Try later...");
                            tryCount++;
                        }
                    }
                } else {
                    isNumber = false;
                    if (tryCount < 3){
                        System.out.println("OBS! It's not a 4 digit number");
                        tryCount++;
                    }else {
                        System.out.println("Sorry! Try later...");
                        tryCount++;
                    }
                }
            } while (!(isNumber) && tryCount<=3);
        }else {
            System.out.println("You're not a User\nPlease register");
        }
    }

    /**
     * Function to search the username in the Array.
     * This function was created to avoid the creation of
     * multiple users with the same username.
     * @param name String name
     * @return true or false
     */
    public boolean existUsername(String name){
        for (User user: users){
            if (user.getName().equals(name.toLowerCase())){
                return true;
            }
        }
        return false;
    }

    /**
     * Search the Pin Code in the Array.
     * This function was created to avoid the creation of
     * multiple users with the same username.
     * @param pinCode String name
     * @return true or false
     */
    public boolean existUser(String username, int pinCode){
        for (User user: users){
            if (user.getName().toLowerCase().equals(username.toLowerCase()) && user.getId() == pinCode ){
                return true;
            }
        }
        return false;
    }

    /**
     * To show Rented buses by the Greenline company
     */
    Bus bus = new BusAdapter();
    public void showRentedBuses(){
        bus.getBusInfo();
    }

    /**
     * Show available Buses and Bus Routes
     */
    public void showBusInfo(){
        System.out.println("---------------------------\n" +
                "AVAILABLE BUSES \n" +
                "---------------------------");
        bus.getBusInfo();
        Route route = new Route();
        System.out.println( route.toString());

    }


}
