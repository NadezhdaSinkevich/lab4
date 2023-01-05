/* База данных 'Авто каталог' */
DROP DATABASE IF EXISTS `automarketdb`;
CREATE DATABASE `automarketdb` DEFAULT CHARACTER SET utf8;
USE automarketdb;

/* 1.Таблица 'Пользователи' */
CREATE TABLE users (
    id              INT      NOT NULL AUTO_INCREMENT,
    name            VARCHAR(64) NOT NULL,
    login           VARCHAR(32) NOT NULL,
    password        VARCHAR(64) NOT NULL,
    access_mode_id  INT,
    PRIMARY KEY (id)
);

/* 2.1 Таблица 'Коробка передач' */
CREATE TABLE transmission_type (
    id      INT  NOT NULL AUTO_INCREMENT,
    name    VARCHAR(64) NOT NULL,
    PRIMARY KEY (id)
);

/* 2.2 Таблица 'Тип кузова' */
CREATE TABLE car_body_type (
    id      INT  NOT NULL AUTO_INCREMENT,
    name    VARCHAR(64) NOT NULL,
    PRIMARY KEY (id)
);

/* 2.3 Таблица 'Тип двигателя' */
CREATE TABLE engine_type (
    id      INT  NOT NULL AUTO_INCREMENT,
    name    VARCHAR(64) NOT NULL,
    PRIMARY KEY (id)
);

/* 2.4 Таблица 'Марка' */
CREATE TABLE brand_type (
    id      INT  NOT NULL AUTO_INCREMENT,
    name    VARCHAR(64) NOT NULL,
    PRIMARY KEY (id)
);

/* 2.Таблица 'Автомобили' */
CREATE TABLE auto_table (
    id                      INT NOT NULL AUTO_INCREMENT,
    name                    VARCHAR(64) NOT NULL,
    transmission_type_id    INT NOT NULL,
    car_body_type_id        INT NOT NULL,
    engine_type_id          INT NOT NULL,
    brand_type_id           INT NOT NULL,
    country                 VARCHAR(64),
    info                    TEXT,
    PRIMARY KEY (id),
    FOREIGN KEY (transmission_type_id) REFERENCES transmission_type (id),
    FOREIGN KEY (car_body_type_id) REFERENCES car_body_type (id),
    FOREIGN KEY (engine_type_id) REFERENCES engine_type (id),
    FOREIGN KEY (brand_type_id) REFERENCES brand_type (id)
);

/* 3.Таблица 'Список авто' */
CREATE TABLE basket (
    id          INT NOT NULL AUTO_INCREMENT,
    user_id     INT NOT NULL,
    auto_id     INT NOT NULL,
    PRIMARY KEY (id)
);


-- users
insert into users values (1, 'user', 'user', 'user', 0);
insert into users values (2, 'admin', 'admin', 'admin', 0);

-- transmission_type
insert into transmission_type values (1, 'Автомат');
insert into transmission_type values (2, 'Механика');

-- car_body_type
insert into car_body_type values (1, 'Внедорожник');
insert into car_body_type values (2, 'Кроссовер');
insert into car_body_type values (3, 'Хэтчбек');
insert into car_body_type values (4, 'Седан');
insert into car_body_type values (5, 'Купе');
insert into car_body_type values (6, 'Кабриолет');

-- engine_type
insert into engine_type values (1, 'Бензин');
insert into engine_type values (2, 'Дизель');
insert into engine_type values (3, 'Газ');
insert into engine_type values (4, 'Гибрид');
insert into engine_type values (5, 'Электричество');

-- brand_type
insert into brand_type values (1, 'Audi');
insert into brand_type values (2, 'BMW');
insert into brand_type values (3, 'Ford');
insert into brand_type values (4, 'Tesla');
insert into brand_type values (5, 'Volvo');

-- auto
-- insert into auto values (1, 'name', transmission_type_id, car_body_type_id, engine_type_id, brand_type_id, 'country', 'info');
insert into auto_table values (1, 'Tesla 567', 2, 1, 5, 4, 'USA', '2021');
insert into auto_table values (2, 'Audi TT', 2, 1, 3, 1, 'France', '2018');
insert into auto_table values (3, 'BMW X', 2, 1, 5, 1, 'Germany', '2019');
insert into auto_table values (4, 'Ford F5', 2, 1, 3, 1, 'Switzerland', '2012');
insert into auto_table values (5, 'Volvo XC90', 2, 1, 5, 1, 'Germany', '2010');
