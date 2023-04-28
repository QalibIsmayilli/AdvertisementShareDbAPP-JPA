package com.company.service.inter;

import com.company.model.User;
import com.company.model.UserInfo;

import java.util.List;

public interface UserServiceInter {
    void saveUser(User u);

    void updateUser(User u);

    void removeUser(User u);

    List<User> findUsers();

    List<User> findUsers(int minResult, int macResult);

    User findById(Integer id);

    User findUserByUsername(String username);

    User findWithUserDetailByUsername(String username);

    int countOfUsers();

    UserInfo findUserInfoByUsername();
}
