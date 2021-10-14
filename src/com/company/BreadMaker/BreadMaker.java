package com.company.BreadMaker;

import com.company.Device.Device;

public class BreadMaker extends Device implements IBreadMaker {

    Boolean activeCook; // обрано режим приготування
    Boolean capOpenState; // true = open
    BreadCookingModes currentBreadCookingMode;
    DoughCookingModes currentDoughCookingMode;


    public BreadMaker(String serialNumber, String manufacturer, String model) {
        super(serialNumber, manufacturer, model);
        activeCook = false;
        capOpenState = false;
        currentBreadCookingMode = null;
        currentDoughCookingMode = null;
    }

    public String GetFullProductDescription(){
        String output = "";
        output += "Хлебопечь " + GetFullProductName() + " с серийным номером " + GetSerialNumber() + "\n";
        if (GetCapOpenState() == true) output += "Крышка открыта\n";
        else output += "Крышка закрыта\n";

        if(GetCurrentStateOnOff() == true) {
            output += "Хлебопечь включена и ";
            if (GetActiveCookingState() == true) {
                if (currentDoughCookingMode == null && currentBreadCookingMode != null) {
                    output += "работает в режиме приготовления хлеба: " + GetCurrentBreadCookingMode() + "\n";
                } else if (currentDoughCookingMode != null && currentBreadCookingMode == null) {
                    output += "работает в режиме приготовления теста: " + GetCurrentDoughCookingMode() + "\n";
                }
                if (GetTimerState() == true) output += "Таймер установлен на " + GetTimerValue() + ".\n";
                else output += "Таймер не установлен.\n";
            }
            else output += "находится не в режиме приготовления\n";
        }
        else {
            output += "Хлебопечь выключена.";
        }
        return output;
    }

    public Boolean GetActiveCookingState() {
        return activeCook;
    }

    public BreadCookingModes GetCurrentBreadCookingMode() {
        return currentBreadCookingMode;
    }

    public void SetCurrentBreadCookingMode(BreadCookingModes mode) {
        currentDoughCookingMode = null;
        currentBreadCookingMode = mode;
    }

    public DoughCookingModes GetCurrentDoughCookingMode() {
        return currentDoughCookingMode;
    }

    public void SetCurrentDoughCookingMode(DoughCookingModes mode) {
        currentBreadCookingMode = null;
        currentDoughCookingMode = mode;
    }

    public Boolean StartCurrentMode() {
        if (GetCurrentStateOnOff() && capOpenState == false && (currentDoughCookingMode != null || currentBreadCookingMode != null)){
            activeCook = true;
            return true;
        }
        return false;
    }

    public void StopCurrentMode() {
        activeCook = false;
        currentBreadCookingMode = null;
        currentDoughCookingMode = null;
        StopTimer();
    }

    public void OFF() {
        super.OFF();
        StartCurrentMode();
    }

    public Boolean GetCapOpenState() {
        return capOpenState;
    }

    public void OpenCap() {
        capOpenState = true;
    }

    public void CloseCap() {
        capOpenState = false;
    }
}
