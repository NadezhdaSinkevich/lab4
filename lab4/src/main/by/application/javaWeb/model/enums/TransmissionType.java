package by.application.javaWeb.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Коробка передач :
 * Автомат
 * Механика
 * */
@Getter
@RequiredArgsConstructor
public enum TransmissionType {

    TYPE1(1, "Machine"),
    TYPE2(2, "Mechanics");

    private final Integer id;
    private final String name;

    public List<String> getTransmissionTypeList() {
        String[] stringArray = new String[] { TYPE1.name, TYPE2.name };
        List<String> list = new ArrayList<>(Arrays.asList(stringArray));
        return list;
    }

    public static String getNameById(Integer id) {
        switch (id) {
            case 1:
                return TYPE1.name;
            default:
                return TYPE2.name;
        }
    }

    public static Integer getIdByName(String name) {
        return (name.equals(TYPE1.getName())) ? 1 : 2;
    }
}
