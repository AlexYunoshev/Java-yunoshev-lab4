package com.company.Device;

public interface IDevice {
    Boolean GetCurrentStateOnOff();
    String GetSerialNumber();
    String GetFullProductName();
    String GetFullProductDescription();
    void ON();
    void OFF();
    Boolean GetTimerState();
    String GetTimerValue();
    void StopTimer();
    void SetTimer(Integer hours, Integer minutes);
    void ConsoleSetTimer();

}
