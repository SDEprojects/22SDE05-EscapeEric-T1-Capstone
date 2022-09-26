package com.ericsHouse.view.object.kitchen;

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


public class OBJ_Pears extends SuperObject {
    public OBJ_Pears() {
        name = "pears";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/rooms/kitchen/kitchen_OBJ/pears.png"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        solidArea = new Rectangle(0, 0, 18 * 3, 28 * 3);
        gettable = true;
    }

    @Override
    public void draw(Graphics2D g2, GamePanel gp) {
        g2.drawImage(image, screenX, screenY, GamePanel.tileSize, GamePanel.tileSize, null);
    }

    @Override
    public void interact(String objIndex, GamePanel gp) {
        if (gettable) {
            //If object is gettable, display dialogue box
            //If user selects get item then the object is put in their inventory
            try {
                image = ImageIO.read(getClass().getResourceAsStream("/rooms/kitchen/kitchen_OBJ/pears.png"));
            } catch (IOException e) {

            }
            UI.currentDialogue = JsonParser.getPrompt(currentRoom.mapObjects.get(objIndex).name);
            Player.addItem(currentRoom.mapObjects.get(objIndex));
            sidePanel.inventorySetUp(currentRoom.mapObjects.get(objIndex));
            currentRoom.mapObjects.remove(objIndex);
            GamePanel.gameState = GamePanel.dialogueState;
        }
    }
}
