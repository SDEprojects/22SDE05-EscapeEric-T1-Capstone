package com.ericsHouse.jsonParser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.File;
import java.io.IOException;

public class RoomOneParser {
    static File roomOnePrompts = new File("../22SDE05-EscapeEric/resources/roomOnePrompts.json");
    static File location = new File("../22SDE05-EscapeEric/resources/locations.json");
    static ObjectMapper objectMapper = new ObjectMapper();
    static JsonNode jsonNodePrompts;
    static JsonNode jsonNodeInfo;

    static {
        try {
            jsonNodePrompts = objectMapper.readTree(roomOnePrompts);
            jsonNodeInfo = objectMapper.readTree(location);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void getPrompt(String prompt) {
        System.out.println(jsonNodePrompts.findValue(prompt).asText());
    }

    public static ArrayNode getItems(String info) {
        return (ArrayNode) jsonNodeInfo.findValue(info).findValue("items");
    }

    public static String getName(String info) {
        return jsonNodeInfo.findValue(info).findValue("name").asText();
    }

}