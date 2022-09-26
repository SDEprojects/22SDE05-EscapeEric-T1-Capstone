package com.ericsHouse.view.util;

import com.ericsHouse.rooms.RoomMap;
import com.ericsHouse.view.entity.Player;
import com.ericsHouse.view.object.garage.OBJ_Note;
import com.ericsHouse.view.panels.GamePanel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.ericsHouse.view.panels.GamePanel.currentRoom;

class GameFrameTest {

    /**
     * @throws IOException for the new GameFrame,
     * the reset should reset the users inv, and location and then creates new items in the rooms.
     */
    @Test
    void resetGame() throws IOException {
        new GameFrame();
        GamePanel gp = new GamePanel();
        KeyHandler kp = new KeyHandler(gp);
        Player player = new Player(gp, kp);
        OBJ_Note note = new OBJ_Note();
        player.addItem(note);
        currentRoom = RoomMap.roomMap.get("bedroom");
        GameFrame.reset();
        Assertions.assertEquals(0, player.getBackpack().size());
        Assertions.assertEquals("garage", currentRoom.name);
    }
}