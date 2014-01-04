package com.boardgamebrag.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boardgamebrag.dao.UserDAOImpl;
import com.boardgamebrag.model.User;
import com.boardgamebrag.util.Encryption;
import com.boardgamebrag.util.NullAwareBeanUtilsBean;
import com.boardgamebrag.util.PasswordUtil;

@Service
public class UserService extends BaseService {
    
    private static final Log log = LogFactory.getLog(UserService.class);
    
    private UserDAOImpl userDao;
    
    public List<User> getUsersLike(User user) {
        return userDao.findByExample(user);
    }
    
    public User getUser(long userId) {
        return userDao.findById(userId);
    }
    
    public User createUser(User user) {
        if (user.getPassword() != null) {
            String salt = PasswordUtil.generateSalt();
            String passwordHash = Encryption.hashToBase64(user.getPassword(), salt);
            
            user.setPasswordHash(passwordHash);
            user.setPasswordSalt(salt);
        }
        
        return userDao.saveUser(user);
    }
    
    @Transactional
    public User updateUser(User user) {
        User updatedUser = userDao.findById(user.getUserId());
        try {
            NullAwareBeanUtilsBean.copyPropertiesIgnoreNull(updatedUser, user);
        } catch (IllegalAccessException e) {
            log.error("Error copying properties while updating user", e);
        } catch (InvocationTargetException e) {
            log.error("Error copying properties while updating user", e);
        }
        
        return userDao.saveUser(updatedUser);
    }

    @Autowired
    public void setUserDao(UserDAOImpl userDao) {
        this.userDao = userDao;
    }
}
