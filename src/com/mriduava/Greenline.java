package com.mriduava;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Greenline {

    private ArrayList<Passenger> passengers = new ArrayList<>();

    private String companyName = "";
    public Greenline(String companyName){
        this.companyName = companyName;
    }

    public void promptMenu() {
        //To display menu items.
        MainMenu.MenuItems menuItems;
        do {
            menuItems = MainMenu.showMenuAndGetChoice();
            switch (menuItems) {
                case ADMIN_REGISTRATION:
                    registerUser();
                    break;
                case DRIVER_REGISTRATION:
                    break;
                case PASSENGER_REGISTRATION:
                    break;
                case ADMIN_LOGIN:
                    break;
                case DRIVER_LOGIN:
                    break;
                case PASSENGER_LOGIN:
                    loginUser();
                    break;
                case AVAILABLE_SEATS:
                    showAvailableSeats();
                    break;
                case RESERVE_SEAT:
                    break;
                case MY_BOOKING:
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
                User passenger = new Passenger(name, id2);
                passengers.add((Passenger)passenger);
            } else {
                isNumber = false;
                System.out.println("Please enter a 4 digit number...");
            }
        }while (!(isNumber));
    }

    public void showUsers(){
        for (int i = 0; i< passengers.size(); i++){
            System.out.println("NAME: " + passengers.get(i).getName().toUpperCase() +
                    "\n--------------------------");
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
        for (Passenger user: passengers){
            if (user.getName().equals(name.toLowerCase())){
                return true;
            }
        }
        return false;
    }

    public boolean existUser(String username, int pinCode){
        for (Passenger user: passengers){
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
        Iterator<Integer> it = seat.getIterator();
        while (it.hasNext()){
            System.out.println(it.next() + " ");
        }
    }

}
