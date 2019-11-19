package de.kaffeeundpopcorn.scooteq.model;

import de.kaffeeundpopcorn.scooteq.ScooteqAPI;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "customer")
@EntityListeners(AuditingEntityListener.class)
public class Customer
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerId", nullable = false)
    private Long customerId;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "CustomerStatusId", nullable = false)
    private int customerStatusId;

    @Column(name = "DriversLicense")
    private boolean driversLicense;

    @Column(name = "Address")
    private String address;

    @Column(name = "City")
    private String city;

    @Column(name = "PostalCode")
    private String postalCode;

    @Column(name = "Country")
    private String country;

    @Column(name = "BirthDate")
    private Date birthDate;

    //region Getters and setters
    public Long getCustomerId()
    {
        ScooteqAPI.LOGGER.info("return customer");
        return customerId;
    }

    public void setCustomerId(Long customerId)
    {
        this.customerId = customerId;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public int getCustomerStatusId()
    {
        return customerStatusId;
    }

    public void setCustomerStatusId(int customerStatusId)
    {
        this.customerStatusId = customerStatusId;
    }

    public boolean isDriversLicense()
    {
        return driversLicense;
    }

    public void setDriversLicense(boolean driversLicense)
    {
        this.driversLicense = driversLicense;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getPostalCode()
    {
        return postalCode;
    }

    public void setPostalCode(String postalCode)
    {
        this.postalCode = postalCode;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public Date getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(Date birthDate)
    {
        this.birthDate = birthDate;
    }
    //endregion

}
