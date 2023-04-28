package com.company.service.impl;

import com.company.dao.impl.UserDaoImpl;
import com.company.dao.inter.UserDaoInter;
import com.company.model.User;
import com.company.model.UserInfo;
import com.company.service.inter.UserServiceInter;

import java.util.List;

public class UserServiceImpl implements UserServiceInter {
    private UserDaoInter userDao = new UserDaoImpl();

    @Override
    public void saveUser(User u) {
        this.userDao.saveUser(u);
    }

    @Override
    public void updateUser(User u) {
        this.userDao.updateUser(u);
    }

    @Override
    public void removeUser(User u) {
        this.userDao.removeUser(u);
    }

    @Override
    public List<User> findUsers() {
        return this.userDao.findUsers();
    }

    @Override
    public List<User> findUsers(int minResult, int macResult) {
        return this.userDao.findUsers(minResult,macResult);
    }

    @Override
    public User findById(Integer id) {
        return this.userDao.findById(id);
    }

    @Override
    public User findUserByUsername(String username) {
        return this.userDao.findUserByUsername(username);
    }

    @Override
    public User findWithUserDetailByUsername(String username) {
        return this.userDao.findWithUserDetailByUsername(username);
    }

    @Override
    public int countOfUsers() {
        return this.userDao.countOfUsers();
    }

    @Override
    public UserInfo findUserInfoByUsername() {
        return this.userDao.findUserInfoByUsername();
    }
}
