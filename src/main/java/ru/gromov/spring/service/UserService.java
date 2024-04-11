package ru.gromov.spring.service;


import ru.gromov.spring.model.User;

import java.util.List;

public interface UserService {

    public List<User> getUserList();

    public void saveUser(User user);

    public User getUser(long id);

    public void updateUser(User user);

    public void deleteUser(long id);

}
