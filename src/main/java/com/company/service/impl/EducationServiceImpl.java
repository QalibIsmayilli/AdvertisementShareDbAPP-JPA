package com.company.service.impl;

import com.company.dao.impl.EducationDaoImpl;
import com.company.dao.inter.EducationDaoInter;
import com.company.model.Education;
import com.company.service.inter.EducationServiceInter;

import java.util.List;

public class EducationServiceImpl implements EducationServiceInter {
    private EducationDaoInter educationDao = new EducationDaoImpl();
    @Override
    public void saveEducation(Education education) {
        this.educationDao.saveEducation(education);
    }

    @Override
    public void updateEducation(Education education) {
        this.educationDao.updateEducation(education);
    }

    @Override
    public void removeEducation(Education education) {
        this.educationDao.removeEducation(education);
    }

    @Override
    public List<Education> findEducations() {
        return this.educationDao.findEducations();
    }

    @Override
    public Education findById(Integer id) {
        return this.educationDao.findById(id);
    }

    @Override
    public Education findWithAdvertisementById(Integer id) {
        return this.educationDao.findWithAdvertisementById(id);
    }
}
