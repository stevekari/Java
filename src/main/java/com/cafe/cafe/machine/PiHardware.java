package com.cafe.cafe.machine;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;

public class PiHardware {

    private GpioPinDigitalOutput pump;
    private GpioPinDigitalOutput heater;

    public PiHardware() {
        GpioController gpio = GpioFactory.getInstance();
        pump = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01);
        heater = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02);
    }

    public void startPump() {
        pump.high();
    }

    public void stopPump() {
        pump.low();
    }

    public void heatWater() {
        heater.high();
    }

    public void stopHeating() {
        heater.low();
    }
}