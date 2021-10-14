package com.company.AC;

import com.company.Device.Device;

public class AirConditioner extends Device implements IAirConditioner {

    ACModes currentACMode; // режим кондиціонера
    Integer currentTemperature;



    public AirConditioner(String serialNumber, String manufacturer, String model) {
        super(serialNumber, manufacturer, model);
        currentACMode = ACModes.Cooling;
        currentTemperature = 25;
    }

    public void OFF() {
        super.OFF();
        StopTimer();
    }

    public String GetFullProductDescription(){
        String output = "";
        output += "Кондиционер " + GetFullProductName() + " с серийным номером " + GetSerialNumber() + "\n";

        if (GetCurrentStateOnOff() == true) {
            output += "Кондиционер работает в режиме: " + GetCurrentACMode() +
                    ", установлена температура " + GetTemperature() + " градусов\n";
            if (GetTimerState() == true) output += "Таймер установлен на " + GetTimerValue() + ".\n";
            else output += "Таймер не установлен.\n";
        }
        else output += "Кондиционер выключен\n";

        return output;
    }

    public ACModes GetCurrentACMode() {
        return currentACMode;
    }

    public void SetCurrentACMode(ACModes mode) {
        currentACMode = mode;
    }

    public Integer GetTemperature() {
        return currentTemperature;
    }

    public void IncrementTemperature() {
        if(currentTemperature < 35)  currentTemperature++;
    }
    public void DecrementTemperature() {
        if(currentTemperature > 15)  currentTemperature--;
    }

}
