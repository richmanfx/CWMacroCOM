package ru.r5am.classes;

import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;

/**
 * Created by Aleksandr Jashhuk (R5AM) on 09.05.2015.
 */

public class COMPort {

    public void testPORT() {
        String nameCOMPort = "COM6";        // COM6
                                            // PTT line - RTS
                                            // Key line - DTR
        // Параметры СОМ-порта
        int baudRate = 9600;
        int dataBits = 8;
        int stopBits = 1;
        int parity = 0;

        // Массив для статусов порта
        //  int[] status = new int[4];

        // Экземпляр порта
        SerialPort serialPort = new SerialPort(nameCOMPort);

        try {
            // Открываем порт
            serialPort.openPort();
            // Выставляем параметры порта
            serialPort.setParams(baudRate, dataBits, stopBits, parity);

//            serialPort.writeBytes("Test string".getBytes());

//            serialPort.setRTS(true);

            for(int i = 1; i<=5; i++) {

                // Установить линию DTR
                if(serialPort.setDTR(true)) {
                    System.out.println("DTR has been successfully changed.");
                }
                else {
                    System.out.println("DTR has not been changed.");
                }

                // Задержка в миллисекундах
                // System.out.println("Начало задержки");
                try {
                    Thread.sleep(35);
                    // any action
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // System.out.println("Конец задержки");
                serialPort.setDTR(false);

                try {
                    Thread.sleep(35);
                    // any action
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

//            status = serialPort.getLinesStatus();

            serialPort.closePort();

            // Вывод массива статусов
//            for(int i=0; i<status.length; i++) {
//                System.out.println(status[i]);
//            }

        } catch (SerialPortException e) {
            e.printStackTrace();
        }


    }



    public void listCOMPorts() {
        //Метод getPortNames() возвращает массив строк. Элементы массива уже отсортированы.
        String[] portNames = SerialPortList.getPortNames();
        for (String portName : portNames) {
            System.out.println(portName);
        }
//        System.out.println(SerialNativeInterface.getOsType());
    }

}
