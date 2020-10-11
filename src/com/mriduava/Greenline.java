package com.mriduava;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Greenline {
    private ArrayList<User> users = new ArrayList<>();

    private static Greenline greenline;
    private static String COMPANY_NAME = "GREEN LINE";

    /**
     * To Apply the Singleton design patter
     * The constructor is private
     */
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

    public void promptMenu() {
        //To display menu items.
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
                case AVAILABLE_SEATS:
                    showAvailableSeats();
                    break;
                case RESERVE_SEAT:
                    showDestination();
                    break;
                case MY_BOOKING:
                    break;
                case ALL_USERS:
                    showUsers();
                    break;
                case EXIT:
                    System.out.println("PROGRAM IS SHUTTING DOWN");
                    break;
            }
        } while (menuItems != menuItems.EXIT);
    }


    public void registerUser(){
        System.out.println("USER REGISTRATION" +
                "\n==================");
        Scanner scan = new Scanner(System.in);
        System.out.println("WRITE A ROLE ('ADMIN', 'DRIVER', 'PASSENGER'): ");
        String role = scan.nextLine();

        String name, id;
        System.out.println("USERNAME: ");
        name = scan.nextLine();
        boolean isNumber;
        do{
            System.out.println("PIN CODE (4 digit): ");
            String regex = "\\d+";
            id = scan.nextLine();
            if (id.length() == 4 && id.matches(regex)) {
                isNumber = true;
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
                    System.out.println("User Registration not Successful! \nWrite your correct role!");
                }
            } else {
                isNumber = false;
                System.out.println("Please enter a 4 digit number...");
            }
        }while (!(isNumber));
    }

    public void showUsers(){
        if (users != null){
            for (User user: users){
                System.out.println(user.toString());
            }
        }
    }

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
                        System.out.println("Not a 4 digit number");
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

    public boolean existUsername(String name){
        for (User user: users){
            if (user.getName().equals(name.toLowerCase())){
                return true;
            }
        }
        return false;
    }

    public boolean existUser(String username, int pinCode){
        for (User user: users){
            if (user.getName().toLowerCase().equals(username.toLowerCase()) && user.getId() == pinCode ){
                return true;
            }
        }
        return false;
    }


    Seat seat = new Seat();

    public void showAvailableSeats(){
        for(int i=1; i<=20; i++){
            seat.add(i);
        }
       /* Iterator<Integer> it = seat.getIterator();
        while (it.hasNext()){
            System.out.println(it.next() + " ");
        }*/
    }

    Destination destination = new Destination();

    public void showDestination(){
        destination.add("Köpenhamn");
        destination.add("Göteborg");
        destination.add("Oslo");
        showAvailableSeats();
        Bus bus = new Bus("TWY76S", seat,destination);
        /*Iterator<String> it = destination.getIterator();*/
        /*while (it.hasNext()){
            System.out.println(it.next() + " ");
        }*/
        System.out.println(bus.toString());
    }

}
