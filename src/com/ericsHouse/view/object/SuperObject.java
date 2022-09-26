package com.ericsHouse.view.object;

import com.ericsHouse.jsonParser.JsonParser;
import com.ericsHouse.view.entity.Player;
import com.ericsHouse.view.panels.GamePanel;
import com.ericsHouse.view.util.UI;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.awt.*;
import java.awt.image.BufferedImage;

import static com.ericsHouse.view.util.GameFrame.sidePanel;
import static com.ericsHouse.view.panels.GamePanel.currentRoom;

/**
 * Abstract parent class of all the objects that are created in each room
 */
public abstract class SuperObject {

    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int screenX, screenY;
    //You may need to change this for the different objects, this is only one tile worth of area
    public Rectangle solidArea = new Rectangle(0, 0, 48 * 2, 48 * 2);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;
    public boolean gettable = false;
    public boolean riddleItem = false;
    public boolean solved = false;
    public static boolean win = false;

    /**
     * Default draw method for all objects in the game
     * @param g2 the graphics of each object to be protected
     * @param gp current state of the game panel
     */
    public void draw(Graphics2D g2, GamePanel gp) {

        g2.drawImage(image, screenX, screenY, GamePanel.tileSize * 2, GamePanel.tileSize * 2, null);

    }

    /**
     * Default method of interaction for every object created in each room
     * @param objIndex originally an int, but now a string that represents the key of the object inside the map
     *                 of all objects inside a room
     * @param gp current state of the game panel
     * @throws JsonProcessingException Exception is possibly generated when using Jackson Json parser and json file
     * may be unable to be processed or generated
     */
    public void interact(String objIndex, GamePanel gp) throws JsonProcessingException {
        if (gettable) {
            //If object is gettable, display dialogue box
            //If user selects get item then the object is put in their inventory
            JsonParser.getPrompt(currentRoom.mapObjects.get(objIndex).name);
            Player.addItem(currentRoom.mapObjects.get(objIndex));
            sidePanel.inventorySetUp(currentRoom.mapObjects.get(objIndex));
            currentRoom.mapObjects.remove(objIndex);
        }
        //If item isn't gettable display dialogue box with description
        else {
            GamePanel.gameState = GamePanel.dialogueState;
            UI.currentDialogue = JsonParser.getPrompt(currentRoom.mapObjects.get(objIndex).name);
        }
    }
}
