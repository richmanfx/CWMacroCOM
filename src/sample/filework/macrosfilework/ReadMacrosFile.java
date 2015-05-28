package sample.filework.macrosfilework;

import jfork.nproperty.Cfg;
import jfork.nproperty.ConfigParser;
import sample.Main;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Asus on 12.05.2015.
 */
public class ReadMacrosFile {
    @Cfg
    public static String F1 = "DefaultMacros F1";           // Макросы по умолчанию
    @Cfg
    public static String F2 = "DefaultMacros F2";
    @Cfg
    public static String F3 = "DefaultMacros F3";
    @Cfg
    public static String F4 = "DefaultMacros F4";
    @Cfg
    public static String F5 = "DefaultMacros F5";
    @Cfg
    public static String F6 = "DefaultMacros F6";

    public ReadMacrosFile() throws NoSuchMethodException, InstantiationException, IllegalAccessException, IOException, InvocationTargetException
    {
        ConfigParser.parse(this,
                Main.pathUserHome + System.getProperty("file.separator") + Main.nameMacrosFile);
    }
}
