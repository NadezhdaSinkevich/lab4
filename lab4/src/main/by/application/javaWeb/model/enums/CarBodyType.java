package by.application.javaWeb.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Тип кузова :
 * Внедорожник
 * Кроссовер
 * Хэтчбек
 * Седан
 * Купе
 * Кабриолет
 * */
@Getter
@RequiredArgsConstructor
public enum CarBodyType {

    TYPE1(1, "SUV"),
    TYPE2(2, "Crossover"),
    TYPE3(3, "Hatchback"),
    TYPE4(4, "Sedan"),
    TYPE5(5, "Coupe"),
    TYPE6(6, "Convertible");

    private final Integer id;
    private final String name;

    public List<String> getCarBodyTypeList() {
        String[] stringArray = new String[] { TYPE1.name, TYPE2.name, TYPE3.name, TYPE4.name, TYPE5.name, TYPE6.name};
        List<String> list = new ArrayList<>(Arrays.asList(stringArray));
        return list;
    }

    public static String getNameById(Integer id) {
        switch (id) {
            case 1:
                return TYPE1.name;
            case 2:
                return TYPE2.name;
            case 3:
                return TYPE3.name;
            case 4:
                return TYPE4.name;
            case 5:
                return TYPE5.name;
            default:
                return TYPE6.name;
        }
    }

    public static Integer getIdByName(String name) {
        if (name.equals(TYPE1.getName())) return 1;
        if (name.equals(TYPE2.getName())) return 2;
        if (name.equals(TYPE3.getName())) return 3;
        if (name.equals(TYPE4.getName())) return 4;
        if (name.equals(TYPE5.getName())) return 5;
        return 6;
    }

}
