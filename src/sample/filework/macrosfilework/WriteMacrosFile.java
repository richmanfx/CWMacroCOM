package sample.filework.macrosfilework;

import jfork.nproperty.Cfg;
import jfork.nproperty.ConfigParser;
import sample.Main;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Asus on 12.05.2015.
 */
public class WriteMacrosFile {
    @Cfg
    public static String F1;
    @Cfg
    public static String F2;
    @Cfg
    public static String F3;
    @Cfg
    public static String F4;
    @Cfg
    public static String F5;
    @Cfg
    public static String F6;

    public WriteMacrosFile() throws NoSuchMethodException, InstantiationException, IllegalAccessException, IOException, InvocationTargetException
    {
        ConfigParser.store(this,
                Main.pathUserHome + System.getProperty("file.separator") + Main.nameMacrosFile);
    }

}
