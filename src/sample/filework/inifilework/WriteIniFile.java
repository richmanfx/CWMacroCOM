package sample.filework.inifilework;

import jfork.nproperty.Cfg;
import jfork.nproperty.ConfigParser;
import sample.Main;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Asus on 06.05.2015.
 */


public class WriteIniFile
{
    // Параметры в файле конфигурации

    // Скорость CW
    @Cfg
    public static int speedCW;

    // Калибр скорости  CW
    @Cfg
    public static int caliberSpeedCW;

    // Название СОМ порта
    @Cfg
    public static String nameCOMport;
    // настройки СОМ-порта
    @Cfg
    public static int baudRate;         // Скорость порта
    @Cfg
    public static int dataBits;         // Бит в пакете
    @Cfg
    public static int stopBits;         // Количество стоп-битов
    @Cfg
    public static boolean parity;       // Есть ли проверка чётности

    // Чем манипулировать - DTR или RTS?
    @Cfg
    public static String cwManipulationSignal;


    // Использовать ли PTT?
    @Cfg
    public static boolean usePTT;

    // Задержки в миллисекундах
    @Cfg
    public static int pttToCwDelay;     //   после PTT до CW
    @Cfg
    public static int cwToPttDelay;     //   отпускание PTT после CW

    public WriteIniFile() throws NoSuchMethodException, InstantiationException, IllegalAccessException, IOException, InvocationTargetException
    {
        ConfigParser.store(this,
                Main.pathUserHome + System.getProperty("file.separator") + Main.nameIniFile);
    }

}
