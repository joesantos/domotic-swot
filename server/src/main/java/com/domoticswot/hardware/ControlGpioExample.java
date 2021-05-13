package com.domoticswot.hardware;

/*
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: Java Examples
 * FILENAME      :  ControlGpioExample.java
 *
 * This file is part of the Pi4J project. More information about
 * this project can be found here:  https://www.pi4j.com/
 * **********************************************************************
 * %%
 * Copyright (C) 2012 - 2019 Pi4J
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 *
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import org.springframework.stereotype.Service;

/**
 * This example code demonstrates how to perform simple state
 * control of a GPIO pin on the Raspberry Pi.
 *
 * @author Robert Savage
 */
@Service
public class ControlGpioExample {

    public String setStatusTrue(String raspiPinName) {
        try{
            System.out.println("<--Pi4J--> GPIO Control Example ... started.");

            // create gpio controller
            final GpioController gpio = GpioFactory.getInstance();

            // provision gpio pin #01 as an output pin and turn on
            GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.getPinByName(raspiPinName), "MyLED", PinState.LOW);

            pin.high();

            gpio.removeAllTriggers();
            gpio.removeAllListeners();
            gpio.shutdown();
            gpio.unprovisionPin(pin);
            System.out.println("Exiting ControlGpioExample");
        }catch(Exception e){
            System.out.println("Deu ruim" + e.getMessage());
        }
        return "ok";
    }

    public String setStatusFalse(String raspiPinName) {
        try{
            System.out.println("<--Pi4J--> GPIO Control Example ... started.");

            // create gpio controller
            final GpioController gpio = GpioFactory.getInstance();

            // provision gpio pin #01 as an output pin and turn on
            final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.getPinByName(raspiPinName), "MyLED", PinState.LOW);

            pin.low();
            gpio.removeAllTriggers();
            gpio.removeAllListeners();
            gpio.shutdown();
            gpio.unprovisionPin(pin);
            System.out.println("Exiting ControlGpioExample");
        }catch(Exception e){
            System.out.println("Deu ruim" + e.getMessage());
        }
        return "ok";
    }
}
