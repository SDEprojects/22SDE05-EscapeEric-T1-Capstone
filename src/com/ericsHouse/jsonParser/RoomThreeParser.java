package com.ericsHouse.jsonParser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.*;

public class RoomThreeParser {
    static InputStream iStreamPrompts = getFileFromResourceAsStream("roomThreePrompts.json");
    static InputStream iStreamLocations = getFileFromResourceAsStream("locations.json");
    static ObjectMapper objectMapper = new ObjectMapper();
    static Reader readerPrompts = new InputStreamReader(iStreamPrompts);
    static Reader readerLocations = new InputStreamReader(iStreamLocations);
    static JsonNode jsonNodePrompts;
    static JsonNode jsonNodeLocations;

    static {
        try {
            jsonNodePrompts = objectMapper.readTree(readerPrompts);
            jsonNodeLocations = objectMapper.readTree(readerLocations);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void getPrompt(String prompt) {
        System.out.println(jsonNodePrompts.findValue(prompt).asText());
    }

    public static ArrayNode getItems(String info) {
        return (ArrayNode) jsonNodeLocations.findValue(info).findValue("items");
    }

    public static String getName(String info) {
        return jsonNodeLocations.findValue(info).findValue("name").asText();
    }

    private static InputStream getFileFromResourceAsStream(String fileName) {
        ClassLoader classLoader = RoomThreeParser.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }
    }
}