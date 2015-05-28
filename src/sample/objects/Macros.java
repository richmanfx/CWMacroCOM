package sample.objects;

/**
 * Created by Alex on 16.03.2015.
 */

public class Macros {

    private String macrosText;          // содержимое макроса - может переименовать переменную?
    private int numberFunctionKey;      // номер функциональной клавиши, привязанной к этому макросу

    // Конструктор
    public Macros(String macrosText, int numberFunctionKey) {
        this.macrosText = macrosText;
        this.numberFunctionKey = numberFunctionKey;
    }

    // Геттеры и сеттеры
    public String getMacrosText() {
        return macrosText;
    }

    public void setMacrosText(String macrosText) {
        this.macrosText = macrosText;
    }

    public int getNumberFunctionKey() {
        return numberFunctionKey;
    }

    public void setNumberFunctionKey(int numberFunctionKey) {
        this.numberFunctionKey = numberFunctionKey;
    }
}
