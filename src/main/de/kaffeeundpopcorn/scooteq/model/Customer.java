package de.kaffeeundpopcorn.scooteq.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="customer")
@EntityListeners(AuditingEntityListener.class)
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    private int customerStatusId;

    private boolean driversLicense;

    private String address;

    private String city;

    private String postalCode;

    private String country;

    private Date birthDate;



}
