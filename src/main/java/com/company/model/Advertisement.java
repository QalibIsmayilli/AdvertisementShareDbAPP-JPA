package com.company.model;

import jakarta.persistence.*;

import javax.naming.Name;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Advertisement.findById" , query = "select a from Advertisement a where a.id = :id"),
        @NamedQuery(name = "Advertisement.findByUsername", query = "select a from Advertisement a where a.userDetail.user.username = :username"),
        @NamedQuery(name = "Advertisement.findAdvertisements", query = "select a from Advertisement a")
})
public class Advertisement implements Serializable,DMLable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "work_definition")
    @Lob
    private String workDefinition;

    @Column(name = "criteria")
    @Lob
    private String criteria;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "add_date")
    private Date addDate = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "enabled")
    private boolean enabled = false;

    @ManyToMany
    @JoinTable(name = "advertisement_education", joinColumns = @JoinColumn(name = "advertisement_id")
            ,inverseJoinColumns = @JoinColumn(name = "education_id"))
    private List<Education> educations = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "user_detail_id")
    private UserDetail userDetail;

    public Advertisement() {
    }

    public Advertisement(String title, String workDefinition, String criteria) {
        this.title = title;
        this.workDefinition = workDefinition;
        this.criteria = criteria;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWorkDefinition() {
        return workDefinition;
    }

    public void setWorkDefinition(String workDefinition) {
        this.workDefinition = workDefinition;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }
}
