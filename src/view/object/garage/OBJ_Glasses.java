package view.object.garage;

import com.ericsHouse.jsonParser.RoomZeroParser;
import view.GamePanel;
import view.object.SuperObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class OBJ_Glasses extends SuperObject {

    public OBJ_Glasses(){
        name = "glasses";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/garage_OBJ/glasses-hidden.png"));
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
                image = ImageIO.read(getClass().getResourceAsStream("/garage_OBJ/glasses.png"));
            }catch (IOException e){

            }
            RoomZeroParser.getPrompt(gp.obj[objIndex].name);
            gp.obj[objIndex] = null;

        }
        //If item isn't gettable display dialogue box with description
        else{
            RoomZeroParser.getPrompt(gp.obj[objIndex].name);
        }
    }

}
