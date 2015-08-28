package ru.r5am.classes;

import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;
import ru.r5am.filework.inifilework.ReadIniFile;

/*
 * Created by Aleksandr Jashhuk (R5AM) on 09.05.2015.
 */

public class COMPort
{
    static SerialPort serialPort;

    public static void initCOMPort()
    {

        // Чётность нужна в INT  :-)
        int parity = 0;
        if(ReadIniFile.parity) parity = 1;

        // Экземпляр порта
        serialPort = new SerialPort(ReadIniFile.nameCOMport);

        try
        {
            // Открываем порт
            serialPort.openPort();

            // Выставляем параметры порта
            serialPort.setParams(ReadIniFile.baudRate,
                                 ReadIniFile.dataBits,
                                 ReadIniFile.stopBits,
                                 parity);
        }
        catch (SerialPortException e)
        {
            e.printStackTrace();
        }
    }

    /*
    * Вывод списка доступных COM-портов
    */
    public String[] listCOMPorts()
    {
        // Метод getPortNames() возвращает массив строк. Элементы массива уже отсортированы.
        String[] portNames = SerialPortList.getPortNames();
        for (String portName : portNames)
        {
            System.out.println(portName);
        }
        return portNames;
    }


    /*
    * Выставляем сигнал на заданное время
    */
    public static void onCOMSignals(int duration, String signal) throws SerialPortException {
        // Включение сигнала
        switch (signal)
        {
            case "DTR":
                // Установить линию DTR
                if (!serialPort.setDTR(true))
                {
                    System.out.println("DTR has not been changed.");
                }

                // Задержка
                try
                {
                    Thread.sleep(duration);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                // Выключеие сигнала
                serialPort.setDTR(false);
            break;

            case "RTS":
                // Установить линию RTS
                if (!serialPort.setRTS(true))
                {
                    System.out.println("RTS has not been changed.");
                }

                // Задержка
                try
                {
                    Thread.sleep(duration);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                // Выключеие сигнала
                serialPort.setRTS(false);
            break;
        }
    }

}
