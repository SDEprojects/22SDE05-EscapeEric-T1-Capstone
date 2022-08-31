package com.ericsHouse.rooms;

import java.util.List;

public interface Rooms {
    // fields
    List<String> items = null;


    // methods
    void inspectLeft();
    void inspectRight();
    void inspectFloor();
    void askShaq();
    void moveToNextRoom();


}
