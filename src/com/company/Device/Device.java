package com.company.Device;

import java.util.Scanner;

public abstract class Device implements IDevice{
    Scanner scanner = new Scanner(System.in);
    private Boolean currentStateOnOff;
    private final String serialNumber;
    private final String manufacturer;
    private final String model;
    private Integer timerHours;
    private Integer timerMinutes;
    private Boolean isTimer;

    public Device(String serialNumber, String manufacturer, String model) {
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
        this.model = model;
        currentStateOnOff = false;
        isTimer = false;
    }

    public void ON() {
        currentStateOnOff = true;
    }
    public void OFF() {
        currentStateOnOff = false;
    }

    public Boolean GetCurrentStateOnOff() {
        return currentStateOnOff;
    };

    public String GetSerialNumber() {
        return serialNumber;
    };

    public String GetFullProductName() {
       return manufacturer + " " + model;
    };

    public String GetFullProductDescription(){
        return "Девайс " + GetFullProductName() + " с серийным номером " + GetSerialNumber();
    }

    public Boolean GetTimerState() {
        return isTimer;
    }
    public String GetTimerValue(){
        return timerHours + " : " + timerMinutes + " (часы : минуты)";
    }

    public void StopTimer(){
        isTimer = false;
    }

    public void SetTimer(Integer hours, Integer minutes) {
        this.timerHours = hours;
        this.timerMinutes = minutes;
        isTimer = true;
    }

    public void ConsoleSetTimer(){
        Integer hours;
        Integer minutes;
        System.out.println("Введите часы и минуты.");
        System.out.println("Часы: ");
        hours = scanner.nextInt();
        System.out.println("Минуты: ");
        minutes = scanner.nextInt();
        this.SetTimer(hours, minutes);
    }
}
