package view.tile.kitchen;

import view.GamePanel;
import view.tile.Tile;
import view.tile.TileManager;

import javax.imageio.ImageIO;
import java.io.IOException;

public class KitchenTileManager extends TileManager {
    public KitchenTileManager(GamePanel gp) throws IOException {
        super(gp);
        loadmap("/rooms/kitchen/maps/kitchen-map.txt");

    }

    @Override
    public void getTileImage(){
        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/rooms/kitchen/tiles/floor.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/rooms/kitchen/tiles/wall.png"));
            tile[1].collision = true;

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/rooms/kitchen/tiles/right-wall.png"));
            tile[2].collision = true;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/rooms/kitchen/tiles/left-wall.png"));
            tile[3].collision = true;

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/rooms/kitchen/tiles/right-corner.png"));
            tile[4].collision = true;

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/rooms/kitchen/tiles/left-corner.png"));
            tile[5].collision = true;

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/rooms/kitchen/tiles/bottom-wall.png"));
            tile[6].collision = true;

        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
