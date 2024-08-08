package com.anurag.project.uber.uberApp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PointDto {

    private  double[] coordinates; // to store coordinates
    private  String type = "Point";  // means geoSpatial points

    public PointDto(double[] coordinates) {
        this.coordinates = coordinates;
    }
}
