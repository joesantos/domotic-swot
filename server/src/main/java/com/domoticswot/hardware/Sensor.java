package com.domoticswot.hardware;


import java.util.Random;

public class Sensor {
    public static int updateValue(){
        Random random = new Random();

        return random.nextInt(40) + 1;
    }
}
