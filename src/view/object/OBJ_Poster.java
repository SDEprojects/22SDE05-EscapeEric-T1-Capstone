package view.object;

import view.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class OBJ_Poster extends SuperObject{
    public OBJ_Poster(){
        name = "note";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/garage_OBJ/posters.png"));
        }catch (IOException e){
            e.printStackTrace();
        }


    }

    @Override
    public void draw(Graphics2D g2, GamePanel gp){

        g2.drawImage(image, screenX, screenY, 66 * 2, 22 * 2, null);

    }
}
