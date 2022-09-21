package com.ericsHouse.view.object.garage;

import com.ericsHouse.jsonParser.JsonParser;
import com.ericsHouse.view.panels.GamePanel;
import com.ericsHouse.view.object.SuperObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

import static com.ericsHouse.view.GameFrame.sidePanel;


public class OBJ_Glasses extends SuperObject {

    public OBJ_Glasses(){
        name = "glasses";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/rooms/garage/garage_OBJ/glasses-hidden.png"));
        }catch (IOException e){
            e.printStackTrace();
        }

        solidArea = new Rectangle(0,0,48*2,48*2);
        gettable = true;
    }

    @Override
    public void draw(Graphics2D g2, GamePanel gp){
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);

    }

    @Override
    public void  interact(int objIndex, GamePanel gp){
        if(gettable){
            //If object is gettable, display dialogue box
            //If user selects get item then the object is put in their inventory
            try {
                image = ImageIO.read(getClass().getResourceAsStream("/rooms/garage/garage_OBJ/glasses.png"));
            } catch (IOException e){

            }
            gp.player.addItem(gp.obj[objIndex]);
            JsonParser.getPrompt(gp.obj[objIndex].name,gp);
            sidePanel.inventorySetUp(gp.obj[objIndex]);
            //sidePanel.inventoryDisplay();
            gp.obj[objIndex] = null;
        }
    }

}
