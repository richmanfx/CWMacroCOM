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
public class WriteIniFile
{
    // Параметры в файле конфигурации

    // Скорость CW
    public static int speedCW;

    // Калибр скорости  CW
    public static int caliberSpeedCW;

    // Название СОМ порта
    public static String nameCOMport;
    // настройки СОМ-порта
    public static int baudRate;         // Скорость порта
    public static int dataBits;         // Бит в пакете
    public static int stopBits;         // Количество стоп-битов
    public static boolean parity;       // Есть ли проверка чётности

    // Чем манипулировать - DTR или RTS?
    public static String cwManipulationSignal;

    // Использовать ли PTT?
    public static boolean usePTT;

    // Задержки в миллисекундах
    public static int pttToCwDelay;     //   после PTT до CW
    public static int cwToPttDelay;     //   отпускание PTT после CW

    public WriteIniFile() throws NoSuchMethodException, InstantiationException, IllegalAccessException, IOException, InvocationTargetException
    {
        ConfigParser.store(this,
                Main.pathUserHome + System.getProperty("file.separator") + Main.nameIniFile);
    }
}
