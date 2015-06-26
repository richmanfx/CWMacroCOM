package ru.r5am.classes;

import ru.r5am.filework.datafilework.ReadDataFile;
import ru.r5am.filework.inifilework.ReadIniFile;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;
import javax.sound.sampled.*;
import java.io.File;

/**
 * Created by Aleksandr Jashhuk (R5AM) on 09.05.2015.
 */

public class PlayMacro {

    // Работа макроса
    public static void playMacro(String s) {
        // System.out.println("Работает Макрос " + s);

        // Расчёт скорости
        int speedCaliber = 5800;                                 // Калибровочный коэффициент скорости CW
        int dotDuration = speedCaliber / ReadIniFile.speedCW;    // Длительность точки
        int dashDuration = 3 * dotDuration;                      // Длительность тире

        for (int i = 0; i < s.length(); i++) {
            //System.out.print(s.toCharArray()[i] + " ");

            switch (s.toCharArray()[i]) {

                case '1':
//                    System.out.print(ReadDataFile.cw1 + "|");
                    playSymbol(ReadDataFile.cw1, dotDuration, dashDuration);
                    break;

                case '2':
//                    System.out.print(ReadDataFile.cw2 + "|");
                    playSymbol(ReadDataFile.cw2, dotDuration, dashDuration);
                    break;

                case '3':
//                    System.out.print(ReadDataFile.cw3 + "|");
                    playSymbol(ReadDataFile.cw3, dotDuration, dashDuration);
                    break;

                case '4':
//                    System.out.print(ReadDataFile.cw4 + "|");
                    playSymbol(ReadDataFile.cw4, dotDuration, dashDuration);
                    break;

                case '5':
//                    System.out.print(ReadDataFile.cw5 + "|");
                    playSymbol(ReadDataFile.cw5, dotDuration, dashDuration);
                    break;

                case '6':
//                    System.out.print(ReadDataFile.cw6 + "|");
                    playSymbol(ReadDataFile.cw6, dotDuration, dashDuration);
                    break;

                case '7':
//                    System.out.print(ReadDataFile.cw7 + "|");
                    playSymbol(ReadDataFile.cw7, dotDuration, dashDuration);
                    break;

                case '8':
//                    System.out.print(ReadDataFile.cw8 + "|");
                    playSymbol(ReadDataFile.cw8, dotDuration, dashDuration);
                    break;

                case '9':
//                    System.out.print(ReadDataFile.cw9 + "|");
                    playSymbol(ReadDataFile.cw9, dotDuration, dashDuration);
                    break;

                case '0':
//                    System.out.print(ReadDataFile.cw0 + "|");
                    playSymbol(ReadDataFile.cw0, dotDuration, dashDuration);
                    break;

                case 'A':
//                    System.out.print(ReadDataFile.cwA + "|");
                    playSymbol(ReadDataFile.cwA, dotDuration, dashDuration);
                    break;

                case 'B':
//                    System.out.print(ReadDataFile.cwB + "|");
                    playSymbol(ReadDataFile.cwB, dotDuration, dashDuration);
                    break;

                case 'C':
//                    System.out.print(ReadDataFile.cwC + "|");
                    playSymbol(ReadDataFile.cwC, dotDuration, dashDuration);
                    break;

                case 'D':
//                    System.out.print(ReadDataFile.cwD + "|");
                    playSymbol(ReadDataFile.cwD, dotDuration, dashDuration);
                    break;

                case 'E':
//                    System.out.print(ReadDataFile.cwE + "|");
                    playSymbol(ReadDataFile.cwE, dotDuration, dashDuration);
                    break;

                case 'F':
//                    System.out.print(ReadDataFile.cwF + "|");
                    playSymbol(ReadDataFile.cwF, dotDuration, dashDuration);
                    break;

                case 'G':
//                    System.out.print(ReadDataFile.cwG + "|");
                    playSymbol(ReadDataFile.cwG, dotDuration, dashDuration);
                    break;

                case 'H':
//                    System.out.print(ReadDataFile.cwH + "|");
                    playSymbol(ReadDataFile.cwH, dotDuration, dashDuration);
                    break;

                case 'I':
//                    System.out.print(ReadDataFile.cwI + "|");
                    playSymbol(ReadDataFile.cwI, dotDuration, dashDuration);
                    break;

                case 'J':
//                    System.out.print(ReadDataFile.cwJ + "|");
                    playSymbol(ReadDataFile.cwJ, dotDuration, dashDuration);
                    break;

                case 'K':
//                    System.out.print(ReadDataFile.cwK + "|");
                    playSymbol(ReadDataFile.cwK, dotDuration, dashDuration);
                    break;

                case 'L':
//                    System.out.print(ReadDataFile.cwL + "|");
                    playSymbol(ReadDataFile.cwL, dotDuration, dashDuration);
                    break;

                case 'M':
//                    System.out.print(ReadDataFile.cwM + "|");
                    playSymbol(ReadDataFile.cwM, dotDuration, dashDuration);
                    break;

                case 'N':
//                    System.out.print(ReadDataFile.cwN + "|");
                    playSymbol(ReadDataFile.cwN, dotDuration, dashDuration);
                    break;

                case 'O':
//                    System.out.print(ReadDataFile.cwO + "|");
                    playSymbol(ReadDataFile.cwO, dotDuration, dashDuration);
                    break;

                case 'P':
//                    System.out.print(ReadDataFile.cwP + "|");
                    playSymbol(ReadDataFile.cwP, dotDuration, dashDuration);
                    break;

                case 'Q':
//                    System.out.print(ReadDataFile.cwQ + "|");
                    playSymbol(ReadDataFile.cwQ, dotDuration, dashDuration);
                    break;

                case 'R':
//                    System.out.print(ReadDataFile.cwR + "|");
                    playSymbol(ReadDataFile.cwR, dotDuration, dashDuration);
                    break;

                case 'S':
//                    System.out.print(ReadDataFile.cwS + "|");
                    playSymbol(ReadDataFile.cwS, dotDuration, dashDuration);
                    break;

                case 'T':
//                    System.out.print(ReadDataFile.cwT + "|");
                    playSymbol(ReadDataFile.cwT, dotDuration, dashDuration);
                    break;

                case 'U':
//                    System.out.print(ReadDataFile.cwU + "|");
                    playSymbol(ReadDataFile.cwU, dotDuration, dashDuration);
                    break;

                case 'V':
//                    System.out.print(ReadDataFile.cwV + "|");
                    playSymbol(ReadDataFile.cwV, dotDuration, dashDuration);
                    break;

                case 'W':
//                    System.out.print(ReadDataFile.cwW + "|");
                    playSymbol(ReadDataFile.cwW, dotDuration, dashDuration);
                    break;

                case 'X':
//                    System.out.print(ReadDataFile.cwX + "|");
                    playSymbol(ReadDataFile.cwX, dotDuration, dashDuration);
                    break;

                case 'Y':
//                    System.out.print(ReadDataFile.cwY + "|");
                    playSymbol(ReadDataFile.cwY, dotDuration, dashDuration);
                    break;

                case 'Z':
//                    System.out.print(ReadDataFile.cwZ + "|");
                    playSymbol(ReadDataFile.cwZ, dotDuration, dashDuration);
                    break;


                case '?':
//                    System.out.print(ReadDataFile.cwQUEST + "|");
                    playSymbol(ReadDataFile.cwQUEST, dotDuration, dashDuration);
                    break;

                case '=':
//                    System.out.print(ReadDataFile.cwEQUAL + "|");
                    playSymbol(ReadDataFile.cwEQUAL, dotDuration, dashDuration);
                    break;

                case '/':
//                    System.out.print(ReadDataFile.cwSLASH + "|");
                    playSymbol(ReadDataFile.cwSLASH, dotDuration, dashDuration);
                    break;

                case ' ':
//                    System.out.print(" ");
                    playSymbol(ReadDataFile.cwSPACE, dotDuration, dashDuration);
                    break;

            }


        }
        System.out.println("");

    }

