package com.company.dao.inter;

import com.company.model.Education;

import java.util.List;

public interface EducationDaoInter {
    void saveEducation(Education education);

    void updateEducation(Education education);

    void removeEducation(Education education);

    List<Education> findEducations();

    Education findById(Integer id);

    Education findWithAdvertisementById(Integer id);
}
