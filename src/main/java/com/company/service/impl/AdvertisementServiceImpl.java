package com.company.service.impl;

import com.company.dao.impl.AdvertisementDaoImpl;
import com.company.dao.inter.AdvertisemenDaoInter;
import com.company.model.Advertisement;
import com.company.service.inter.AdvertisementServiceInter;

import java.util.List;

public class AdvertisementServiceImpl implements AdvertisementServiceInter {
    private AdvertisemenDaoInter dao = new AdvertisementDaoImpl();

    @Override
    public void saveAdvertisement(Advertisement advertisement) {
        this.dao.saveAdvertisement(advertisement);
    }

    @Override
    public void updateAdvertisement(Advertisement advertisement) {
        this.dao.updateAdvertisement(advertisement);
    }

    @Override
    public void removeAdvertisement(Advertisement advertisement) {
        this.dao.removeAdvertisement(advertisement);
    }

    @Override
    public Advertisement findById(Integer id) {
        return this.dao.findById(id);
    }

    @Override
    public Advertisement findByUsername(String username) {
        return this.dao.findByUsername(username);
    }

    @Override
    public List<Advertisement> findAdvertisements() {
        return this.dao.findAdvertisements();
    }
}
