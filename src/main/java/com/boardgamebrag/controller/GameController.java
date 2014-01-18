package com.boardgamebrag.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.boardgamebrag.model.Game;
import com.boardgamebrag.model.GameSession;
import com.boardgamebrag.service.GameService;

@Controller
public class GameController {
    
    private GameService gameService;
    
    @RequestMapping(value="/game", method = RequestMethod.GET)
    public List<Game> getGames() throws Exception {
        return gameService.getGamesLike(null);
    }
    
    @RequestMapping(value="/game/{gameId}", method = RequestMethod.GET)
    public Game getUser(@PathVariable long gameId) {
        return gameService.getGameById(gameId);
    }
    
    @RequestMapping(value="/game-session", method = RequestMethod.POST)
    public GameSession createGameSession(@RequestBody GameSession gameSession) throws Exception {
        return gameService.createGameSession(gameSession);
    }
    
    @Autowired
    public void setGameService(GameService gameService) {
        this.gameService = gameService;
    }
}