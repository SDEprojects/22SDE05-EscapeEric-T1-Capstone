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

    public boolean backpackContains(String item) {
        return backpack.contains(item);
    }
}
