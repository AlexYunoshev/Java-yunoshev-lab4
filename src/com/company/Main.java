package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start program");
        long m = System.currentTimeMillis();
        //for (int i = 0; i < 10000; i++)
            DeviceManager.CreateDevices();

        for (int i = 0; i < 100; i++)
        {
            DeviceManager.PrintDeviceList(DeviceManager.ACList);
            DeviceManager.PrintDeviceList(DeviceManager.breadMakersList);
            DeviceManager.PrintDeviceList(DeviceManager.hoodList);
            DeviceManager.PrintDeviceList(DeviceManager.radioList);
            DeviceManager.PrintDeviceList(DeviceManager.TVList);
        }
        long f = System.currentTimeMillis() - m;
        System.out.println(f);
    }


    ///////////////////////////////////////// program with user menu /////////////////////////////////////
//    static Scanner scanner = new Scanner(System.in);
//    public static void main(String[] args) {
//        DeviceManager.CreateDevices(); // создание приборов
//        while (true) {
//            DeviceManager.device = null;
//            PrintMainMenu();
//            switch (scanner.nextInt()) {
//                case 1:
//                    DeviceManager.CreateDevice();
//                    break;
//                case 2:
//                    DeviceManager.device = DeviceManager.ChooseDevice();
//                    if (DeviceManager.device != null) {
//                        DeviceManager.RemoveDevice(DeviceManager.device);
//                    }
//                    else System.out.println("Невозможно выполнить операцию! " +
//                            "Вероятно, приборов такой категории не существует...");
//                    break;
//                case 3:
//                    DeviceManager.device = DeviceManager.ChooseDevice();
//                    if (DeviceManager.device != null) {
//                        DeviceManager.DeviceProcess(DeviceManager.device);
//                    }
//                    else System.out.println("Невозможно выполнить операцию! " +
//                            "Вероятно, приборов такой категории не существует...");
//                    break;
//                case 4:
//                    DeviceManager.ShowDevicesByCategory();
//                    break;
//                case 5:
//                    System.out.println("Кондиционеры:"); DeviceManager.PrintDeviceList(DeviceManager.ACList);
//                    System.out.println("\nХлебопечи:"); DeviceManager.PrintDeviceList(DeviceManager.breadMakersList);
//                    System.out.println("\nВытяжки:"); DeviceManager.PrintDeviceList(DeviceManager.hoodList);
//                    System.out.println("\nРадио:"); DeviceManager.PrintDeviceList(DeviceManager.radioList);
//                    System.out.println("\nТелевизоры:"); DeviceManager.PrintDeviceList(DeviceManager.TVList);
//            }
//        }
//    }
//
//    public static void PrintMainMenu() {
//        System.out.println("\nВыберите действие: ");
//        System.out.println("1 - создать прибор");
//        System.out.println("2 - удалить прибор");
//        System.out.println("3 - использовать прибор");
//        System.out.println("4 - список приборов конкретного типа");
//        System.out.println("5 - посмотреть все приборы");
//    }


}
