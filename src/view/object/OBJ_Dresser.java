package view.object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Dresser extends SuperObject{

    public OBJ_Dresser(){
        name = "dresser";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/garage_OBJ/dresser.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}
