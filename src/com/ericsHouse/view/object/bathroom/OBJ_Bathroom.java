package com.ericsHouse.view.object.bathroom;

import com.ericsHouse.jsonParser.JsonParser;
import com.ericsHouse.view.panels.GamePanel;
import com.ericsHouse.view.object.SuperObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Bathroom extends SuperObject {
    public int width;
    public int height;

    public OBJ_Bathroom(String name, String file, int width, int height) {
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
    public void interact(int objIndex, GamePanel gp) {
        if (Objects.equals(gp.obj[objIndex].name, "david-mirror") && !win) {
            gp.gameState = gp.dialogueState;
            gp.ui.currentDialogue = JsonParser.RockPaperScissors(gp);
            gp.gameState = gp.rockPaperScissors;
        } else if (win) {
            gp.ui.currentDialogue = "You've already beat your mirror reflection.";
            gp.gameState = gp.dialogueState;
        } else {
            try{
                gp.ui.currentDialogue = JsonParser.getPrompt(gp.obj[objIndex].name, gp);
                gp.gameState = gp.dialogueState;
            }
            catch (NullPointerException ex){
                System.out.println("No descriptions");
            }
        }
    }
}
