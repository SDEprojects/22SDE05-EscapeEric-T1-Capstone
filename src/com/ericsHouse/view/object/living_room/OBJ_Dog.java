package com.ericsHouse.view.object.living_room;

import com.ericsHouse.jsonParser.JsonParser;
import com.ericsHouse.view.object.SuperObject;
import com.ericsHouse.view.panels.GamePanel;
import com.ericsHouse.view.util.WordOrder;
import com.fasterxml.jackson.core.JsonProcessingException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class OBJ_Dog extends SuperObject {
    public int width;
    public int height;
    public static WordOrder wo;

    public OBJ_Dog(String name, String file, int width, int height){
        this.name = name;
        this.width = width;
        this.height = height;
        try{
            image = ImageIO.read(getClass().getResourceAsStream(file));
        }catch (IOException e){
            e.printStackTrace();
        }
        collision = true;
        solidArea = new Rectangle(0,0,width * 5,height * 5);
    }

    @Override
    public void draw(Graphics2D g2, GamePanel gp){

        g2.drawImage(image, screenX, screenY, width * 3, height * 3, null);

    }

    @Override
    public void interact(int objIndex, GamePanel gp) throws JsonProcessingException {
        gp.gameState = gp.wordOrder;
        gp.ui.currentDialogue = JsonParser.getPrompt(gp.obj[objIndex].name, gp);
        wo = new WordOrder(gp);
    }
}
