package sample.objects;

/**
 * Created by Asus on 31.05.2015.
 */

public class Sample {

    private int duration;           // Продолжительность сэмпла, мс
    private int tone;               // Тональность посылки (частота сэмпла)
    private int ramp;               // Длительность фронта/ската (0...20 мс)
    short[] samples;                  // Массив выборок


    // Конструктор
    public Sample(int duration, int tone, int ramp) {
        this.duration = duration;
        this.tone = tone;
        this.ramp = ramp;
    }

    // Геттеры
    public int getDuration() {
        return duration;
    }

    public int getTone() {
        return tone;
    }

    public int getRamp() {
        return ramp;
    }

    public short[] getSamples() {
        return samples;
    }

    // Сеттеры
    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setTone(int tone) {
        this.tone = tone;
    }

    public void setRamp(int ramp) {
        this.ramp = ramp;
    }

    public void generateSample() {

        double maxAmplitude = 0.5;                  // Максимальная амплитуда
        int i;
        int samplingFrequency = 44100;              // Частота дискретизации
        int rampSamples = Math.round(ramp * samplingFrequency / 1000);  // Количество выборок на фронт/спад
        double deltaAmplitude = 1.0 / rampSamples;
        System.out.println("rampSamples= " + rampSamples);

        // Количество отсчётов:
        //  продолжительность в секундах поделить на период дискретизации и округлить
        int quantitySamples = Math.round(duration * samplingFrequency / 1000);

        samples = new short[quantitySamples];       // Массив выборок

        // Фронт
        for (i = 0; i < rampSamples; i++) {
            samples[i] = (short) Math.round((maxAmplitude * Short.MAX_VALUE) *
                    (Math.sin(2.0 * Math.PI * (double) tone * (double) i / (double) samplingFrequency)) *
                    (double) i * deltaAmplitude);
        }

        // Середина посылки
        for (i = rampSamples; i < samples.length - rampSamples; i++) {
            samples[i] = (short) Math.round((maxAmplitude * Short.MAX_VALUE) *
                    (Math.sin(2.0 * Math.PI * (double) tone * (double) i / (double) samplingFrequency)));
        }

        // Спад
        for (i = samples.length - rampSamples; i < samples.length; i++) {
            samples[i] = (short) Math.round((maxAmplitude * Short.MAX_VALUE) *
                    (Math.sin(2 * Math.PI * (double) tone * (double) i / (double) samplingFrequency)) *
                    (((double) samples.length - (double) i) * deltaAmplitude));
        }

        System.out.println("Количество отсчётов: " + quantitySamples);
    }
}
