package com.ericsHouse.view.tile.garage;

import com.ericsHouse.view.panels.GamePanel;
import com.ericsHouse.view.tile.Tile;
import com.ericsHouse.view.tile.TileManager;

import javax.imageio.ImageIO;
import java.io.IOException;

public class GarageTileManager extends TileManager {
    public GarageTileManager(GamePanel gp) throws IOException {
        super(gp);
        loadmap("/rooms/garage/maps/garage-map.txt");
    }

    @Override
    public void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/rooms/garage/tiles/garage-floor.png"));


            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/rooms/garage/tiles/garage-wall.png"));
            tile[1].collision = true;

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/rooms/garage/tiles/garage-wall-with-door.png"));
            tile[2].collision = true;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/rooms/garage/tiles/garage-tables1.png"));
            tile[3].collision = true;

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/rooms/garage/tiles/garage-tables2.png"));
            tile[4].collision = true;

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/rooms/garage/tiles/garage-tables3.png"));
            tile[5].collision = true;

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/rooms/garage/tiles/garage-tables4.png"));
            tile[6].collision = true;

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/rooms/garage/tiles/garage-tables5.png"));
            tile[7].collision = true;

            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/rooms/garage/tiles/garage-tables6.png"));
            tile[8].collision = true;

            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/rooms/garage/tiles/garage-tables7.png"));
            tile[9].collision = true;

            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/rooms/garage/tiles/garage-tables8.png"));
            tile[10].collision = true;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
