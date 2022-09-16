package com.ericsHouse.models;

import java.util.ArrayList;
import java.util.Map;

public class Room {

    private String room;
    private String roomName;
    private ArrayList<String> roomItems;
    private Map<String, String> prompts;

    public static void askShaq() {

    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public ArrayList<String> getRoomItems() {
        return roomItems;
    }

    public void setRoomItems(ArrayList<String> roomItems) {
        this.roomItems = roomItems;
    }

    public Map<String, String> getPrompts() {
        return prompts;
    }

    public void setPrompts(Map<String, String> prompts) {
        this.prompts = prompts;
    }
}
