package com.company.TV;

public interface ITV {
    ChannelList GetCurrentChannel();
    void IncrementChannel();
    void DecrementChannel();
    Integer GetCurrentVolume();
    void IncrementVolume();
    void DecrementVolume();
    void MuteVolume();
}
