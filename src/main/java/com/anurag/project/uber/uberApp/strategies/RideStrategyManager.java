package com.anurag.project.uber.uberApp.strategies;

import com.anurag.project.uber.uberApp.strategies.Impl.DriverMatchingHighestRateDriverStrategy;
import com.anurag.project.uber.uberApp.strategies.Impl.DriverMatchingNearestDriverStrategy;
import com.anurag.project.uber.uberApp.strategies.Impl.RideFareSurgePricingFareCalculationStrategy;
import com.anurag.project.uber.uberApp.strategies.Impl.RiderFareDefaultFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@RequiredArgsConstructor
public class RideStrategyManager {


    private final DriverMatchingHighestRateDriverStrategy highestRateDriverStrategy;
    private final DriverMatchingNearestDriverStrategy nearestDriverStrategy;
    private final RideFareSurgePricingFareCalculationStrategy surgePricingFareCalculationStrategy;
    private final RiderFareDefaultFareCalculationStrategy defaultFareCalculationStrategy;
    public DriverMatchingStrategy driverMatchingStrategy(double riderRating){
        if (riderRating >= 4.8){
            return highestRateDriverStrategy;
        }else{
            return nearestDriverStrategy;
        }
    }

    public RideFareCalculationStrategy rideFareCalculationStrategy(){

        //6PM to 9PM
        LocalTime surgeStartTime = LocalTime.of(18,0);
        LocalTime surgeEndTime = LocalTime.of(21,0);
        LocalTime currentTime = LocalTime.now();
        boolean isSurgeTime = currentTime.isAfter(surgeStartTime) && currentTime.isBefore(surgeEndTime);

        if (isSurgeTime){
            return surgePricingFareCalculationStrategy;
        }else {
            return defaultFareCalculationStrategy;
        }
    }

}
