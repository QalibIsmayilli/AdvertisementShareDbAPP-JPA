package com.company.service.inter;

import com.company.model.Education;

import java.util.List;

public interface EducationServiceInter {
    void saveEducation(Education education);

    void updateEducation(Education education);

    void removeEducation(Education education);

    List<Education> findEducations();

    Education findById(Integer id);

    Education findWithAdvertisementById(Integer id);
}
