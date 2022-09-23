package com.ericsHouse.view.entity;

import com.ericsHouse.view.object.garage.OBJ_Dresser;
import com.ericsHouse.view.panels.GamePanel;
import com.ericsHouse.view.util.KeyHandler;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {

    @Test
    void addItem() throws IOException {
        OBJ_Dresser test = new OBJ_Dresser();
        GamePanel gp = new GamePanel();
        KeyHandler kp = new KeyHandler(gp);
        Player player = new Player(gp, kp);
        assertEquals(0, player.getBackpack().size());
        Player.addItem(test);
        assertEquals(1, player.getBackpack().size());
    }

    @Test
    void removeItem() throws IOException {
        OBJ_Dresser test = new OBJ_Dresser();
        GamePanel gp = new GamePanel();
        KeyHandler kp = new KeyHandler(gp);
        Player player = new Player(gp, kp);
        Player.addItem(test);
        assertEquals(1, player.getBackpack().size());
        Player.removeItem(test);
        assertEquals(0, player.getBackpack().size());
    }
}