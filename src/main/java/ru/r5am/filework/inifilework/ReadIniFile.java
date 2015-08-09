package ru.r5am.filework.inifilework;

import jfork.nproperty.Cfg;
import jfork.nproperty.ConfigParser;
import ru.r5am.Main;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/*
 * Created by Zoer on 06.05.2015.
 */

@Cfg
public class ReadIniFile
{
    // Параметры в файле конфигурации с значениями по умолчанию

    // Скорость CW
    public static int speedCW = 100;

    // Калибр скорости  CW
    public static int caliberSpeedCW = 5800;

    // Название СОМ порта
    public static String nameCOMport = "COM6";
    // настройки СОМ-порта
    public static int baudRate = 9600;      // Скорость в порту
    public static int dataBits = 8;         // Бит в пакете
    public static int stopBits = 1;         // Количество стоп-битов
    public static boolean parity = false;   // Есть ли проверка чётности

    // Чем манипулировать - DTR или RTS?
    public static String cwManipulationSignal = "DTR";


    // Использовать ли PTT?
    public static boolean usePTT = false;

    // Задержки в миллисекундах
    public static int pttToCwDelay = 0;     //   после PTT до CW
    public static int cwToPttDelay = 0;     //   отпускание PTT после CW

    public ReadIniFile() throws NoSuchMethodException, InstantiationException, IllegalAccessException, IOException, InvocationTargetException
    {
        ConfigParser.parse(this,
                Main.pathUserHome + System.getProperty("file.separator") + Main.nameIniFile);
    }
}
