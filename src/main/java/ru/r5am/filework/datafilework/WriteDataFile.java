package ru.r5am.filework.datafilework;

/*
 * Created by Zoer on 09.08.15.
 */

import jfork.nproperty.Cfg;
import jfork.nproperty.ConfigParser;
import ru.r5am.Main;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@Cfg
public class WriteDataFile
{
    public static String cw1 = ".----";
    public static String cw2 = "..---";
    public static String cw3 = "...--";
    public static String cw4 = "....-";
    public static String cw5 = ".....";
    public static String cw6 = "-....";
    public static String cw7 = "--...";
    public static String cw8 = "---..";
    public static String cw9 = "----.";
    public static String cw0 = "-----";

    public static String cwA = ".-";
    public static String cwB = ".---";
    public static String cwC = "-.-.";
    public static String cwD = "-..";
    public static String cwE = ".";
    public static String cwF = "..-.";
    public static String cwG = "--.";
    public static String cwH = "....";
    public static String cwI = "..";
    public static String cwJ = ".---";
    public static String cwK = "-.-";
    public static String cwL = ".-..";
    public static String cwM = "--";
    public static String cwN = "-.";
    public static String cwO = "---";
    public static String cwP = ".--.";
    public static String cwQ = "--.-";
    public static String cwR = ".-.";
    public static String cwS = "...";
    public static String cwT = "-";
    public static String cwU = "..-";
    public static String cwV = "...-";
    public static String cwW = ".--";
    public static String cwX = "-..-";
    public static String cwY = "-.--";
    public static String cwZ = "--..";

    public static String cwEQUAL = "-...-";
    public static String cwQUEST = "..--..";
    public static String cwSLASH = "-..-.";
    public static String cwSPACE = "_";

    public WriteDataFile() throws NoSuchMethodException, InstantiationException, IllegalAccessException, IOException, InvocationTargetException
    {
        ConfigParser.store(this,
                Main.pathUserHome + System.getProperty("file.separator") + Main.nameCWSignalFile);
    }

}
