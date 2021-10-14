package com.company.AC;


public interface IAirConditioner {
    ACModes GetCurrentACMode();
    void SetCurrentACMode(ACModes mode);
    Integer GetTemperature();
    void IncrementTemperature();
    void DecrementTemperature();
}
