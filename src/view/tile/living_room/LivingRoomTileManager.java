package view.tile.living_room;

import view.GamePanel;
import view.tile.Tile;
import view.tile.TileManager;

import javax.imageio.ImageIO;
import java.io.IOException;

public class LivingRoomTileManager extends TileManager {
    public LivingRoomTileManager(GamePanel gp) throws IOException {
        super(gp);
        loadmap("/rooms/living_room/maps/living-room-map.txt");
    }

    @Override
    public void getTileImage(){
        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/rooms/living_room/tiles/floor.png"));


            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/rooms/living_room/tiles/basic-wall.png"));
            tile[1].collision = true;

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/rooms/living_room/tiles/wall-bottom.png"));
            tile[2].collision = true;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/rooms/living_room/tiles/left-wall.png"));
            tile[3].collision = true;

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/rooms/living_room/tiles/left-corner.png"));
            tile[4].collision = true;

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/rooms/living_room/tiles/bottom-wall.png"));
            tile[5].collision = true;

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/rooms/living_room/tiles/right-corner.png"));
            tile[6].collision = true;

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/rooms/living_room/tiles/right-wall.png"));
            tile[7].collision = true;


        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
