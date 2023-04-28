package com.company.service.inter;

import com.company.model.UserDetail;

public interface UserDetailServiceInter {
    void saveUserDetail(UserDetail userDetail);

    void updateUserDetail(UserDetail userDetail);

    void removeUserDetail(UserDetail userDetail);

    UserDetail findById(Integer id);

    UserDetail findByUsername(String username);

    UserDetail findWithAddressByUsername(String username);

    UserDetail findWithAdvertisementByUsername(String username);
}
