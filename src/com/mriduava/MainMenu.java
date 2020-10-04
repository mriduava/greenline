package com.mriduava;

import java.util.Scanner;

public class MainMenu {
    public enum MenuItems{
        ADMIN_REGISTRATION("ADMIN REGISTRATION"),
        DRIVER_REGISTRATION("DRIVER REGISTRATION"),
        PASSENGER_REGISTRATION("PASSENGER REGISTRATION"),
        ADMIN_LOGIN("ADMIN LOGIN"),
        DRIVER_LOGIN("DRIVER LOGIN"),
        PASSENGER_LOGIN("PASSENGER LOGIN"),
        AVAILABLE_SEATS("SHOW AVAILABLE SEATS"),
        RESERVE_SEAT("RESERVE SEAT"),
        MY_BOOKING("MY BOOKING"),
        EXIT("EXIT PROGRAM");

        private String description;
        MenuItems(String description){
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }


    public static MenuItems showMenuAndGetChoice() {
        MenuItems menuItem = null;
        System.out.println("====================================\n" +
                "PLEASE SELECT ONE ITEM FROM THE MENU\n" +
                "====================================");
        int i = 1;
        for (MenuItems item : MenuItems.values()) {
            System.out.println(i + " " + item.description);
            i++;
        }

        boolean menuNum;
        do {
            Scanner scan = new Scanner(System.in);
            if (scan.hasNextInt()) {
                int choiceIndex = scan.nextInt();
                if (choiceIndex > 0 && choiceIndex <= MenuItems.values().length){
                    menuItem = MenuItems.values()[choiceIndex - 1];
                    break;
                }else {
                    menuNum = false;
                    System.out.println("ENTER A MENU ITEM NUMBER: 1 - " + MenuItems.values().length);
                }
            } else {
                menuNum = false;
                System.out.println("ENTER A MENU ITEM NUMBER: 1 - " + MenuItems.values().length);
            }
        }while (!menuNum);

        return menuItem;
    }

}

