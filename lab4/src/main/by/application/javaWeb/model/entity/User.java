package by.application.javaWeb.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Класс-сущность для пользователя
 * */
@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String login;

    @Column
    private String password;

    @Column
    private Integer accessModeId;

    public User() {
    }

    public User(Integer id, String name, String login, String password, Integer accessModeId) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.accessModeId = accessModeId;
    }

}
