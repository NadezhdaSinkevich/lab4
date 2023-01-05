package by.application.javaWeb.repository.impl;

import by.application.javaWeb.model.entity.Basket;
import by.application.javaWeb.repository.BasketRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static by.application.javaWeb.repository.config.DBConnection.getConnection;

public class BasketRepositoryImpl implements BasketRepository {

    private final String INSERT_BASKET = "insert into basket (id, user_id, auto_id) values (?, ?, ?);";
    private final String SELECT_BASKET = "select id, user_id, auto_id from basket where user_id = ";

    @Override
    public void add(Basket basket) {
        try {
            basket.setId(getMaxId());
            Connection conn = getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(INSERT_BASKET);
            preparedStatement.setInt(1, basket.getId());
            preparedStatement.setInt(2, basket.getUserId());
            preparedStatement.setInt(3, basket.getAutoId());
            preparedStatement.executeUpdate();
        } catch(Exception ex){
            System.out.println("BasketRepositoryImpl.add : "+ex.getMessage());
        }
    }

    @Override
    public List<Basket> findByUserId(Integer userId) {
        List<Basket> basketList = new ArrayList<>();
        String url = SELECT_BASKET + userId;
        try {
            Connection conn = getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(url);
            while(rs.next()){
                Basket basket = new Basket();
                basket.setId(rs.getInt(1));
                basket.setUserId(rs.getInt(2));
                basket.setAutoId(rs.getInt(3));
                basketList.add(basket);
            }
        } catch(Exception ex){
            System.out.println("BasketRepositoryImpl.findByUserId : "+ex.getMessage());
        }
        return basketList;
    }

    private Integer getMaxId() {
        Integer maxId = 0;
        String SELECT_MAX_ID = "select max(id) from basket";
        try {
            Statement statement = getConnection().createStatement();
            ResultSet rs = statement.executeQuery(SELECT_MAX_ID);
            while(rs.next()) {
                maxId = rs.getInt(1);
            }
        } catch(Exception ex){
            System.out.println("BasketRepositoryImpl.getMaxId : "+ex.getMessage());
        }
        return ++maxId;
    }
}
