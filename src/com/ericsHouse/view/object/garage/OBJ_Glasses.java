package com.ericsHouse.view.object.garage;

import com.ericsHouse.jsonParser.JsonParser;
import com.ericsHouse.view.entity.Player;
import com.ericsHouse.view.object.SuperObject;
import com.ericsHouse.view.panels.GamePanel;
import com.ericsHouse.view.util.UI;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

import static com.ericsHouse.view.util.GameFrame.sidePanel;
import static com.ericsHouse.view.panels.GamePanel.currentRoom;


public class OBJ_Glasses extends SuperObject {

    public OBJ_Glasses() {
        name = "glasses";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/rooms/garage/garage_OBJ/glasses-hidden.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        solidArea = new Rectangle(0, 0, 48 * 2, 48 * 2);
        gettable = true;
    }

    @Override
    public void draw(Graphics2D g2, GamePanel gp) {
        g2.drawImage(image, screenX, screenY, GamePanel.tileSize, GamePanel.tileSize, null);
    }

    @Override
    public void interact(String objIndex, GamePanel gp) {
        if (gettable) {
            try {
                image = ImageIO.read(getClass().getResourceAsStream("/rooms/garage/garage_OBJ/glasses.png"));
            } catch (IOException e) {

            }
                UI.currentDialogue = JsonParser.getPrompt(currentRoom.mapObjects.get(objIndex).name);
                Player.addItem(currentRoom.mapObjects.get(objIndex));
                sidePanel.inventorySetUp(currentRoom.mapObjects.get(objIndex));
                currentRoom.mapObjects.remove(objIndex);
                GamePanel.gameState = GamePanel.dialogueState;
            }
            else {
                GamePanel.gameState = GamePanel.dialogueState;
                UI.currentDialogue = "You look at the note and it's a blur...\nNeed to find your glasses first.\nTry looking at all the objects in here.";
                //System.out.println("Even if you got the note, you couldn't read it\nNeed to find your glasses first.");
            }
    }
}
