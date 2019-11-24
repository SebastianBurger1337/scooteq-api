package de.kaffeeundpopcorn.scooteqapi.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="scooter")
@EntityListeners(AuditingEntityListener.class)
public class Scooter
{
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ScooterId", nullable = false)
    private int id;
    @Getter
    @Setter
    @Column(name = "ModelID")
    private int modelId;
    @Getter
    @Setter
    @Column(name = "gefahreneMeter")
    private int metersDriven;
    @Getter
    @Setter
    @Column(name = "Name")
    private String color;
    @Getter
    @Setter
    @Column(name = "Akquisition")
    private Date acquisition;





}
