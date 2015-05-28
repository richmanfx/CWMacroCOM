package sample.filework.inifilework;

import jfork.nproperty.Cfg;
import jfork.nproperty.ConfigParser;
import sample.Main;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Asus on 06.05.2015.
 */


public class ReadIniFile
{
    // Параметры в файле конфигурации

    // Название СОМ порта
    @Cfg public static String nameCOMport = "COM6";
    // настройки СОМ-порта
    @Cfg public static int baudRate = 9600;      // Скорость в порту
    @Cfg public static int dataBits = 8;         // Бит в пакете
    @Cfg public static int stopBits = 1;         // Количество стоп-битов
    @Cfg public static boolean parity = false;   // Есть ли проверка чётности

    // Скорость CW
    @Cfg public static int speedCW = 100;

    // Чем манипулировать - DTR или RTS?
    @Cfg public static String cwManipulationSignal = "DTR";


    // Использовать ли PTT?
    @Cfg public static boolean usePTT = false;

    // Задержки в миллисекундах
    @Cfg public static int pttToCwDelay = 0;     //   после PTT до CW
    @Cfg public static int cwToPttDelay = 0;     //   отпускание PTT после CW

    public ReadIniFile() throws NoSuchMethodException, InstantiationException, IllegalAccessException, IOException, InvocationTargetException
    {
        ConfigParser.parse(this,
                Main.pathUserHome + System.getProperty("file.separator") + Main.nameIniFile);
    }

}
