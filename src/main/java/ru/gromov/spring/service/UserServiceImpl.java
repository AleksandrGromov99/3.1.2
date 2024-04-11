package ru.gromov.spring.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gromov.spring.dao.UserDao;
import ru.gromov.spring.model.User;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getUserList() {
        return userDao.getUserList();
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Transactional
    @Override
    public void updateUser(User user){
        userDao.updateUser(user);
    }
    @Transactional(readOnly = true)
    @Override
    public User getUser(long id){
        return userDao.getUser(id);
    }

    @Transactional
    @Override
    public void deleteUser(long id){
        userDao.deleteUser(id);
    }
}