package by.application.javaWeb.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Класс-сущность для личного списка авто
 * */
@Entity
@Table(name = "basket")
@Data
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer userId;     //foreign key: User

    @Column
    private Integer autoId;     //foreign key: Auto

    public Basket() {
    }

    public Basket(Integer id, Integer userId, Integer autoId) {
        this.id = id;
        this.userId = userId;
        this.autoId = autoId;
    }
}