    private static void playSymbol(String cwSymbol, int dot, int dash) {
        char[] dotDashMassive = cwSymbol.toCharArray();

        for (int i = 0; i < dotDashMassive.length; i++) {
//            System.out.print(datDashMassive [i]);

            switch (dotDashMassive[i]) {
                // Воспроизводим тире
                case '-':
                    System.out.print("-");
                    break;

                // Воспроизводим точку
                case '.':
                    System.out.print(".");
                    PlayMIDI();
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

    private static void PlayMIDI() {
        try {
            Synthesizer synth = MidiSystem.getSynthesizer();
            synth.open();
            MidiChannel[] channels = synth.getChannels();
            channels[0].programChange(94);
            channels[0].noteOn(65, 80);
            Thread.sleep(200); // in milliseconds
            channels[0].noteOff(65);
            synth.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        System.out.println("Длительность, мс: " + dotSample.getDuration());
        dotSample.generateSample();
        dashSample.generateSample();
        dotSamples = dotSample.getSamples();        // Массив сэмпла
        dashSamples = dashSample.getSamples();


        // Сохраняем в WAV-файл
        short samplingSize = 2;
        final int mono = 1;
        int samplingFrequency = 44100;

        WaveFile dot_wf = new WaveFile(samplingSize, samplingFrequency, mono, dotSamples);
        dot_wf.saveFile(new File("C:/Users/Asus/dot.wav"));

        WaveFile dash_wf = new WaveFile(samplingSize, samplingFrequency, mono, dashSamples);
        dash_wf.saveFile(new File("C:/Users/Asus/dash.wav"));

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

            File soundFile = new File("C:/Users/Asus/dot2.wav");
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
        System.out.println("Создание моно-файла...");
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
        wf.saveFile(new File("C:/Users/Asus/testwav1.wav"));
        wf.getAudioFormat();
        System.out.println("Продолжительность моно-файла: " + wf.getDurationTime() + " сек.");

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
