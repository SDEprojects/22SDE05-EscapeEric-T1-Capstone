package com.ericsHouse.jsonParser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ericsHouse.view.panels.GamePanel;

import java.io.*;

public class JsonParser {
    static InputStream iStreamPrompts=getFileFromResourceAsStream("roomZeroPrompts.json");;
    static InputStream iStreamLocations = getFileFromResourceAsStream("locations.json");
    static ObjectMapper objectMapper = new ObjectMapper();
    static JsonNode jsonNodePrompts;


    public JsonParser(String file) {
        this.iStreamPrompts = getFileFromResourceAsStream(file);
    }
    public static String getPrompt(String prompt, GamePanel gp) {
        String item = null;
        try {
            InputStream is = getFileFromResourceAsStream("roomZeroPrompts.json");
            jsonNodePrompts = objectMapper.readTree(is);
            item = jsonNodePrompts.get(gp.currentRoom.name).get(prompt).textValue();
            return item;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }catch (NullPointerException e){
            return "Well that's just the coolest lil' thing!";
        }
        return item;
    }

    public static String riddleParser(String prompt, GamePanel gp){
        String item = null;
        try {
            InputStream is = getFileFromResourceAsStream("roomZeroPrompts.json");
            jsonNodePrompts = objectMapper.readTree(is);
            item = jsonNodePrompts.get(gp.currentRoom.name).get(prompt).get("riddle").textValue();
            return item;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return item;
    }

    public static String riddleAnswerParser(String prompt, String answer, GamePanel gp){
        String item = null;
        try {
            InputStream is = getFileFromResourceAsStream("roomZeroPrompts.json");
            jsonNodePrompts = objectMapper.readTree(is);
            item = jsonNodePrompts.get(gp.currentRoom.name).get(prompt).get("answers").get(answer).textValue();
            return item;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return item;
    }

    public static String doorParser( GamePanel gp){
        String item = null;
        try {
            InputStream is = getFileFromResourceAsStream("roomZeroPrompts.json");
            jsonNodePrompts = objectMapper.readTree(is);
            item = jsonNodePrompts.get(gp.currentRoom.name).get("door").get("locked").textValue();
            return item;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return item;
    }
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