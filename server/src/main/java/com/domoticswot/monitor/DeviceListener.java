package com.domoticswot.monitor;

import com.domoticswot.service.UpdateSensorService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DeviceListener {
    @Scheduled(fixedDelay = 10000, initialDelay = 10000)
    public void testingScheduling(){

        System.out.println("Verificando sensores...");
        UpdateSensorService.updateSensors();
    }

}
