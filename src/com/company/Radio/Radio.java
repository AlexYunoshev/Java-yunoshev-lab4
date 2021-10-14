package com.company.Radio;

import com.company.Device.Device;

public class Radio extends Device implements IRadio {
    StationList currentStation;
    Integer currentVolume;

    public Radio(String serialNumber, String manufacturer, String model) {
        super(serialNumber, manufacturer, model);
        currentStation = StationList.RadioRelax;
        currentVolume = 20;
    }

    public String GetFullProductDescription(){
        String output = "";
        output += "Радио " + GetFullProductName() + " с серийным номером " + GetSerialNumber() + "\n";
        if (GetCurrentStateOnOff() == true) {
            output += "Радио включено, выбрана станция " + GetCurrentStation() + " с громкостью " + GetCurrentVolume() + "\n";
        }
        else output += "Радио выключено\n";
        return output;
    }

    public StationList GetCurrentStation() {
        return currentStation;
    }

    public void IncrementStation() {
        currentStation = (currentStation.ordinal() == StationList.values().length - 1) ?
                StationList.values()[0] :
                StationList.values()[currentStation.ordinal() + 1];
    }

    public void DecrementStation() {
        currentStation = (currentStation.ordinal() == 0) ?
                StationList.values()[StationList.values().length - 1] :
                StationList.values()[currentStation.ordinal() - 1];
    }

    public Integer GetCurrentVolume() {
        return currentVolume;
    }

    public void IncrementVolume() {
        if (currentVolume < 100) currentVolume++;
    }

    public void DecrementVolume() {
        if (currentVolume > 0) currentVolume--;
    }

}
