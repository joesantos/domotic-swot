package com.domoticswot.hardware;

import org.springframework.stereotype.Service;

@Service
public class VirtualDevice {
    public void aumentarTemperaturaAc(int value){
        System.out.println("Temperatura aumentada. Atual é: " + value + "ºC");
    }

    public void reduzirTemperaturaAc(int value){
        System.out.println("Temperatura reduzida. Atual é: " + value + "ºC");
    }

    public void acenderLampada(){

    }

    public void apagarLampada(){

    }
}
