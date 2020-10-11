package com.mriduava;
import java.util.Arrays;

public class Route {

    String[] route1 = new String[]{"Malmö", "Göteborg", "Oslo"};
    String[] route2 = new String[]{"Lund", "Linköping", "Stockholm"};

    public String[] getRoute1() {
        return route1;
    }

    public void setRoute1(String[] route1) {
        this.route1 = route1;
    }

    public String[] getRoute2() {
        return route2;
    }

    public void setRoute2(String[] route2) {
        this.route2 = route2;
    }

    @Override
    public String toString() {
        return "Bus Routes " +
                "\nRoute1:" + Arrays.toString(route1) +
                "\nRoute2:" + Arrays.toString(route2);
    }
}
