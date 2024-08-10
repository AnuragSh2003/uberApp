package com.anurag.project.uber.uberApp.repositories;

import com.anurag.project.uber.uberApp.entities.Driver;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


// ST_Distance(point1,point2)
//ST_DWITHIN(point1,10000)  it is just like a boolean function with return if certain condition true or false
@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {

    //
    @Query(value = "Select d.*,ST_Distance(d.current_location, :pickupLocation) AS distance " +
            "FROM driver d " +
            "where d.available = true AND ST_DWithin(d.current_location, :pickupLocation, 10000) " +
            "ORDER BY distance " +
            "LIMIT 10",nativeQuery = true)
    List<Driver> findTenNearestDrivers(Point pickupLocation);
}
