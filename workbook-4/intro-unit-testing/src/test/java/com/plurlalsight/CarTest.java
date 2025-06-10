package com.plurlalsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    public void accelerate_NormalSpeedChange_SpeedIncreased (){
        //Arrange
        Car exampleCar = new Car("Pagani", "Zonda");
        int speedChange = 15;
        int expectedSpeed = 15;


        //Act
        exampleCar.accelerate(speedChange);


        //Assert
        int actualSpeed = exampleCar.getSpeed();
        assertEquals(expectedSpeed, actualSpeed);

}

//    @Test
//    public void accelerate_NegativeSpeedChange_ThrowException () {
//        //Arrange
//        Car exampleCar = new Car("Pagani", "Zonda");
//        int speedChange = 15;
//        int expectedSpeed = 15;
//
//
//        //Act
//        exampleCar.accelerate(speedChange);
//
//
//        //Assert
//        int actualSpeed = exampleCar.getSpeed();
//        assertEquals(expectedSpeed, actualSpeed);
//    }

    @Test
    public void brake_NormalSpeedChange_SpeedDecreased(){
        //Arrange
        Car anotherCar = new Car("Dodge", "Hellcat");
        int speedUpBy = 15;
        int slowDownBy = 10;
        int expectedSpeed = 5;
        anotherCar.accelerate(speedUpBy);

        //Act
        anotherCar.brake(slowDownBy);

        //Assert
        int actualSpeed = anotherCar.getSpeed();
        assertEquals(expectedSpeed, actualSpeed);
    }

    public void brake_SpeedChangeGreaterThanActualSpeed_SpeedIsZero(){
        //Arrange
        Car anotheroneCar = new Car("Nissan", "Altima");
        int speedUpBy = 15;
        int slowDownBy = 10;
        int expectedSpeed = 0;
        anotheroneCar.accelerate(speedUpBy);

        //Act
        anotheroneCar.brake(slowDownBy);

        //Assert
        int actualSpeed = anotheroneCar.getSpeed();
        assertEquals(expectedSpeed, actualSpeed);

    }

}