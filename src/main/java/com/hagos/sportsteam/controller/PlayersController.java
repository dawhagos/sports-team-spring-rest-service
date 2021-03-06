package com.hagos.sportsteam.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.hagos.sportsteam.model.Players;
import com.hagos.sportsteam.service.PlayerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.java.Log;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Players")
@Log
public class PlayersController {

    private PlayerService playerService;

    public PlayersController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping(path = "/playersxml", produces = {MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getPlayersXml(@RequestBody String playersStr) {
        log.info(String.format("[/playersxml] POST endpoint invoked"));
        try {
            XmlMapper xmlMapper = new XmlMapper();
            Players players = xmlMapper.readValue(playersStr, Players.class);
            Players playerList = playerService.generateJerseys(players);
            return ResponseEntity.ok(playerList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping(path = "/playersjson", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getPlayersJson(@RequestBody String playersStr) {
        log.info(String.format("[/playersjson] POST endpoint invoked"));
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Players players = objectMapper.readValue(playersStr, Players.class);
            Players playerList = playerService.generateJerseys(players);
            return ResponseEntity.ok(playerList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
