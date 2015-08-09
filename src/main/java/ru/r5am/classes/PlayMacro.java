package ru.r5am.classes;

import ru.r5am.Main;
import ru.r5am.filework.datafilework.ReadDataFile;
import ru.r5am.filework.inifilework.ReadIniFile;

import javax.sound.sampled.*;
import java.io.File;

/**
 * Created by Aleksandr Jashhuk (R5AM) on 09.05.2015.
 */

public class PlayMacro {

    // Длительности
    static int dotDuration = ReadIniFile.caliberSpeedCW / ReadIniFile.speedCW;    // Длительность точки
    static int dashDuration = 3 * dotDuration;                                    // Длительность тире

    // Работа макроса
    public static void playMacro(String macrosText) {
        // System.out.println("Работает Макрос " + macrosText);



        // Пробежимся по символам макроса
        for (int i = 0; i < macrosText.length(); i++) {
            //System.out.print(macrosText.toCharArray()[i] + " ");

            switch (macrosText.toCharArray()[i]) {

                case '1':
//                    System.out.print(ReadDataFile.cw1 + "|");
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
    }

    // Играем символ
    private static void playSymbol(String cwSymbol) {

        char[] dotDashMassive = cwSymbol.toCharArray();

//        System.out.println("Точка: " + dotDuration);
//        System.out.println("Тире: " + dashDuration);

        for (char aDotDashMassive : dotDashMassive) {
//            System.out.print(datDashMassive [i]);

            switch (aDotDashMassive) {
                // Воспроизводим тире
                case '-':
                    System.out.print("-");
                    break;

                // Воспроизводим точку
                case '.':
                    System.out.print(".");
                    break;

                // Пробел (между словами - 7 точек тишины)
                case '_':
                    System.out.print(" ");
                    break;
            }
            // Задержка между посылками ( в одну точку )

        }
        // Задержка после символа ( в три точки )
        System.out.print("|");


    }


    public static void TestSample() throws Exception {
        int tone = 700;         // Тональность посылки, Гц
        int ramp = 5;           // Длительность фронта/спада посылки, мс
        int duration = ReadIniFile.caliberSpeedCW / ReadIniFile.speedCW;
        Sample dotSample = new Sample(duration, tone, ramp);
        Sample dashSample = new Sample(3 * duration, tone, ramp);

        short[] dotSamples;
        short[] dashSamples;

        System.out.println("Tone: " + dotSample.getTone());
        System.out.println("Ramp: " + dotSample.getRamp());
        System.out.println("Duration, ms: " + dotSample.getDuration());
        dotSample.generateSample();
        dashSample.generateSample();
        dotSamples = dotSample.getSamples();        // Массив сэмпла
        dashSamples = dashSample.getSamples();


        // Сохраняем в WAV-файл
        short samplingSize = 2;
        final int mono = 1;
        int samplingFrequency = 44100;

        WaveFile dot_wf = new WaveFile(samplingSize, samplingFrequency, mono, dotSamples);
        dot_wf.saveFile(new File(Main.pathUserHome +
                                 System.getProperty("file.separator") +
                                "dot.wav"));

        WaveFile dash_wf = new WaveFile(samplingSize, samplingFrequency, mono, dashSamples);
        dash_wf.saveFile(new File(Main.pathUserHome +
                                  System.getProperty("file.separator") +
                                  "dash.wav"));

        byte[] dotSamplesByte = new byte[dotSamples.length * 2];
        for (int i = 0, j = 0; i < dotSamples.length; i++, j += 2) {
            System.out.print("short[" + i + "]: " + dotSamples[i]);
            dotSamplesByte[j] = (byte) (dotSamples[i] & 0xff);
//            dotSamplesByte[j] = (byte) dotSamples[i];
            dotSamplesByte[j + 1] = (byte) ((dotSamples[i] >>> 8) & 0xff);
//            dotSamplesByte[j + 1] = (byte) (dotSamples[i] >> 8);
            System.out.println("\t\t=> byte1: " + dotSamplesByte[j] + "\tbyte2:" + dotSamplesByte[j+1]);

        }


        // Вопроизводим WAV-файл
        try {

            File soundFile = new File(Main.pathUserHome +
                                      System.getProperty("file.separator") +
                                     "dot2.wav");
            //Получаем AudioInputStream
            //Вот тут могут полететь IOException и UnsupportedAudioFileException
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);


            //Получаем реализацию интерфейса Clip
            //Может выкинуть LineUnavailableException
            Clip clip = AudioSystem.getClip();

//            AudioSystem.getAudioFileFormat(soundFile);
            //Загружаем наш звуковой поток в Clip
            //Может выкинуть IOException и LineUnavailableException
            clip.open(ais);
//            clip.open(ais.getFormat(), dotSamplesByte, 0, dotSamples.length);

            // clip.setFramePosition(0); //устанавливаем указатель на старт
            clip.start(); //Поехали!!!
        } catch (UnsupportedAudioFileException | LineUnavailableException exc) {
            exc.printStackTrace();
        }
//        System.out.println("Продолжительность моно-файла: "+wf.getDurationTime()+ " сек.");
    }


    public static void TestWaveFile() throws Exception {

        // создание одноканального wave-файла из массива целых чисел
        System.out.println("Creating mono-file...");
        short samplingSize = 2;
        int quantitySamples = 10000;
        int frequency = 700;
        int samplingFrequency = 44100;
        double maxAmplitude = 0.5;
        short[] samples = new short[quantitySamples];
        int i = 0;
        // y=sin(100*t).*exp(-t);
        for (i = 0; i < samples.length / 9; i++) {
//            samples[i] = (int)Math.round((0.5*Integer.MAX_VALUE)*(Math.sin(2*Math.PI*frequency*i/samplingFrequency)));
            samples[i] = (short) Math.round((maxAmplitude * Short.MAX_VALUE) *
                    (Math.sin(2 * Math.PI * frequency * i / samplingFrequency)) *

                    //11/Math.sqrt(2*Math.PI)*
                    // 1/Math.exp((-0.01 * Math.pow(frequency * i / samplingFrequency, 2.0)/2))));
                    0.058 * (frequency * i / samplingFrequency));
        }

        for (i = samples.length / 9; i < 8 * samples.length / 9; i++) {
//            samples[i] = (int)Math.round((0.5*Integer.MAX_VALUE)*(Math.sin(2*Math.PI*frequency*i/samplingFrequency)));
            samples[i] = (short) Math.round((maxAmplitude * Short.MAX_VALUE) *
                    (Math.sin(2 * Math.PI * frequency * i / samplingFrequency)));

            //11/Math.sqrt(2*Math.PI)*
            // 1/Math.exp((-0.01 * Math.pow(frequency * i / samplingFrequency, 2.0)/2))));
            //0.05*(frequency * i / samplingFrequency)));
        }

        for (i = 8 * samples.length / 9; i < samples.length; i++) {
//            samples[i] = (int)Math.round((0.5*Integer.MAX_VALUE)*(Math.sin(2*Math.PI*frequency*i/samplingFrequency)));
            samples[i] = (short) Math.round((maxAmplitude * Short.MAX_VALUE) *
                    (Math.sin(2 * Math.PI * frequency * i / samplingFrequency)) *

                    //11/Math.sqrt(2*Math.PI)*
                    // 1/Math.exp((-0.01 * Math.pow(frequency * i / samplingFrequency, 2.0)/2))));
                    (0.058 * (frequency * (samples.length - i) / samplingFrequency)));
        }

        final int mono = 1;
        WaveFile wf = new WaveFile(samplingSize, samplingFrequency, mono, samples);
        wf.saveFile(new File(Main.pathUserHome +
                             System.getProperty("file.separator") +
                             "testwav1.wav"));
        wf.getAudioFormat();

        // Создание стерео-файла
//        System.out.println("Создание стерео-файла...");
//        int x=0;
//        for(int i=0; i < samples.length; i++){
//            samples[i++] = (int)Math.round((Integer.MAX_VALUE/2)*
//                    (Math.sin(2*Math.PI*329.6*x/44100)));
//            samples[i] = (int)Math.round((Integer.MAX_VALUE/2)*
//                    (Math.sin(2*Math.PI*440*x/44100)));
//            x++;
//        }
//        wf = new WaveFile(4, 44100, 2, samples);
//        wf.saveFile(new File("C:/Users/Asus/testwav2.wav"));
//        System.out.println("Продолжительность стерео-файла: "+wf.getDurationTime()+ " сек.");

        // Чтение данных из файла
//        System.out.println("Чтение данных из моно-файла:");
//        wf = new WaveFile(new File("C:/Users/Asus/testwav1.wav"));
//        for(int i=0; i<10; i++){
//            System.out.println(wf.getSampleInt(i));
//        }

    }

}
