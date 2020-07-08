package com.domoticswot.monitor;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DeviceListener {
    @Scheduled(fixedDelay = 1000, initialDelay = 1000)
    public void testingScheduling(){
        System.out.println("Verificando sensores...");
    }
}
