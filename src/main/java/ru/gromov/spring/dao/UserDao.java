package ru.gromov.spring.dao;


import ru.gromov.spring.model.User;

import java.util.List;

public interface UserDao {

   public List<User> getUserList();

   public User getUser(long id);

   public void saveUser(User user);

   public void deleteUser(long id);

   public void updateUser(User user);
}

