package com.company.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;


@Entity
@NamedQueries({
        @NamedQuery(name = "User.findUserById", query = "select u from User u left join fetch u.userDetail where u.id=:userId"),
        @NamedQuery(name = "User.findUserByUsername", query = "select u from User u left join u.userDetail where u.username=:username"),
        @NamedQuery(name = "User.findWithUserDetailByUsername", query = "select u from User u left join u.userDetail where u.username=:username"),
        @NamedQuery(name = "User.findUsers", query = "select u from User u"),
        @NamedQuery(name = "User.count", query = "select count(u) from User u"),
        @NamedQuery(name = "User.findUserInfoByUsername", query = "select " +
                "new com.company.model.UserInfo(u.username, u.userDetail.firstName, u.userDetail.lastName, u.userDetail.birthDate) " +
                "from User u")
})
public class User implements Serializable,DMLable {

    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_detail_id")
    private UserDetail userDetail;

    public User() {
    }

    public User( String username, String password, Date creationDate, UserDetail userDetail) {
        this.username = username;
        this.password = password;
        this.creationDate = creationDate;
        this.userDetail = userDetail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }
}
