package com.company.KitchenHood;

import com.company.Device.Device;

public class Hood extends Device implements IHood{
    Integer speed;
    Boolean backlight;

    public Hood(String serialNumber, String manufacturer, String model) {
        super(serialNumber, manufacturer, model);
        speed = 0;
        backlight = false;
    }

    public String GetFullProductDescription(){
        String output = "";
        output += "Вытяжка " + GetFullProductName() + " с серийным номером " + GetSerialNumber() + "\n";
        if (GetCurrentStateOnOff() && GetCurrentBacklight() == false) {
            output += "Вытяжка включена на скорости " + GetCurrentSpeed() + ", подсветка выключена" + "\n";
        }
        else if (GetCurrentStateOnOff() && GetCurrentBacklight() == true) {
            output += "Вытяжка включена на скорости " + GetCurrentSpeed() + ", подсветка включена" + "\n";
        }
        else if (!GetCurrentStateOnOff() && GetCurrentBacklight() == true) {
            output += "Вытяжка не работает в активном режиме, подсветка включена" + "\n";
        }
        else output += "Вытяжка выключена\n";
        return output;
    }

    public Integer GetCurrentSpeed() {
        return  speed;
    }
    public Boolean GetCurrentBacklight() {
        return  backlight;
    }

    public void IncrementSpeed() {
        if (speed < 1) ON();
        if (speed < 3) speed++;
    }

    public void DecrementSpeed() {
        if (speed > 0) speed--;
        if (speed < 1) OFF();
    }

    public void BacklightON() {
        if (!backlight) backlight = true;
    }

    public void BacklightOFF() {
        if (backlight) backlight = false;
    }
}
