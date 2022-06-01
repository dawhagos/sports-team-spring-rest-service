package com.hagos.sportsteam.service;

import com.hagos.sportsteam.model.Player;
import com.hagos.sportsteam.model.Players;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PlayerService {
    public Player generateJersey(Player player) {
        Random random = new Random();
        for(int i = 1; i <=10; i++) {
            int value = random.nextInt((10 - 1) + 1) + 1;
            player.setJersey(Integer.toString(value));
        }

        return player;
    }

    public Players generateJerseys(Players players) {
//        List<Player> player = new ArrayList<>();
//        player = players.getPlayer();
//        players.getPlayer()
        for (Player player : players.getPlayer()) {
            Random random = new Random();
            for (int j = 1; j <= 10; j++) {
                int value = random.nextInt((10 - 1) + 1) + 1;
                player.setJersey(Integer.toString(value));
            }
        }

        return players;
    }

}
