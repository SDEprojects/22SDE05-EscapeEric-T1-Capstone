package com.ericsHouse.jsonParser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class RoomZeroPrompts {
    File roomZeroPrompts = new File("../22SDE05-EscapeEric/resources/roomZeroPrompts.json");
    ObjectMapper objectMapper = new ObjectMapper();
    static JsonNode jsonNode;

    {
        try {
            jsonNode = objectMapper.readTree(roomZeroPrompts);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void roomZeroPrompt(String prompt) {
        System.out.println(jsonNode.findValue(prompt).asText());
    }
}
