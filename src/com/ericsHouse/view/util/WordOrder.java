package com.ericsHouse.view.util;

import com.ericsHouse.jsonParser.JsonParser;
import com.ericsHouse.view.panels.GamePanel;

import java.util.ArrayList;
import java.util.List;

import static com.ericsHouse.view.util.KeyHandler.objIndex;

public class WordOrder {

    public static List<String> clickedObJ = new ArrayList<>();
    public static ArrayList<String> compareList = new ArrayList<>();
    private GamePanel gp;

    public WordOrder(GamePanel gp) {
        this.gp = gp;
       generateCompareList();
    }

    public static void generateCompareList(){
        compareList.add("oranges");
        compareList.add("pears");
        compareList.add("emerald-earrings");
        compareList.add("note");
    }

    public void addClickedObject(String objName){
        clickedObJ.add(objName);
        boolean listMatch = checkLists();
        if(listMatch){
            if(clickedObJ.size() == compareList.size()){
                    gp.ui.currentDialogue = "The dog accepts that you know how to spell 'OPEN'\nHe grumbles and walks away.";
                    //TODO - figure out how to make this dynamic rather than hardcoding the array position numbers
                    gp.obj[23] = null;
            }else{
                gp.ui.currentDialogue = String.format("That's Correct I need %s more items from you.", 4 - clickedObJ.size());
            }

        }else{
            gp.ui.currentDialogue = "That wasn't the right answer";
            clickedObJ.clear();
        }
    }

    public static boolean checkLists() {
        boolean returnVal = false;
        for (int i = 0; i< clickedObJ.size();i++) {
            String recieved = clickedObJ.get(i);
            String compareTo = compareList.get(i);
            if(recieved.equals(compareTo)){
                returnVal = true;

            }else {
                returnVal = false;
            }

        }
        return returnVal;
    }
}
