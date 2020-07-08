package com.domoticswot.resource;

import com.domoticswot.hardware.ControlGpioExample;
import com.domoticswot.service.DispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Dispositivo")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DispositivoResource {

    @Autowired
    DispositivoService dispositivoService;

    @Autowired
    ControlGpioExample controlGpioExample;

    @GetMapping("/ligar")
    public String SwitchOn(
            @RequestParam String id
    ) {
        return dispositivoService.ligarDispositivo(id);
    }

    @GetMapping("/desligar")
    public String SwitchOff(
            @RequestParam String id
    ) {
        return dispositivoService.desligarDispositivo(id);
    }
}
