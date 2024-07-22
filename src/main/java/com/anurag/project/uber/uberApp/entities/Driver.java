package com.anurag.project.uber.uberApp.entities;

import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Point;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private  User user;
    private  Double rating;
    private Boolean available;

    @Column(columnDefinition = "Geometry(Point, 4326)") // defining earth geometry
    Point currentLocation;
}
