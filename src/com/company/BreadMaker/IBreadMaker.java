package com.company.BreadMaker;

public interface IBreadMaker {
    Boolean GetActiveCookingState();
    BreadCookingModes GetCurrentBreadCookingMode();
    void SetCurrentBreadCookingMode(BreadCookingModes mode);
    DoughCookingModes GetCurrentDoughCookingMode();
    void SetCurrentDoughCookingMode(DoughCookingModes mode);
    Boolean GetCapOpenState();
    void OpenCap();
    void CloseCap();
    Boolean StartCurrentMode();
    void StopCurrentMode();
}
