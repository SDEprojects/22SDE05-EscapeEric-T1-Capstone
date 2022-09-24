package com.ericsHouse.view.util;

import com.ericsHouse.view.object.SuperObject;
import com.ericsHouse.view.object.garage.OBJ_Aluminum_Hat;
import com.ericsHouse.view.panels.GamePanel;
import com.ericsHouse.view.panels.SidePanel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import static com.ericsHouse.view.util.GameFrame.sidePanel;

public class Crafter {

    public static boolean hammerClicked;
    public static SortedSet<String> clickedItems = new TreeSet<>();

    public static void addClickedItems(String item) {
        clickedItems.add(item);
        if (clickedItems.size() == 2) {
            if (clickedItems.last().equals("hammer") && clickedItems.first().equals("aluminum")) {
                UI.currentDialogue = "You smash that aluminum into a fine metal hat.\nSelect the item from your inventory to wear it.\nThat's the only item you can build for now.";
                clickedItems.clear();
                OBJ_Aluminum_Hat hat = new OBJ_Aluminum_Hat();
                sidePanel.inventorySetUp(hat);
                hammerClicked = false;
            } else {
                UI.currentDialogue = "You can't really build with that item.\nTry selecting something else.";
                clickedItems.remove(clickedItems.last());
            }
        }
        else if (clickedItems.first().equals("hammer")) {
            hammerClicked = true;
            UI.currentDialogue = "Hammer has been selected.\nNow click the item you would like to re-shape.";
        } else {
            clickedItems.clear();
            UI.currentDialogue = "Please select the hammer first.\nThen select the item you would like to craft.";
        }
    }
}
