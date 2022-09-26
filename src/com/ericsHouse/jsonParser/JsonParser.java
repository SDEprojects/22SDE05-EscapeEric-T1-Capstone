package com.ericsHouse.jsonParser;

import com.ericsHouse.view.panels.GamePanel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class JsonParser {

    static InputStream iStreamPrompts = getFileFromResourceAsStream("roomPrompts.json");

    static ObjectMapper objectMapper = new ObjectMapper();
    static JsonNode jsonNodePrompts;
    static JsonNode itemDescriptions;


    /**
     * @param file This file is taken from the resource file and then parsed through
     */
    public JsonParser(String file) {
        iStreamPrompts = getFileFromResourceAsStream(file);
    }

    /**
     * @param prompt The name of the location/item that you inspect
     * @return You get back what was in the json file for the specified item.
     */
    public static String getPrompt(String prompt) {
        String item = null;
        try {
            InputStream is = getFileFromResourceAsStream("roomPrompts.json");
            jsonNodePrompts = objectMapper.readTree(is);
            item = jsonNodePrompts.get(GamePanel.currentRoom.name).get(prompt).textValue();
            return item;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return item;
    }

    /**
     * @param prompt used to return the correct riddle.
     * @return correct riddle for said item.
     */
    public static String riddleParser(String prompt) {
        String item = null;
        try {
            InputStream is = getFileFromResourceAsStream("roomPrompts.json");
            jsonNodePrompts = objectMapper.readTree(is);
            item = jsonNodePrompts.get(GamePanel.currentRoom.name).get(prompt).get("riddle").textValue();
            return item;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return item;
    }
    /**
     * @param prompt used to return the correct riddle answer.
     * @return correct riddle answer for said item.
     */
    public static String riddleAnswerParser(String prompt, String answer, GamePanel gp) {
        String item = null;
        try {
            InputStream is = getFileFromResourceAsStream("roomPrompts.json");
            jsonNodePrompts = objectMapper.readTree(is);
            item = jsonNodePrompts.get(GamePanel.currentRoom.name).get(prompt).get("answers").get(answer).textValue();
            return item;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return item;
    }

    /**
     * @return returns the value of the locked door depending on your inventory.
     */
    public static String doorParser() {
        String item = null;
        try {
            InputStream is = getFileFromResourceAsStream("roomPrompts.json");
            jsonNodePrompts = objectMapper.readTree(is);
            item = jsonNodePrompts.get(GamePanel.currentRoom.name).get("door").get("locked").textValue();
            return item;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return item;
    }
    /**
     * @return returns the value of the unlocked door depending on your inventory.
     */
    public static String doorUnlockedParser() {
        String item = null;
        try {
            InputStream is = getFileFromResourceAsStream("roomPrompts.json");
            jsonNodePrompts = objectMapper.readTree(is);
            item = jsonNodePrompts.get(GamePanel.currentRoom.name).get("door").get("unlocked").textValue();
            return item;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return item;
    }

    /**
     * @return returns a different dialogue when you play RPS.
     */
    public static String RockPaperScissors() {
        String item = null;
        try {
            InputStream is = getFileFromResourceAsStream("roomPrompts.json");
            jsonNodePrompts = objectMapper.readTree(is);
            item = jsonNodePrompts.get(GamePanel.currentRoom.name).get("david-mirror").get("info").textValue();
            return item;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return item;
    }

    /**
     * @param label requires the name of the item being described.
     * @return returns the item if it is in the room in the json file.
     * @throws IOException throws IOException if the item is not there.
     */
    public static String itemDescriptions(String label) throws IOException {
        String description = "";
        try {
            InputStream is = getFileFromResourceAsStream("item-description.json");
            itemDescriptions = objectMapper.readTree(is);
            description = itemDescriptions.get(label).textValue();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return description;
    }

    /**
     * @param room needs the room name in order to find the json file
     * @return returns an output for a room once you enter it.
     */
    public static String roomIntro(String room) {
        return jsonNodePrompts.get(room).get("enterRoom").textValue();
    }

    /**
     * @param fileName needs the file name of the json file trying to open
     * @return returns the output of said file.
     */
    public static InputStream getFileFromResourceAsStream(String fileName) {
        ClassLoader classLoader = JsonParser.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }
    }

}