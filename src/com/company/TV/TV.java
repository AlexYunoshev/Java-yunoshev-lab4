package com.company.TV;

import com.company.Device.Device;
import com.company.Device.IDevice;

public class TV extends Device implements ITV {

    ChannelList currentChannel;
    Integer currentVolume, volume;
    Boolean isMute;

    public TV(String serialNumber, String manufacturer, String model) {
        super(serialNumber, manufacturer, model);
        currentChannel = ChannelList.Espresso;
        currentVolume = 20;
        isMute = false;
    }

    public String GetFullProductDescription(){
        String output = "";
        output += "Телевизор " + GetFullProductName() + " с серийным номером " + GetSerialNumber() + "\n";
        if (GetCurrentStateOnOff() == true) {
            output += "Телевизор включен, выбран канал " + GetCurrentChannel() + " с громкостью " + GetCurrentVolume() + "\n";
        }
        else output += "Телевизор выключен\n";
        return output;
    }

    public ChannelList GetCurrentChannel() {
        return currentChannel;
    }

    public void IncrementChannel() {
        currentChannel = (currentChannel.ordinal() == ChannelList.values().length - 1) ?
                ChannelList.values()[0] :
                ChannelList.values()[currentChannel.ordinal() + 1];
    }

    public void DecrementChannel() {
        currentChannel = (currentChannel.ordinal() == 0) ?
                ChannelList.values()[ChannelList.values().length - 1] :
                ChannelList.values()[currentChannel.ordinal() - 1];
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

    public void MuteVolume() {
        if (!isMute) {
            isMute = true;
            volume = currentVolume;
            currentVolume = 0;
        }
        else {
            isMute = false;
            currentVolume = volume;
        }

    }

}
