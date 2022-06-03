package com.mbadr.tddjunit5.airconditioning;

public class AirConditioningSystem {
    private Thermometer thermometer;
    private double thermometerThreshold;
    private boolean open;

    public AirConditioningSystem() {
        open = false;
    }


    public void checkAirConditioningSystem() {
        this.open = thermometer.getTemperature() > thermometerThreshold;
    }



    public void setThermometer(Thermometer thermometer) {
        this.thermometer = thermometer;
    }

    public void setThermometerThreshold(double thermometerThreshold) {
        this.thermometerThreshold = thermometerThreshold;
    }

    public boolean isOpen() {
        return open;
    }
}
