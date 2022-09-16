package com.ericsHouse.jsonParser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.*;

public class RoomZeroParser {
    static InputStream iStreamPrompts=getFileFromResourceAsStream("roomZeroPrompts.json");;
    static InputStream iStreamLocations = getFileFromResourceAsStream("locations.json");
    static ObjectMapper objectMapper = new ObjectMapper();
    static Reader readerPrompts = new InputStreamReader(iStreamPrompts);
    static Reader readerLocations = new InputStreamReader(iStreamLocations);
    static JsonNode jsonNodePrompts;
    static JsonNode jsonNodeLocations;

    public RoomZeroParser(String file) {
        this.iStreamPrompts = getFileFromResourceAsStream(file);
    }

    public static InputStream getiStreamPrompts() {
        return iStreamPrompts;
    }

    public void setiStreamPrompts(String file) {
        iStreamPrompts =  getFileFromResourceAsStream(file);
    }

    static {
        try {
            jsonNodePrompts = objectMapper.readTree(readerPrompts);
            jsonNodeLocations = objectMapper.readTree(readerLocations);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static String getPrompt(String prompt) {
        String item = jsonNodePrompts.findValue(prompt).asText();
        return item;
    }

    public static ArrayNode getItems(String info) {
        return (ArrayNode) jsonNodeLocations.findValue(info).findValue("items");
    }

    public static String getName(String info) {
        return jsonNodeLocations.findValue(info).findValue("name").asText();
    }

    public static InputStream getFileFromResourceAsStream(String fileName) {
        ClassLoader classLoader = RoomZeroParser.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }
    }
}