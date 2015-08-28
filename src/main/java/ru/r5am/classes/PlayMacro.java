package ru.r5am.classes;

import jssc.SerialPortException;
import ru.r5am.filework.datafilework.ReadDataFile;
import ru.r5am.filework.inifilework.ReadIniFile;

/*
 * Created by Aleksandr Jashhuk (R5AM) on 09.05.2015.
 */

public class PlayMacro {

    // Работа макроса
    public static void playMacro(String macrosText) throws SerialPortException {

        // Подготовка COM-порта к работе
        COMPort.initCOMPort();

        // Пробежимся по символам макроса
        for (int i = 0; i < macrosText.length(); i++) {
            //System.out.print(macrosText.toCharArray()[i] + " ");

            switch (macrosText.toCharArray()[i]) {

                case '1':
                    playSymbol(ReadDataFile.cw1);
                    break;

                case '2':
                    playSymbol(ReadDataFile.cw2);
                    break;

                case '3':
                    playSymbol(ReadDataFile.cw3);
                    break;

                case '4':
                    playSymbol(ReadDataFile.cw4);
                    break;

                case '5':
                    playSymbol(ReadDataFile.cw5);
                    break;

                case '6':
                    playSymbol(ReadDataFile.cw6);
                    break;

                case '7':
                    playSymbol(ReadDataFile.cw7);
                    break;

                case '8':
                    playSymbol(ReadDataFile.cw8);
                    break;

                case '9':
                    playSymbol(ReadDataFile.cw9);
                    break;

                case '0':
                    playSymbol(ReadDataFile.cw0);
                    break;

                case 'A':
                    playSymbol(ReadDataFile.cwA);
                    break;

                case 'B':
                    playSymbol(ReadDataFile.cwB);
                    break;

                case 'C':
                    playSymbol(ReadDataFile.cwC);
                    break;

                case 'D':
                    playSymbol(ReadDataFile.cwD);
                    break;

                case 'E':
                    playSymbol(ReadDataFile.cwE);
                    break;

                case 'F':
                    playSymbol(ReadDataFile.cwF);
                    break;

                case 'G':
                    playSymbol(ReadDataFile.cwG);
                    break;

                case 'H':
                    playSymbol(ReadDataFile.cwH);
                    break;

                case 'I':
                    playSymbol(ReadDataFile.cwI);
                    break;

                case 'J':
                    playSymbol(ReadDataFile.cwJ);
                    break;

                case 'K':
                    playSymbol(ReadDataFile.cwK);
                    break;

                case 'L':
                    playSymbol(ReadDataFile.cwL);
                    break;

                case 'M':
                    playSymbol(ReadDataFile.cwM);
                    break;

                case 'N':
                    playSymbol(ReadDataFile.cwN);
                    break;

                case 'O':
                    playSymbol(ReadDataFile.cwO);
                    break;

                case 'P':
                    playSymbol(ReadDataFile.cwP);
                    break;

                case 'Q':
                    playSymbol(ReadDataFile.cwQ);
                    break;

                case 'R':
                    playSymbol(ReadDataFile.cwR);
                    break;

                case 'S':
                    playSymbol(ReadDataFile.cwS);
                    break;

                case 'T':
                    playSymbol(ReadDataFile.cwT);
                    break;

                case 'U':
                    playSymbol(ReadDataFile.cwU);
                    break;

                case 'V':
                    playSymbol(ReadDataFile.cwV);
                    break;

                case 'W':
                    playSymbol(ReadDataFile.cwW);
                    break;

                case 'X':
                    playSymbol(ReadDataFile.cwX);
                    break;

                case 'Y':
                    playSymbol(ReadDataFile.cwY);
                    break;

                case 'Z':
                    playSymbol(ReadDataFile.cwZ);
                    break;


                case '?':
                    playSymbol(ReadDataFile.cwQUEST);
                    break;

                case '=':
                    playSymbol(ReadDataFile.cwEQUAL);
                    break;

                case '/':
                    playSymbol(ReadDataFile.cwSLASH);
                    break;

                case ' ':
                    playSymbol(ReadDataFile.cwSPACE);
                    break;
            }
        }
        System.out.println();

        // Закрываем порт
        COMPort.serialPort.closePort();
    }

    // Играем символ
    private static void playSymbol(String cwSymbol) throws SerialPortException {

        int dotDuration = ReadIniFile.caliberSpeedCW/ReadIniFile.speedCW;      // Длительность точки
        int dashDuration = 3 * dotDuration;                                    // Длительность тире

        char[] dotDashMassive = cwSymbol.toCharArray();

        for (char aDotDashMassive : dotDashMassive) {
//            System.out.print(datDashMassive [i]);

            switch (aDotDashMassive) {
                // Воспроизводим тире
                case '-':
                    COMPort.onCOMSignals(dashDuration, ReadIniFile.cwManipulationSignal);
                    break;

                // Воспроизводим точку
                case '.':
                    COMPort.onCOMSignals(dotDuration, ReadIniFile.cwManipulationSignal);
                    break;

                // Пробел (между словами - 7 точек тишины)
                case '_':
                    try {
                        Thread.sleep(7*dotDuration);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
            }
            // Задержка между посылками ( в одну точку )
            try {
                Thread.sleep(dotDuration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        // Задержка после символа ( в три точки + дополнительная из INI-файла)
        try {
            Thread.sleep(3*dotDuration + ReadIniFile.betweenSymbolsDelay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
