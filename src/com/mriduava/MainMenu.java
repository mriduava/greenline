package com.mriduava;

import java.util.Scanner;

public class MainMenu {
    public enum MenuItems{
        USER_REGISTRATION("USER REGISTRATION"),
        USER_LOGIN("USER LOGIN"),
        AVAILABLE_BUS("BUSES AND DESTINATIONS"),
        AVAILABLE_SEATS("AVAILABLE SEATS"),
        RESERVE_SEAT("RESERVE SEAT"),
        MY_BOOKING("MY BOOKING"),
        ALL_USERS("SHOW ALL USERS"),
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

