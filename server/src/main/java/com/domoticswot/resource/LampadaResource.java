package com.domoticswot.resource;

import com.domoticswot.hardware.ControlGpioExample;
import com.domoticswot.service.LampadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lampada")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LampadaResource {

    @Autowired
    LampadaService lampadaService;

    @Autowired
    ControlGpioExample controlGpioExample;

    @GetMapping("/acender")
    public String SwitchOn(
            @RequestParam String id
    ) {
        return lampadaService.acenderLampada(id);
    }

    @GetMapping("/apagar")
    public String SwitchOff(
            @RequestParam String id
    ) {
        return lampadaService.apagarLampada(id);
    }
}
