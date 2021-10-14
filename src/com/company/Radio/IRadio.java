package com.company.Radio;

import com.company.TV.ChannelList;

public interface IRadio {
    StationList GetCurrentStation();
    void IncrementStation();
    void DecrementStation();
    Integer GetCurrentVolume();
    void IncrementVolume();
    void DecrementVolume();
}
