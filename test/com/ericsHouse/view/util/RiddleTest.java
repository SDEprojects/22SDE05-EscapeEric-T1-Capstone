package com.ericsHouse.view.util;

import com.ericsHouse.view.panels.GamePanel;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class RiddleTest {

    @Test
    void checkRiddleTest() {
        try {
            GamePanel gp = new GamePanel();
            Riddle.checkRiddle(gp);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}