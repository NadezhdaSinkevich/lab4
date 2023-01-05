package by.application.javaWeb.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Тип двигателя:
 * Бензин
 * Дизель
 * Газ
 * Гибрид
 * Электричество
 * */
@Getter
@RequiredArgsConstructor
public enum EngineType {

    TYPE1(1, "Petrol"),
    TYPE2(2, "Diesel"),
    TYPE3(3, "Gas"),
    TYPE4(4, "Hybrid"),
    TYPE5(5, "Electricity");

    private final Integer id;
    private final String name;

    public List<String> getEngineTypeList() {
        String[] stringArray = new String[] { TYPE1.name, TYPE2.name, TYPE3.name, TYPE4.name, TYPE5.name};
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
            default:
                return TYPE5.name;
        }
    }

    public static Integer getIdByName(String name) {
        if (name.equals(TYPE1.getName())) return 1;
        if (name.equals(TYPE2.getName())) return 2;
        if (name.equals(TYPE3.getName())) return 3;
        if (name.equals(TYPE4.getName())) return 4;
        return 5;
    }

}

