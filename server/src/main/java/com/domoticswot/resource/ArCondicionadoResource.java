package com.domoticswot.resource;

import com.domoticswot.hardware.ControlGpioExample;
import com.domoticswot.model.AcDTO;
import com.domoticswot.service.ArCondicionadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ArCondicionado")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ArCondicionadoResource {
    @Autowired
    ArCondicionadoService arCondicionadoService;

    @Autowired
    ControlGpioExample controlGpioExample;

    @GetMapping("/aumentar-temperatura")
    public String aumentarTemperatura(
            @RequestParam String id
    ) {
        return arCondicionadoService.aumentarTemperatura(id);
    }

    @GetMapping("/reduzir-temperatura")
    public String reduzirTemperatura(
            @RequestParam String id
    ) {
        return arCondicionadoService.reduzirTemperatura(id);
    }

    @GetMapping("/definir-temperatura")
    public String definirTemperatura(
            @RequestParam String id,
            @RequestParam Integer temperature
    ){
        return arCondicionadoService.definirTemperatura(id, temperature);
    }

    @GetMapping("/list")
    public List<AcDTO> listAcs(

    ){
        return arCondicionadoService.listAcs();
    }
}
