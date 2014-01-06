package com.boardgamebrag.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.boardgamebrag.model.Game;

@Service
public class GameService extends BaseService {
    
    private static final Log log = LogFactory.getLog(GameService.class);
    
//    private UserDAOImpl userDao;
    
    public List<Game> getGamesLike(Game game) {
        List<Game> games = new ArrayList<Game>();
        for(int i = 0; i < 10; i++) {
            games.add(new Game("Game " + i, null, 1, 4, null, null, null, null));
        }
        return games;
    }
    
//    @Autowired
//    public void setUserDao(UserDAOImpl userDao) {
//        this.userDao = userDao;
//    }
}
