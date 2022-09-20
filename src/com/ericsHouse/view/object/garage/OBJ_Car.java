package com.ericsHouse.view.object.garage;

import com.ericsHouse.view.panels.GamePanel;
import com.ericsHouse.view.object.SuperObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class OBJ_Car extends SuperObject {
    public OBJ_Car(){
        name = "car";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/rooms/garage/garage_OBJ/car.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
        collision = true;
        solidArea = new Rectangle(0,0,150 * 2,90 * 2);
    }

    @Override
    public void draw(Graphics2D g2, GamePanel gp){

        g2.drawImage(image, screenX, screenY, 150 * 2, 90 * 2, null);

    }
}
