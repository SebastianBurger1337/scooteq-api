package de.kaffeeundpopcorn.scooteqapi.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;

/**
 * Class representing a rental, used for purposes of serialization.
 */
@Entity
@Table(name = "Rental")
@EntityListeners(AuditingEntityListener.class)
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RentalId", nullable = false)
    private int rentalId;

    @Column(name = "CustomerId", nullable = false)
    private int customerId;

    @Column(name = "ScooterId", nullable = false)
    private int scooterId;

    @Column(name = "RentalBegin")
    private java.util.Date rentalBegin;

    @Column(name = "RentalEnd")
    private java.util.Date rentalEnd;

    @Column(name = "RentalStatusId")
    private int rentalStatusId;

    @Column(name = "Distance")
    private int distance;

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getScooterId() {
        return scooterId;
    }

    public void setScooterId(int scooterId) {
        this.scooterId = scooterId;
    }

    public java.util.Date getRentalBegin() {
        return rentalBegin;
    }

    public void setRentalBegin(java.util.Date rentalBegin) {
        this.rentalBegin = rentalBegin;
    }

    public java.util.Date getRentalEnd() {
        return rentalEnd;
    }

    public void setRentalEnd(java.util.Date rentalEnd) {
        this.rentalEnd = rentalEnd;
    }

    public int getRentalStatusId() {
        return rentalStatusId;
    }

    public void setRentalStatusId(int rentalStatusId) {
        this.rentalStatusId = rentalStatusId;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
