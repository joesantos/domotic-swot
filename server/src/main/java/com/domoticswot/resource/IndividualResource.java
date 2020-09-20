package com.domoticswot.resource;


import com.domoticswot.model.Dispositivo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/devices")
public class IndividualResource {
    /*
    * Aqui teremos métodos relacionados aos indivíduos, como buscar indivíduos para a camada de apresentação ou adicionar um novo dispositivo
    * */

    public Dispositivo dispositivo = Dispositivo.builder()
            .uri(null)
            .hasName("sensor de temperatura do forno")
            .hasId(UUID.randomUUID())
            .isMute(false)
            .hasStatus(false)
            .hasValue(null)
            .hasVolume(null)
            .build();


    @GetMapping
    private List<Dispositivo> getDevices(){
        List<Dispositivo> list = new ArrayList<Dispositivo>();
        list.add(dispositivo);

        return list;
    }


    @PostMapping
    private String addDevice(){
        return "sdf";
    }

}
