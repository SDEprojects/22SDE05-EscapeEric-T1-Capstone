package com.ericsHouse.view.object.bedroom;

import com.ericsHouse.jsonParser.JsonParser;
import com.ericsHouse.view.object.SuperObject;
import com.ericsHouse.view.panels.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

import static com.ericsHouse.view.panels.GamePanel.currentRoom;
import static com.ericsHouse.view.util.GameFrame.sidePanel;

public class OBJ_Aluminum extends SuperObject {
    public int width;
    public int height;

    public OBJ_Aluminum(String name, String file, int width, int height) {
        this.name = name;
        this.width = width;
        this.height = height;
        try {
            image = ImageIO.read(getClass().getResourceAsStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
        gettable = true;
        solidArea = new Rectangle(0, 0, width * 3 , height * 3 );
    }

    @Override
    public void draw(Graphics2D g2, GamePanel gp) {

        g2.drawImage(image, screenX, screenY, width * 3, height * 3, null);

    }

    @Override
    public void interact(String objIndex, GamePanel gp) {
        if (gettable) {

            gp.ui.currentDialogue = JsonParser.getPrompt(currentRoom.mapObjects.get(objIndex).name, gp);
            gp.player.addItem(currentRoom.mapObjects.get(objIndex));
            sidePanel.inventorySetUp(currentRoom.mapObjects.get(objIndex));
            currentRoom.mapObjects.remove(objIndex);
            gp.gameState = gp.dialogueState;
        }
    }

}
