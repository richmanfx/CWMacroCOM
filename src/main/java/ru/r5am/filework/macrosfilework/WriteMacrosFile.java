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
public class WriteMacrosFile {
    public static String F1;
    public static String F2;
    public static String F3;
    public static String F4;
    public static String F5;
    public static String F6;

    public WriteMacrosFile() throws NoSuchMethodException, InstantiationException, IllegalAccessException, IOException, InvocationTargetException
    {
        ConfigParser.store(this,
                Main.pathUserHome + System.getProperty("file.separator") + Main.nameMacrosFile);
    }
}
