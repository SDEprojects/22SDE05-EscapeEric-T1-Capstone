package com.ericsHouse.view.tile.bathroom;

import com.ericsHouse.view.panels.GamePanel;
import com.ericsHouse.view.tile.Tile;
import com.ericsHouse.view.tile.TileManager;

import javax.imageio.ImageIO;
import java.io.IOException;

public class BathroomTileManager extends TileManager {
    public BathroomTileManager(GamePanel gp) throws IOException {
        super(gp);
        loadmap("/rooms/bathroom/maps/bathroom-map.txt");
    }

    @Override
    public void getTileImage(){
        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/rooms/bathroom/tiles/floor.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/rooms/bathroom/tiles/basic-wall.png"));
            tile[1].collision = true;

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/rooms/bathroom/tiles/lower-wall.png"));
            tile[2].collision = true;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/rooms/bathroom/tiles/left-wall.png"));
            tile[3].collision = true;

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/rooms/bathroom/tiles/left-corner-wall.png"));
            tile[4].collision = true;

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/rooms/bathroom/tiles/bottom-wall.png"));
            tile[5].collision = true;

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/rooms/bathroom/tiles/right-corner-wall.png"));
            tile[6].collision = true;

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/rooms/bathroom/tiles/right-wall.png"));
            tile[7].collision = true;

        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
