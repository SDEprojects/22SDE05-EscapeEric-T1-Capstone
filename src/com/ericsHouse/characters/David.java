package com.ericsHouse.characters;

import java.util.ArrayList;

public class David {

    static David david = new David();

    private static ArrayList<String> backpack = new ArrayList<>();

    public static ArrayList<String> getBackpack() {
        return backpack;
    }

    public static void addBackpack(String item) {
        backpack.add(item);
    }
    public static void removeBackpack(String item) {
        backpack.remove(item);
    }

    private static ArrayList<String> wornItems = new ArrayList<>();

    public static ArrayList<String> getWornItems() {
        return wornItems;
    }

    public static void addWornItems(String item) {
        wornItems.add(item);
    }

}
