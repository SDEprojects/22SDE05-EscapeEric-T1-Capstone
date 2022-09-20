package com.ericsHouse.view.object.kitchen;

import com.ericsHouse.jsonParser.JsonParser;
import com.ericsHouse.view.panels.GamePanel;
import com.ericsHouse.view.object.SuperObject;
import com.ericsHouse.view.util.Riddle;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

import static com.ericsHouse.view.main.sidePanel;

public class OBJ_Kitchen extends SuperObject {
    public int width;
    public int height;

    public OBJ_Kitchen(String name, String file, int width, int height) {
        this.name = name;
        this.width = width;
        this.height = height;
        try {
            image = ImageIO.read(getClass().getResourceAsStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
        solidArea = new Rectangle(0, 0, width * 3, height * 3);
    }

    @Override
    public void draw(Graphics2D g2, GamePanel gp) {
        g2.drawImage(image, screenX, screenY, width * 3, height * 3, null);
    }

    @Override
    public void interact(int objIndex, GamePanel gp){
        boolean hasKnife = false;
        for (SuperObject item : gp.player.getBackpack()) {
            if (item.name == "knife") {
                hasKnife = true;
            }
        }
        if (gettable) {
            JsonParser.getPrompt(gp.obj[objIndex].name, gp);
            gp.player.addItem(gp.obj[objIndex]);
            sidePanel.inventorySetUp(gp);
            sidePanel.inventoryDisplay();
            gp.obj[objIndex] = null;
        }
        if (Objects.equals(gp.obj[objIndex].name, "door")) {
            if (hasKnife) {
                gp.gameState = gp.dialogueState;
                gp.ui.currentDialogue = JsonParser.doorUnlockedParser(gp);
                try {
                    gp.obj[7].image = ImageIO.read(Riddle.class.getResourceAsStream("/rooms/kitchen/kitchen_OBJ/door-open.png"));
                    gp.obj[7].collision = false;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                gp.gameState = gp.dialogueState;
                gp.ui.currentDialogue = JsonParser.doorParser(gp);
            }

        } else {
            gp.gameState = gp.dialogueState;
            gp.ui.currentDialogue = JsonParser.getPrompt(gp.obj[objIndex].name, gp);
        }
    }
}
