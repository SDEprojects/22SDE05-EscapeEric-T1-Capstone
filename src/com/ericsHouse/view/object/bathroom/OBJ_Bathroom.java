package com.ericsHouse.view.object.bathroom;

import com.ericsHouse.view.panels.GamePanel;
import com.ericsHouse.view.object.SuperObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class OBJ_Bathroom extends SuperObject {
    public int width;
    public int height;

    public OBJ_Bathroom(String name, String file, int width, int height){
        this.name = name;
        this.width = width;
        this.height = height;
        try{
            image = ImageIO.read(getClass().getResourceAsStream(file));
        }catch (IOException e){
            e.printStackTrace();
        }
        collision = true;
        solidArea = new Rectangle(0,0,width * 3,height * 3);
    }

    @Override
    public void draw(Graphics2D g2, GamePanel gp){
        g2.drawImage(image, screenX, screenY, width * 3, height * 3, null);
    }
}
