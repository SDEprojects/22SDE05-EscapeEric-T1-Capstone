package com.ericsHouse.view.object.garage;

import com.ericsHouse.view.object.SuperObject;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Dresser extends SuperObject {

    public OBJ_Dresser(){
        name = "dresser";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/rooms/garage/garage_OBJ/dresser.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}
