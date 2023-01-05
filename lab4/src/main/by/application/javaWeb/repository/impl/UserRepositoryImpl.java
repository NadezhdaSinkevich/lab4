package by.application.javaWeb.repository.impl;

import by.application.javaWeb.model.entity.User;
import by.application.javaWeb.repository.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Optional;

import static by.application.javaWeb.repository.config.DBConnection.getConnection;

public class UserRepositoryImpl implements UserRepository {

    @Override
    public Optional<User> findByLoginAndPassword(String login, String password) {
        String SELECT_USER = "select * from users where login = '"+login+"' and password = '"+password+"'";
        User user = null;
        try {
            Connection conn = getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_USER);
            while(rs.next()){
                user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setLogin(rs.getString(3));
                user.setPassword(rs.getString(4));
                user.setAccessModeId(rs.getInt(5));
            }
        } catch(Exception ex){
            System.out.println("UserRepositoryImpl.findByLoginAndPassword : "+ex.getMessage());
        }
        return Optional.of(user);
    }

    @Override
    public void update(Integer userId, Integer accessModeId) {
        String updateUrl = "update users set access_mode_id = "+accessModeId+" where id = "+userId;
        try {
            Connection conn = getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(updateUrl);
            preparedStatement.executeUpdate();
        } catch(Exception ex){
            System.out.println("UserRepositoryImpl.update : "+ex.getMessage());
        }
    }

    private Integer getMaxId() {
        Integer maxId = 0;
        String SELECT_MAX_ID = "select max(id) from users";
        try {
            Statement statement = getConnection().createStatement();
            ResultSet rs = statement.executeQuery(SELECT_MAX_ID);
            while(rs.next()) {
                maxId = rs.getInt(1);
            }
        } catch(Exception ex){
            System.out.println("UserRepositoryImpl.getMaxId : "+ex.getMessage());
        }
        return ++maxId;
    }
}
