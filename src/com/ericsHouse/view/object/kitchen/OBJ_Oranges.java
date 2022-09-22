package com.ericsHouse.view.object.kitchen;

import com.ericsHouse.jsonParser.JsonParser;
import com.ericsHouse.view.object.SuperObject;
import com.ericsHouse.view.panels.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

import static com.ericsHouse.view.GameFrame.sidePanel;
import static com.ericsHouse.view.panels.GamePanel.currentRoom;


public class OBJ_Oranges extends SuperObject {
    public OBJ_Oranges() {
        name = "oranges";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/rooms/kitchen/kitchen_OBJ/oranges.png"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        solidArea = new Rectangle(0, 0, 20 * 3, 20 * 3);
        gettable = true;
    }

    @Override
    public void draw(Graphics2D g2, GamePanel gp) {
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }

    @Override
    public void interact(String objIndex, GamePanel gp) {
        if (gettable) {
            try {
                image = ImageIO.read(getClass().getResourceAsStream("/rooms/kitchen/kitchen_OBJ/oranges.png"));
            } catch (IOException e) {

            }
            JsonParser.getPrompt(currentRoom.mapObjects.get(objIndex).name, gp);
            gp.player.addItem(currentRoom.mapObjects.get(objIndex));
            sidePanel.inventorySetUp(currentRoom.mapObjects.get(objIndex));
            currentRoom.mapObjects.remove(objIndex);
        }
    }
}
