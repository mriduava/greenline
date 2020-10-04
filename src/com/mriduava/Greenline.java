package com.mriduava;

public class Greenline {

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
                    break;
                case AVAILABLE_SEATS:
                    break;
                case RESERVE_SEAT:
                    break;
                case MY_BOOKING:
                    break;
                case EXIT:
                    System.out.println("PROGRAM IS SHUTTING DOWN");
                    break;
            }
        } while (menuItems != menuItems.EXIT);
    }

}
