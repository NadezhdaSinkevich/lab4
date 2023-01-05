package by.application.javaWeb.repository;

import by.application.javaWeb.model.entity.Basket;

import java.util.List;

public interface BasketRepository {
    void add(Basket basket);
    List<Basket> findByUserId(Integer userId);
}
