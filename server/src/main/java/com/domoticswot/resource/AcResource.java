package com.domoticswot.resource;

import com.domoticswot.hardware.ControlGpioExample;
import com.domoticswot.model.AcDTO;
import com.domoticswot.service.AcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ac")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AcResource {
    @Autowired
    AcService acService;

    @Autowired
    ControlGpioExample controlGpioExample;

    @GetMapping("/aumentar-temperatura")
    public String aumentarTemperatura(
            @RequestParam String id
    ) {
        return acService.aumentarTemperatura(id);
    }

    @GetMapping("/reduzir-temperatura")
    public String reduzirTemperatura(
            @RequestParam String id
    ) {
        return acService.reduzirTemperatura(id);
    }

    @GetMapping("/list-ac")
    public List<AcDTO> listAcs(

    ){
        return acService.listAcs();
    }
}
