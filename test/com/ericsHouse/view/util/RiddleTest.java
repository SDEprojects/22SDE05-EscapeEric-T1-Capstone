package com.ericsHouse.view.util;

import com.ericsHouse.view.panels.GamePanel;
import org.junit.jupiter.api.Test;

import java.io.IOException;


import static com.ericsHouse.view.util.KeyHandler.objIndex;
import static com.ericsHouse.view.util.Riddle.riddleCount;
import static org.junit.jupiter.api.Assertions.*;

class RiddleTest {

    @Test
    void checkRiddleTest() {
        try {
            GamePanel gp = new GamePanel();
            gp.setCurrentRoom("bedroom");
            objIndex = "bird";
            gp.subState = 1;
            Riddle.checkRiddle(gp);
            assertEquals(1, riddleCount);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}