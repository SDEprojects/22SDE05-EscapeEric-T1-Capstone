package com.ericsHouse.view.util;

import com.ericsHouse.view.panels.GamePanel;

import java.util.ArrayList;
import java.util.List;

import static com.ericsHouse.view.panels.GamePanel.currentRoom;

public class WordOrder {

    public static List<String> clickedObJ = new ArrayList<>();
    public static ArrayList<String> compareList = new ArrayList<>();
    private final GamePanel gp;

    public WordOrder(GamePanel gp) {
        this.gp = gp;
        generateCompareList();
    }

    public static void generateCompareList() {
        compareList.clear();
        compareList.add("oranges");
        compareList.add("pears");
        compareList.add("emerald-earrings");
        compareList.add("note");
    }

    public void addClickedObject(String objName) {
        clickedObJ.add(objName);
        boolean listMatch = checkLists();
        if (listMatch) {
            if (clickedObJ.size() == compareList.size()) {
                UI.currentDialogue = "The dog accepts that you know how to spell 'OPEN'\nHe grumbles and walks away.";
                currentRoom.mapObjects.remove("dog");
                clickedObJ.clear();
            } else {
                UI.currentDialogue = String.format("That's Correct I need %s more items from you.\n" +
                        "Current Items:%s", 4 - clickedObJ.size(), clickedObJ);
            }
        } else {
            UI.currentDialogue = "Nope, that's not the way to do it.\nThe dog growls at you and turns around.\nBetter try again.";
            clickedObJ.clear();
        }
    }

    public static boolean checkLists() {
        boolean returnVal = false;
        for (int i = 0; i < clickedObJ.size(); i++) {
            String received = clickedObJ.get(i);
            String compareTo = compareList.get(i);
            returnVal = received.equals(compareTo);
        }
        return returnVal;
    }
}
