package com.anurag.project.uber.uberApp.configs;

import com.anurag.project.uber.uberApp.dto.PointDto;
import com.anurag.project.uber.uberApp.utils.GeometryUtil;
import org.locationtech.jts.geom.Point;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper modelMapper(){

        ModelMapper mapper = new ModelMapper();
        // to store dropOfLocation and pickUpLocation because these are coming from PointDto to Point  and to store we have to convert it .
        mapper.typeMap(PointDto.class, Point.class).setConverter(context ->{
            PointDto pointDto = context.getSource();
            return GeometryUtil.createPoint(pointDto);
        });
        mapper.typeMap(Point.class, PointDto.class).setConverter(context ->{
            Point point = context.getSource();
            double coordinates[] = {
                    point.getX(),
                    point.getY()
            };
            return new PointDto(coordinates);
        });
        return mapper;
    }
}
