package com.boardgamebrag.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.boardgamebrag.model.Game;
import com.boardgamebrag.model.GameSession;

@Service
public class GameService extends BaseService {
    
    private static final Log log = LogFactory.getLog(GameService.class);
    
//    private UserDAOImpl userDao;
    
    public List<Game> getGamesLike(Game game) {
        List<Game> games = new ArrayList<Game>();
        for(long i = 0; i < 10; i++) {
            Game newGame = new Game("Game " + i, null, 1, 4, null, null, null, null);
            newGame.setGameId(i);
            Map<String, String> imageUrls = new HashMap<String, String>();
            imageUrls.put("TINY", "http://cf.geekdo-images.com/images/pic1083380_sq.jpg");
            imageUrls.put("SMALL", "http://cf.geekdo-images.com/images/pic1083380_t.jpg");
            imageUrls.put("MEDIUM", "http://cf.geekdo-images.com/images/pic1083380_md.jpg");
            imageUrls.put("LARGE", "http://cf.geekdo-images.com/images/pic1083380_lg.jpg");
            newGame.setImageUrls(imageUrls);
            games.add(newGame);
        }
        return games;
    }
    
    public Game getGameById(long gameId) {
        Game newGame = new Game("Game " + gameId, null, 1, 4, null, null, null, null);
        newGame.setGameId(gameId);
        Map<String, String> imageUrls = new HashMap<String, String>();
        imageUrls.put("TINY", "http://cf.geekdo-images.com/images/pic1083380_sq.jpg");
        imageUrls.put("SMALL", "http://cf.geekdo-images.com/images/pic1083380_t.jpg");
        imageUrls.put("MEDIUM", "http://cf.geekdo-images.com/images/pic1083380_md.jpg");
        imageUrls.put("LARGE", "http://cf.geekdo-images.com/images/pic1083380_lg.jpg");
        newGame.setImageUrls(imageUrls);
        return newGame;
    }

    public GameSession createGameSession(GameSession gameSession) {
        return gameSession;
    }
    
//    @Autowired
//    public void setUserDao(UserDAOImpl userDao) {
//        this.userDao = userDao;
//    }
}
