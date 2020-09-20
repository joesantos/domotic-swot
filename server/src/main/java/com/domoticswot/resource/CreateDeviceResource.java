package com.domoticswot.resource;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Novo")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CreateDeviceResource {

  @PostMapping("/ArCondicionado")
  public String addAc() {
      return "ok";
  }

    @PostMapping("/Sensor")
    public String addSensor() {
        return "ok";
    }

    @PostMapping("/Lampada")
    public String addaddAc() {
        return "ok";
    }

}
