package com.company.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Education.findEducations", query = "select e from Education e "),
        @NamedQuery(name = "Education.findById", query = "select e from Education e where e.id = :id"),
        @NamedQuery(name = "Education.findWithAdvertisementById",
                query = "select e from Education e left join fetch e.advertisements where e.id=:id")
})
public class Education implements Serializable , DMLable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "education_name")
    private String educationName;

    @Column(name = "license_year")
    private Integer licenseYear;

    @ManyToMany(mappedBy = "educations",fetch = FetchType.LAZY)
    private List<Advertisement> advertisements = new ArrayList<>();

    public Education() {
    }

    public Education(String educationName, Integer licenseYear) {
        this.educationName = educationName;
        this.licenseYear = licenseYear;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEducationName() {
        return educationName;
    }

    public void setEducationName(String educationName) {
        this.educationName = educationName;
    }

    public Integer getLicenseYear() {
        return licenseYear;
    }

    public void setLicenseYear(Integer licenseYear) {
        this.licenseYear = licenseYear;
    }

    public List<Advertisement> getAdvertisements() {
        return advertisements;
    }

    public void setAdvertisements(List<Advertisement> advertisements) {
        this.advertisements = advertisements;
    }

    @Override
    public String toString() {
        return "Education{" +
                "id=" + id +
                ", educationName='" + educationName + '\'' +
                ", licenseYear=" + licenseYear +
                ", advertisements=" + advertisements +
                '}';
    }
}
