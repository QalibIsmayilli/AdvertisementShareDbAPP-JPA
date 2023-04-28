package com.company.model;

import com.company.util.PhoneType;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "UserDetail.findById", query = "select ud from UserDetail ud where ud.id = :id"),
        @NamedQuery(name = "UserDetail.findByUsername",
                query = "select ud from UserDetail ud where ud.user.username=:username"),
        @NamedQuery(name = "UserDetail.findWithAddressByUsername",
                query = "select ud from UserDetail ud left join ud.addresses where ud.user.username=:username"),
        @NamedQuery(name = "UserDetail.findWithAdvertisementByUsername",
                query = "select ud from UserDetail ud left join ud.advertisements where ud.user.username = :username")
})
public class UserDetail implements Serializable,DMLable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date", nullable = false)
    private Date birthDate;

    @OneToMany(mappedBy = "userDetail")
    private List<Advertisement> advertisements = new ArrayList<>();


    @OneToOne(mappedBy = "userDetail")
    private User user;

    @ElementCollection
    @CollectionTable(name = "user_numbers",joinColumns = @JoinColumn(name = "user_detail_id"))
    @MapKeyColumn(name = "phone_type")
    @Column(name = "phone_number")
    private Map<PhoneType, String> phoneNumbers = new HashMap<>();

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "user_addresses", joinColumns = @JoinColumn(name = "user_detail_id"))
    @Column(name = "Address")
    private List<Address> addresses = new ArrayList<>();

    public UserDetail() {
    }

    public UserDetail(String firstName, String lastName, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }


    public Integer getId() {
        return id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Map<PhoneType, String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Map<PhoneType, String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public List<Advertisement> getAdvertisements() {
        return advertisements;
    }

    public void setAdvertisements(List<Advertisement> advertisements) {
        this.advertisements = advertisements;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
