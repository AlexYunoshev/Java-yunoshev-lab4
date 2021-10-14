package com.company.KitchenHood;

public interface IHood {
    Integer GetCurrentSpeed();
    Boolean GetCurrentBacklight();
    void IncrementSpeed();
    void DecrementSpeed();
    void BacklightON();
    void BacklightOFF();
}
