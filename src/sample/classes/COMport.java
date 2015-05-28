package sample.classes;

import jssc.SerialNativeInterface;
import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;

/**
 * Created by Asus on 09.05.2015.
 */

public class COMport {

    public static void testPORT() {
        String nameCOMport = "COM6";        // COM6
                                            // PTT line - RTS
                                            // Key line - DTR
        // Параметры СОМ-порта
        int baudRate = 9600;
        int dataBits = 8;
        int stopBits = 1;
        int parity = 0;
        // Массив для статусов порта
        int[] status = new int[4];

        // Экземпляр порта
        SerialPort serialPort = new SerialPort(nameCOMport);

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
                    System.out.println("DTR успешно изменён.");
                }
                else {
                    System.out.println("DTR НЕ изменён.");
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



    public static void listCOMpotrs() {
        //Метод getPortNames() возвращает массив строк. Элементы массива уже отсортированы.
        String[] portNames = SerialPortList.getPortNames();
        for(int i = 0; i < portNames.length; i++){
            System.out.println(portNames[i]);
        }
//        System.out.println(SerialNativeInterface.getOsType());
    }

}
