package com.ericsHouse.models;

import java.util.ArrayList;

public class David {

    private static ArrayList<String> backpack = new ArrayList<>();
    private static ArrayList<String> wornItems = new ArrayList<>();

    public David() {
    }

    public static ArrayList<String> getBackpack() {
        return backpack;
    }

    public static ArrayList<String> getWornItems() {
        return wornItems;
    }

    public static void addItem(String item) {
        backpack.add(item);
    }
    public static void removeItem(String item) {
        backpack.remove(item);
    }
    public static void wearItem(String item) {
        wornItems.add(item);
    }
}
