package com.ericsHouse.view.tile.bedroom;

import com.ericsHouse.view.panels.GamePanel;
import com.ericsHouse.view.tile.Tile;
import com.ericsHouse.view.tile.TileManager;

import javax.imageio.ImageIO;
import java.io.IOException;

public class BedroomTileManager extends TileManager {
    public BedroomTileManager(GamePanel gp) throws IOException {
        super(gp);
        loadmap("/rooms/bedroom/maps/bedroom-map.txt");
    }

    @Override
    public void getTileImage(){
        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/rooms/bedroom/tiles/floor.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/rooms/bedroom/tiles/basic-wall.png"));
            tile[1].collision = true;

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/rooms/bedroom/tiles/left-upper-corner.png"));
            tile[2].collision = true;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/rooms/bedroom/tiles/left-wall.png"));
            tile[3].collision = true;

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/rooms/bedroom/tiles/left-bottom-corner.png"));
            tile[4].collision = true;

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/rooms/bedroom/tiles/bottom-wall.png"));
            tile[5].collision = true;

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/rooms/bedroom/tiles/right-bottom-corner.png"));
            tile[6].collision = true;

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/rooms/bedroom/tiles/right-wall.png"));
            tile[7].collision = true;

            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/rooms/bedroom/tiles/right-upper-corner.png"));
            tile[8].collision = true;

            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/rooms/bedroom/tiles/bottom-wall-main.png"));
            tile[9].collision = true;

        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
