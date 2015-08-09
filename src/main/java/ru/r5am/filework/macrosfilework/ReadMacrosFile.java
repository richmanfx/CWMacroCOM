package ru.r5am.filework.macrosfilework;

import jfork.nproperty.Cfg;
import jfork.nproperty.ConfigParser;
import ru.r5am.Main;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/*
 * Created by Zoer on 12.05.2015.
 */

@Cfg
public class ReadMacrosFile {
    public static String F1 = "DefaultMacros F1";           // Макросы по умолчанию
    public static String F2 = "DefaultMacros F2";
    public static String F3 = "DefaultMacros F3";
    public static String F4 = "DefaultMacros F4";
    public static String F5 = "DefaultMacros F5";
    public static String F6 = "DefaultMacros F6";

    public ReadMacrosFile() throws NoSuchMethodException, InstantiationException, IllegalAccessException, IOException, InvocationTargetException
    {
        ConfigParser.parse(this,
                Main.pathUserHome + System.getProperty("file.separator") + Main.nameMacrosFile);
    }
}
