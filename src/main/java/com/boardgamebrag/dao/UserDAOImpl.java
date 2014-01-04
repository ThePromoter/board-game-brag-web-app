package com.boardgamebrag.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Repository;

import com.boardgamebrag.model.User;

@Repository
public class UserDAOImpl extends BaseDAO implements UserDAO {
    
    private static final Log log = LogFactory.getLog(UserDAOImpl.class);
    
    public User saveUser(User user) {
        User result = (User) getSession().merge(user);
        return result;
    }
    
    public void deleteUser(User user) {
        getSession().delete(user);
    }
    
    public User findById(long id) {
        User instance = (User) getSession().get(User.class.getCanonicalName(), id);
        return instance;
    }
    
    public List<User> findByExample(User instance) {
        List results = getSession().createCriteria(User.class).add(Example.create(instance)).list();
        return results;
    }
}
