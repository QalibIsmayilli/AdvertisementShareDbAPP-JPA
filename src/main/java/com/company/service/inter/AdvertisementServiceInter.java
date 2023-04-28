package com.company.service.inter;

import com.company.model.Advertisement;

import java.util.List;

public interface AdvertisementServiceInter {
    void saveAdvertisement(Advertisement advertisement);

    void updateAdvertisement(Advertisement advertisement);

    void removeAdvertisement(Advertisement advertisement);

    Advertisement findById(Integer id);

    Advertisement findByUsername(String username);

    List<Advertisement> findAdvertisements();
}
