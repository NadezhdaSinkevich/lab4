package by.application.javaWeb.service;

import by.application.javaWeb.model.entity.Basket;
import by.application.javaWeb.repository.impl.BasketRepositoryImpl;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class BasketService {

    private final BasketRepositoryImpl basketRepository;

    public void saveToBasket(Integer userId, Integer autoId) {
        Basket basket = new Basket();
        basket.setUserId(userId);
        basket.setAutoId(autoId);
        basketRepository.add(basket);
    }

    public List<Basket> getAllByUserId(Integer userId) {
        return basketRepository.findByUserId(userId);
    }

}
