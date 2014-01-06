package com.boardgamebrag.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.boardgamebrag.model.Game;
import com.boardgamebrag.service.GameService;

@Controller
@RequestMapping("/game")
public class GameController {
    
    private GameService gameService;
    
    @RequestMapping(value="", method = RequestMethod.GET)
    public List<Game> getGames() throws Exception {
        return gameService.getGamesLike(null);
    }
    
    @RequestMapping(value="/{gameId}", method = RequestMethod.GET)
    public Game getUser(@PathVariable long gameId) {
        return new Game();
    }

    @Autowired
    public void setGameService(GameService gameService) {
        this.gameService = gameService;
    }
}