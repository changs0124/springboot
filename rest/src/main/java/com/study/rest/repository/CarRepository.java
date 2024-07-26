package com.study.rest.repository;

import com.study.rest.entity.Car;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarRepository {
    public Car findCarByModel(String model) {
        Car findCar = null;

        Car sonata = Car.builder()
                    .model("쏘나타")
                    .color("화이트")
                    .build();
        Car k5 = Car.builder()
                .model("K5")
                .color("블랙")
                .build();
        List<Car> cars = List.of(sonata, k5);


        for(Car car : cars) {
            if(car.getModel().equals(model)) {
                findCar = car;
            }
        }

//        return cars.stream().filter(car -> car.getModel().equals(model)).collect(Collectors.toList()).get(0);
        return findCar;
    }

}
