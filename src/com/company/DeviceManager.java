package com.company;

import com.company.AC.ACModes;
import com.company.AC.AirConditioner;
import com.company.BreadMaker.BreadCookingModes;
import com.company.BreadMaker.BreadMaker;
import com.company.BreadMaker.DoughCookingModes;
import com.company.Device.Device;
import com.company.KitchenHood.Hood;
import com.company.Radio.Radio;
import com.company.TV.TV;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeviceManager {
    static Scanner scanner = new Scanner(System.in);
    static String inputString;
    static String manufacturer, model, serial;
    static List<AirConditioner> ACList = new ArrayList<>();
    static List<BreadMaker> breadMakersList = new ArrayList<>();
    static List<Hood> hoodList = new ArrayList<>();
    static List<Radio> radioList = new ArrayList<>();
    static List<TV> TVList = new ArrayList<>();
    static Device device;


    public static void PrintDeviceTypeChoosing() {
        System.out.println("Выберите тип прибора: ");
        System.out.println("1 - кондиционер");
        System.out.println("2 - хлебопечь");
        System.out.println("3 - вытяжка");
        System.out.println("4 - радио");
        System.out.println("5 - телевизор");
    }

    public static <T extends Device> void PrintDeviceList(List<T> list) {
        if(list.size() > 0) {
            Integer position = 1;
            for (T listItem:list) {
                System.out.println(position + ". "
                        + listItem.GetFullProductDescription());
                position++;
            }
        }
        else System.out.println("Не существует созданных приборов этого типа!");
    }

    private static void AirConditionerProcess(AirConditioner device) {
        while (true) {
            //System.out.println(System.lineSeparator().repeat(50));
            System.out.println(device.GetFullProductDescription());
            System.out.println("Выберите действие: ");
            System.out.println("1 - Включить/выключить");
            System.out.println("2 - Выбрать режим");
            System.out.println("3 - Изменить температуру");
            System.out.println("4 - Установить таймер");
            System.out.println("0 - Выход");

            switch (scanner.nextInt()) {
                case 0:return;
                case 1:
                    if (device.GetCurrentStateOnOff())
                        device.OFF();
                    else
                        device.ON();
                    break;
                case 2:
                    if(device.GetCurrentStateOnOff()) {
                        System.out.println("Выберите режим: ");
                        System.out.println("1 - " + ACModes.Cooling);
                        System.out.println("2 - " + ACModes.Heating);
                        System.out.println("3 - " + ACModes.Ventilation);
                        System.out.println("4 - " + ACModes.Dehumidification);
                        System.out.println("5 - " + ACModes.AirPurification);
                        System.out.println("0 - Назад");
                        switch (scanner.nextInt()) {
                            case 0:
                                break;
                            case 1:
                                device.SetCurrentACMode(ACModes.Cooling);
                                System.out.println("Выбран режим " + ACModes.Cooling);
                                break;
                            case 2:
                                device.SetCurrentACMode(ACModes.Heating);
                                System.out.println("Выбран режим " + ACModes.Heating);
                                break;
                            case 3:
                                device.SetCurrentACMode(ACModes.Ventilation);
                                System.out.println("Выбран режим " + ACModes.Ventilation);
                                break;
                            case 4:
                                device.SetCurrentACMode(ACModes.Dehumidification);
                                System.out.println("Выбран режим " + ACModes.Dehumidification);
                                break;
                            case 5:
                                device.SetCurrentACMode(ACModes.AirPurification);
                                System.out.println("Выбран режим " + ACModes.AirPurification);
                                break;
                            default:
                                System.out.println("Такого режима не существует");
                                break;
                        }
                    }
                    else System.out.println("Кондиционер выключен, нельзя выбрать режим.");
                    break;
                case 3:
                    if(device.GetCurrentStateOnOff()) {
                        Boolean run = true;
                        while (run) {
                            System.out.println("Температура: " + device.GetTemperature());
                            System.out.println("1 - Увеличить");
                            System.out.println("2 - Уменьшить");
                            System.out.println("0 - Назад");
                            switch (scanner.nextInt()) {
                                case 0:
                                    run = false;
                                    break;
                                case 1:
                                    device.IncrementTemperature();
                                    break;
                                case 2:
                                    device.DecrementTemperature();
                                    break;
                                default:
                                    System.out.println("Повторите попытку!");
                                    break;
                            }
                        }
                    }
                    else System.out.println("Кондиционер выключен, нельзя изменить температуру.");
                    break;

                case 4:
                    if(device.GetCurrentStateOnOff()) {
                        System.out.println("1 - Установить таймер, если он не установлен");
                        System.out.println("2 - Выключить таймер");
                        System.out.println("0 - Назад");
                        switch (scanner.nextInt()) {
                            case 0:
                                break;
                            case 1:
                                device.ConsoleSetTimer();
                                break;
                            case 2:
                                device.StopTimer();
                                break;
                            default:
                                System.out.println("Повторите попытку!");
                                break;
                        }
                    }
                    else System.out.println("Кондиционер выключен, нельзя установить таймер.");
                    break;
                default:
                    System.out.println("Повторите попытку!");
                    break;
            }
        }

    }

    private static void BreadMakerProcess(BreadMaker device) {
        while (true) {
            //System.out.println(System.lineSeparator().repeat(50));
            System.out.println(device.GetFullProductDescription());
            System.out.println("Выберите действие: ");
            System.out.println("1 - Включить/выключить");
            System.out.println("2 - Открыть/закрыть крышку");
            System.out.println("3 - Выбрать режим приготовления хлеба");
            System.out.println("4 - Выбрать режим приготовления теста");
            System.out.println("5 - Начать/остановить приготовление текущего режима");
            System.out.println("6 - Установить таймер");
            System.out.println("0 - Выход");

            switch (scanner.nextInt()) {
                case 0:return;
                case 1:
                    if (device.GetCurrentStateOnOff())
                        device.OFF();
                    else
                        device.ON();
                    break;
                case 2:
                    if(device.GetCapOpenState())
                        device.CloseCap();
                    else
                        device.OpenCap();
                    break;
                case 3:
                    System.out.println("Выберите режим: ");
                    System.out.println("1 - " + BreadCookingModes.GlutenFreeBread);
                    System.out.println("2 - " + BreadCookingModes.DietaryBread);
                    System.out.println("3 - " + BreadCookingModes.WheatBread);
                    System.out.println("4 - " + BreadCookingModes.SweetPastries);
                    System.out.println("5 - " + BreadCookingModes.FrenchBread);
                    System.out.println("6 - " + BreadCookingModes.WholeGrainBread);
                    System.out.println("7 - " + BreadCookingModes.FastBaking);
                    System.out.println("0 - Назад");
                    switch (scanner.nextInt()) {
                        case 0:
                            break;
                        case 1:
                            device.SetCurrentBreadCookingMode(BreadCookingModes.GlutenFreeBread);
                            System.out.println("Выбран режим приготовления хлеба " + BreadCookingModes.GlutenFreeBread);
                            break;
                        case 2:
                            device.SetCurrentBreadCookingMode(BreadCookingModes.DietaryBread);
                            System.out.println("Выбран режим приготовления хлеба " + BreadCookingModes.DietaryBread);
                            break;
                        case 3:
                            device.SetCurrentBreadCookingMode(BreadCookingModes.WheatBread);
                            System.out.println("Выбран режим приготовления хлеба " + BreadCookingModes.WheatBread);
                            break;
                        case 4:
                            device.SetCurrentBreadCookingMode(BreadCookingModes.SweetPastries);
                            System.out.println("Выбран режим приготовления хлеба " + BreadCookingModes.SweetPastries);
                            break;
                        case 5:
                            device.SetCurrentBreadCookingMode(BreadCookingModes.FrenchBread);
                            System.out.println("Выбран режим приготовления хлеба " + BreadCookingModes.FrenchBread);
                            break;
                        case 6:
                            device.SetCurrentBreadCookingMode(BreadCookingModes.WholeGrainBread);
                            System.out.println("Выбран режим приготовления хлеба " + BreadCookingModes.WholeGrainBread);
                            break;
                        case 7:
                            device.SetCurrentBreadCookingMode(BreadCookingModes.FastBaking);
                            System.out.println("Выбран режим приготовления хлеба " + BreadCookingModes.FastBaking);
                            break;
                        default:
                            System.out.println("Такого режима не существует");
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Выберите режим: ");
                    System.out.println("1 - " + DoughCookingModes.Unleavened);
                    System.out.println("2 - " + DoughCookingModes.Yeast);
                    System.out.println("3 - " + DoughCookingModes.Pizza);
                    System.out.println("0 - Назад");
                    switch (scanner.nextInt()) {
                        case 0:
                            break;
                        case 1:
                            device.SetCurrentDoughCookingMode(DoughCookingModes.Unleavened);
                            System.out.println("Выбран режим приготовления теста " + DoughCookingModes.Unleavened);
                            break;
                        case 2:
                            device.SetCurrentDoughCookingMode(DoughCookingModes.Yeast);
                            System.out.println("Выбран режим приготовления теста " + DoughCookingModes.Yeast);
                            break;
                        case 3:
                            device.SetCurrentDoughCookingMode(DoughCookingModes.Pizza);
                            System.out.println("Выбран режим приготовления теста " + DoughCookingModes.Pizza);
                            break;
                        default:
                            System.out.println("Такого режима не существует");
                            break;
                    }
                    break;
                case 5:

                    if(device.GetActiveCookingState() == false) {
                        Boolean isStart = device.StartCurrentMode();
                        if (isStart == false) {
                            System.out.println("Невозможно начать приготовление! " +
                                    "Возможно, Вы не включили прибор, не выбрали режим " +
                                    "или не закрыли крышку.");
                        }
                    }
                    else device.StopCurrentMode();

                    break;

                case 6:
                    System.out.println("1 - Установить таймер, если он не установлен");
                    System.out.println("2 - Выключить таймер");
                    System.out.println("0 - Назад");
                    switch (scanner.nextInt()) {
                        case 0:
                            break;
                        case 1:
                            device.ConsoleSetTimer();
                            break;
                        case 2:
                            device.StopTimer();
                            break;
                        default:
                            System.out.println("Повторите попытку!");
                            break;
                    }
                    break;
                default:
                    System.out.println("Повторите попытку!");
                    break;
            }
        }

    }

    private static void HoodProcess(Hood device) {
        while (true) {
            //System.out.println(System.lineSeparator().repeat(50));
            System.out.println(device.GetFullProductDescription());
            System.out.println("Выберите действие: ");
            System.out.println("1 - Включить/выключить подсветку");
            System.out.println("2 - Добавить скорость");
            System.out.println("3 - Убавить скорость");
            System.out.println("4 - Установить таймер");
            System.out.println("0 - Выход");

            switch (scanner.nextInt()) {
                case 0:return;
                case 1:
                    if(device.GetCurrentBacklight())
                        device.BacklightOFF();
                    else
                        device.BacklightON();
                    break;
                case 2:
                    if(device.GetCurrentSpeed() >= 3) {
                        System.out.println("Скорость установлена максимальная, невозможно увеличить.");
                    }
                    else device.IncrementSpeed();
                    break;
                case 3:
                    if(device.GetCurrentSpeed() <= 0) {
                        System.out.println("Вытяжка выключена, невозможно уменьшить скорость");
                    }
                    else device.DecrementSpeed();
                    break;
                case 4:
                    if (device.GetCurrentStateOnOff() || device.GetCurrentBacklight()) {
                        System.out.println("1 - Установить таймер, если он не установлен");
                        System.out.println("2 - Выключить таймер");
                        System.out.println("0 - Назад");
                        switch (scanner.nextInt()) {
                            case 0:
                                break;
                            case 1:
                                device.ConsoleSetTimer();
                                break;
                            case 2:
                                device.StopTimer();
                                break;
                            default:
                                System.out.println("Повторите попытку!");
                                break;
                        }
                    }
                    else System.out.println("Невозможно установить таймер, вытяжка выключена");
                    break;
                default:
                    System.out.println("Повторите попытку!");
                    break;
            }
        }

    }

    private static void RadioProcess(Radio device) {
        while (true) {
            //System.out.println(System.lineSeparator().repeat(50));
            System.out.println(device.GetFullProductDescription());
            System.out.println("Выберите действие: ");
            System.out.println("1 - Включить/выключить");
            System.out.println("2 - Переключить канал вперёд");
            System.out.println("3 - Переключить канал назад");
            System.out.println("4 - Добавить громкость");
            System.out.println("5 - Убавить громкость");
            System.out.println("6 - Установить таймер");
            System.out.println("0 - Выход");

            switch (scanner.nextInt()) {
                case 0:return;
                case 1:
                    if(device.GetCurrentStateOnOff())
                        device.OFF();
                    else
                        device.ON();
                    break;
                case 2:
                    device.IncrementStation();
                    break;
                case 3:
                    device.DecrementStation();
                    break;
                case 4:
                    if (device.GetCurrentVolume() < 100)    device.IncrementVolume();
                    else System.out.println("Громкость максимальная");
                    break;
                case 5:
                    if (device.GetCurrentVolume() > 0)    device.DecrementVolume();
                    else System.out.println("Громкость минимальная");
                    break;
                case 6:
                    if (device.GetCurrentStateOnOff()) {
                        System.out.println("1 - Установить таймер, если он не установлен");
                        System.out.println("2 - Выключить таймер");
                        System.out.println("0 - Назад");
                        switch (scanner.nextInt()) {
                            case 0:
                                break;
                            case 1:
                                device.ConsoleSetTimer();
                                break;
                            case 2:
                                device.StopTimer();
                                break;
                            default:
                                System.out.println("Повторите попытку!");
                                break;
                        }
                    }
                    else System.out.println("Невозможно установить таймер, радио выключено");
                    break;
                default:
                    System.out.println("Повторите попытку!");
                    break;
            }
        }

    }

    private static void TVProcess(TV device) {
        while (true) {
            //System.out.println(System.lineSeparator().repeat(50));
            System.out.println(device.GetFullProductDescription());
            System.out.println("Выберите действие: ");
            System.out.println("1 - Включить/выключить");
            System.out.println("2 - Переключить канал вперёд");
            System.out.println("3 - Переключить канал назад");
            System.out.println("4 - Добавить громкость");
            System.out.println("5 - Убавить громкость");
            System.out.println("6 - Выключить звук");
            System.out.println("7 - Установить таймер");
            System.out.println("0 - Выход");

            switch (scanner.nextInt()) {
                case 0:return;
                case 1:
                    if(device.GetCurrentStateOnOff())
                        device.OFF();
                    else
                        device.ON();
                    break;
                case 2:
                    device.IncrementChannel();
                    break;
                case 3:
                    device.DecrementChannel();
                    break;
                case 4:
                    if (device.GetCurrentVolume() < 100)    device.IncrementVolume();
                    else System.out.println("Громкость максимальная");
                    break;
                case 5:
                    if (device.GetCurrentVolume() > 0)    device.DecrementVolume();
                    else System.out.println("Громкость минимальная");
                    break;
                case 6:
                    device.MuteVolume();
                    break;
                case 7:
                    if (device.GetCurrentStateOnOff()) {
                        System.out.println("1 - Установить таймер, если он не установлен");
                        System.out.println("2 - Выключить таймер");
                        System.out.println("0 - Назад");
                        switch (scanner.nextInt()) {
                            case 0:
                                break;
                            case 1:
                                device.ConsoleSetTimer();
                                break;
                            case 2:
                                device.StopTimer();
                                break;
                            default:
                                System.out.println("Повторите попытку!");
                                break;
                        }
                    }
                    else System.out.println("Невозможно установить таймер, телевизор выключен");
                    break;
                default:
                    System.out.println("Повторите попытку!");
                    break;
            }
        }

    }

    public static void DeviceProcess(Device device) {
        AirConditioner airConditioner;
        BreadMaker breadMaker;
        Hood hood;
        Radio radio;
        TV tv;
        switch (device.getClass().getSimpleName()){
            case "AirConditioner":
                airConditioner = (AirConditioner) device;
                AirConditionerProcess(airConditioner);
                break;
            case "BreadMaker":
                breadMaker = (BreadMaker) device;
                BreadMakerProcess(breadMaker);
                break;
            case "Hood":
                hood = (Hood) device;
                HoodProcess(hood);
                break;
            case "Radio":
                radio = (Radio) device;
                RadioProcess(radio);
                break;
            case "TV":
                tv = (TV) device;
                TVProcess(tv);
                break;
            default:
                System.out.println("Error in DeviceProcess method");
                return;
        }


    }

    public static void RemoveDevice(Device device) {
        try {
            switch (device.getClass().getSimpleName()){
                case "AirConditioner":
                    ACList.remove(device);
                    System.out.println("Успешно!");
                    break;
                case "BreadMaker":
                    breadMakersList.remove(device);
                    System.out.println("Успешно!");
                    break;
                case "Hood":
                    hoodList.remove(device);
                    System.out.println("Успешно!");
                    break;
                case "Radio":
                    radioList.remove(device);
                    System.out.println("Успешно!");
                    break;
                case "TV":
                    TVList.remove(device);
                    System.out.println("Успешно!");
                    break;
                default:
                    System.out.println("Такой категории не существует");
                    break;
            }
        }
        catch (Exception e) {
            System.out.println("Что-то пошло не так...");
        }
    }


    //public static <T extends Device> T ChooseDevice() {
    public static Device ChooseDevice() {
        Integer devicePosition;
        //System.out.println(System.lineSeparator().repeat(50));
        PrintDeviceTypeChoosing();
        switch (scanner.nextInt()) {
            case 1:
                //System.out.println(System.lineSeparator().repeat(50));
                if(ACList.size() > 0) {
                    PrintDeviceList(ACList);
                    System.out.println("Выберите прибор по номеру: ");
                    devicePosition = scanner.nextInt() - 1;
                    return ACList.get(devicePosition);
                }
                return null;

            case 2:
                //System.out.println(System.lineSeparator().repeat(50));
                if(breadMakersList.size() > 0) {
                    PrintDeviceList(breadMakersList);
                    System.out.println("Выберите прибор по номеру: ");
                    devicePosition = scanner.nextInt() - 1;
                    return breadMakersList.get(devicePosition);
                }
                return null;

            case 3:
                //System.out.println(System.lineSeparator().repeat(50));
                if(hoodList.size() > 0) {
                    PrintDeviceList(hoodList);
                    System.out.println("Выберите прибор по номеру: ");
                    devicePosition = scanner.nextInt() - 1;
                    return hoodList.get(devicePosition);
                }
                return null;

            case 4:
                //System.out.println(System.lineSeparator().repeat(50));
                if(radioList.size() > 0) {
                    PrintDeviceList(radioList);
                    System.out.println("Выберите прибор по номеру: ");
                    devicePosition = scanner.nextInt() - 1;
                    return radioList.get(devicePosition);
                }
                return null;

            case 5:
                //System.out.println(System.lineSeparator().repeat(50));
                if(TVList.size() > 0) {
                    PrintDeviceList(TVList);
                    System.out.println("Выберите прибор по номеру: ");
                    devicePosition = scanner.nextInt() - 1;
                    return TVList.get(devicePosition);
                }
                return null;

            default:
                return null;
        }
    }

    public static void CreateDevices() {
        ACList.add(new AirConditioner("AC serial 1", "Cooper Hunter", "Prima Plus"));
        ACList.add(new AirConditioner("AC serial 2", "Cooper Hunter", "Winner"));
        //ACList.add(new AirConditioner("AC serial 3", "NeoClima", "Therminator"));
        //ACList.add(new AirConditioner("AC serial 4", "Mitsubishi", "Classic MS-GF60"));
        //ACList.add(new AirConditioner("AC serial 5", "Midea", "Ultimate Comfort"));

        breadMakersList.add(new BreadMaker("BreadMaker serial 1", "Gorenje", "BM1400E"));
        breadMakersList.add(new BreadMaker("BreadMaker serial 2", "Gorenje", "BM1600WG"));
        //breadMakersList.add(new BreadMaker("BreadMaker serial 3", "Panasonic", "SD-2510"));

        //hoodList.add(new Hood("Hood serial 1", "Vitek", "VM-03"));

        radioList.add(new Radio("Radio serial 1", "Philips", "Virtual50"));

        TVList.add(new TV("TV serial 1", "Samsung", "Pq30TV55HD"));
    }

    public static AirConditioner CreateAC() {
        scanner.nextLine();
        System.out.println("Введите производителя кондиционера: ");
        manufacturer = scanner.nextLine();
        System.out.println("Введите модель кондиционера: ");
        model = scanner.nextLine();
        System.out.println("Введите серийный номер кондиционера: ");
        serial = scanner.nextLine();
        return new AirConditioner(serial, manufacturer, model);
    }

    public static BreadMaker CreateBreadMaker() {
        scanner.nextLine();
        System.out.println("Введите производителя хлебопечки: ");
        manufacturer = scanner.nextLine();
        System.out.println("Введите модель хлебопечки: ");
        model = scanner.nextLine();
        System.out.println("Введите серийный номер хлебопечки: ");
        serial = scanner.nextLine();
        return new BreadMaker(serial, manufacturer, model);
    }

    public static Hood CreateKitchenHood() {
        scanner.nextLine();
        System.out.println("Введите производителя вытяжки: ");
        manufacturer = scanner.nextLine();
        System.out.println("Введите модель вытяжки: ");
        model = scanner.nextLine();
        System.out.println("Введите серийный номер вытяжки: ");
        serial = scanner.nextLine();
        return new Hood(serial, manufacturer, model);
    }

    public static Radio CreateRadio() {
        scanner.nextLine();
        System.out.println("Введите производителя радио: ");
        manufacturer = scanner.nextLine();
        System.out.println("Введите модель радио: ");
        model = scanner.nextLine();
        System.out.println("Введите серийный номер радио: ");
        serial = scanner.nextLine();
        return new Radio(serial, manufacturer, model);
    }

    public static TV CreateTV() {
        scanner.nextLine();
        System.out.println("Введите производителя телевизора: ");
        manufacturer = scanner.nextLine();
        System.out.println("Введите модель телевизора: ");
        model = scanner.nextLine();
        System.out.println("Введите серийный номер телевизора: ");
        serial = scanner.nextLine();
        return new TV(serial, manufacturer, model);
    }

    public static void CreateDevice() {
        System.out.println("Выберите тип прибора: ");
        System.out.println("1 - кондиционер");
        System.out.println("2 - хлебопечь");
        System.out.println("3 - вытяжка");
        System.out.println("4 - радио");
        System.out.println("5 - телевизор");
        try {
            switch (scanner.nextInt()) {
                case 1:
                    ACList.add(CreateAC());
                    break;
                case 2:
                    breadMakersList.add(CreateBreadMaker());
                    break;
                case 3:
                    hoodList.add(CreateKitchenHood());
                    break;
                case 4:
                    radioList.add(CreateRadio());
                    break;
                case 5:
                    TVList.add(CreateTV());
                    break;
            }
            System.out.println("Успешно!");
        }
        catch (Exception e) {
            System.out.println("Что-то пошло не так...");
        }

    }

    public static void ShowDevicesByCategory() {
        System.out.println("Выберите тип прибора: ");
        System.out.println("1 - кондиционер");
        System.out.println("2 - хлебопечь");
        System.out.println("3 - вытяжка");
        System.out.println("4 - радио");
        System.out.println("5 - телевизор");
        switch (scanner.nextInt()) {
            case 1:
                PrintDeviceList(ACList);
                break;
            case 2:
                PrintDeviceList(breadMakersList);
                break;
            case 3:
                PrintDeviceList(hoodList);
                break;
            case 4:
                PrintDeviceList(radioList);
                break;
            case 5:
                PrintDeviceList(TVList);
                break;
        }
    }

}

