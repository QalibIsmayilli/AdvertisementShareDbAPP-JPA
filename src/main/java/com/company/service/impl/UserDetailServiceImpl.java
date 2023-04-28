package com.company.service.impl;

import com.company.dao.impl.UserDetailDaoImpl;
import com.company.dao.inter.UserDetailDaoInter;
import com.company.model.UserDetail;
import com.company.service.inter.UserDetailServiceInter;

public class UserDetailServiceImpl implements UserDetailServiceInter {
    private UserDetailDaoInter detailDao = new UserDetailDaoImpl();
    @Override
    public void saveUserDetail(UserDetail userDetail) {
        this.detailDao.saveUserDetail(userDetail);
    }

    @Override
    public void updateUserDetail(UserDetail userDetail) {
        this.detailDao.updateUserDetail(userDetail);
    }

    @Override
    public void removeUserDetail(UserDetail userDetail) {
        this.detailDao.removeUserDetail(userDetail);
    }

    @Override
    public UserDetail findById(Integer id) {
        return this.detailDao.findById(id);
    }

    @Override
    public UserDetail findByUsername(String username) {
        return this.detailDao.findByUsername(username);
    }

    @Override
    public UserDetail findWithAddressByUsername(String username) {
        return this.detailDao.findWithAddressByUsername(username);
    }

    @Override
    public UserDetail findWithAdvertisementByUsername(String username) {
        return this.detailDao.findWithAdvertisementByUsername(username);
    }
}
