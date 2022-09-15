package view.tile;

import view.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {

    GamePanel gp;
    public Tile[] tile;
    public int[][] mapTileNum;

    public TileManager(GamePanel gp) throws IOException {
        this.gp = gp;

        tile = new Tile[15];
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];

        getTileImage();
        loadmap("/maps/garage-map.txt");

    }

    public void getTileImage(){
        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/garage-floor.png"));


            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/garage-wall.png"));
            tile[1].collision = true;

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/garage-wall-with-door.png"));
            tile[2].collision = true;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/garage-tables1.png"));
            tile[3].collision = true;

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/garage-tables2.png"));
            tile[4].collision = true;

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/garage-tables3.png"));
            tile[5].collision = true;

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/garage-tables4.png"));
            tile[6].collision = true;

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/garage-tables5.png"));
            tile[7].collision = true;

            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/garage-tables6.png"));
            tile[8].collision = true;

            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles/garage-tables7.png"));
            tile[9].collision = true;

            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles/garage-tables8.png"));
            tile[10].collision = true;

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void loadmap(String map) throws IOException {
        InputStream is = getClass().getResourceAsStream(map);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        int col = 0;
        int row = 0;
        while(col < gp.maxScreenCol && row <gp.maxScreenRow){
            String line = br.readLine();
            while (col < gp.maxScreenCol){
                String numbers[] = line.split(" ");
                int num = Integer.parseInt(numbers[col]);
                mapTileNum[col][row] = num;
                col++;
            }
            if(col == gp.maxScreenCol){
                col = 0;
                row++;
            }

        }
        br.close();
    }

    public void draw(Graphics2D g2){
        int screenCol = 0;
        int screenRow = 0;

        while(screenCol < gp.maxScreenCol && screenRow < gp.maxScreenRow){
            int tileNum = mapTileNum[screenCol][screenRow];

            int screenX = screenCol * gp.tileSize;
            int screenY = screenRow * gp.tileSize;
            try{
                g2.drawImage(tile[tileNum].image, screenX, screenY,gp.tileSize, gp.tileSize, null);
            }catch (NullPointerException e){
                e.printStackTrace();
            }

            screenCol++;

            if(screenCol == gp.maxScreenCol){
                screenCol = 0;
                screenRow++;
            }
        }
    }
}
