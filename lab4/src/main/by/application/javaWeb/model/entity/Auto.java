package by.application.javaWeb.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Класс-сущность для автомобиля
 * */
@Entity
@Table(name = "auto_table")
@Data
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private Integer transmissionTypeId;     //Коробка передач

    @Column
    private Integer carBodyTypeId;          //Тип кузова

    @Column
    private Integer engineTypeId;           //Тип двигателя

    @Column
    private Integer brandTypeId;            //Марка

    @Column
    private String country;

    @Column
    private String info;

    public Auto() {
    }

    public Auto(Integer id, String name, Integer transmissionTypeId, Integer carBodyTypeId, Integer engineTypeId,
                Integer brandTypeId, String country, String info) {
        this.id = id;
        this.name = name;
        this.transmissionTypeId = transmissionTypeId;
        this.carBodyTypeId = carBodyTypeId;
        this.engineTypeId = engineTypeId;
        this.brandTypeId = brandTypeId;
        this.country = country;
        this.info = info;
    }

}
