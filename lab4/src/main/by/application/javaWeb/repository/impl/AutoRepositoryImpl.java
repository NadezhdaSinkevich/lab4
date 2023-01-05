package by.application.javaWeb.repository.impl;

import by.application.javaWeb.model.dto.AutoDto;
import by.application.javaWeb.model.entity.Auto;
import by.application.javaWeb.model.enums.BrandType;
import by.application.javaWeb.model.enums.CarBodyType;
import by.application.javaWeb.model.enums.EngineType;
import by.application.javaWeb.model.enums.TransmissionType;
import by.application.javaWeb.repository.AutoRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static by.application.javaWeb.repository.config.DBConnection.getConnection;

public class AutoRepositoryImpl implements AutoRepository {

    public AutoRepositoryImpl() {
    }

    @Override
    public Optional<Auto> findById(Integer id) {
        String selectAuto = "select * from auto_table where id = "+id;
        Optional<Auto> optional = Optional.empty();
        try {
            Connection conn = getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(selectAuto);
            while(rs.next()){
                Auto auto = new Auto();
                auto.setId(rs.getInt(1));
                auto.setName(rs.getString(2));
                auto.setTransmissionTypeId(rs.getInt(3));
                auto.setCarBodyTypeId(rs.getInt(4));
                auto.setEngineTypeId(rs.getInt(5));
                auto.setBrandTypeId(rs.getInt(6));
                auto.setCountry(rs.getString(7));
                auto.setInfo(rs.getString(8));
                optional = Optional.of(auto);
            }
        } catch(Exception ex){
            System.out.println("AutoRepositoryImpl.findByUserId : "+ex.getMessage());
        }
       return optional;
    }

    @Override
    public List<AutoDto> findAll() {
        String selectAll = "select * from auto_table";
        List<AutoDto> autoList = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(selectAll);
            while(rs.next()) {
                AutoDto auto = getAutoDto(rs);
                autoList.add(auto);
            }
        } catch(Exception ex){
            System.out.println("AutoRepositoryImpl.findAll : "+ex.getMessage());
        }
        return autoList;
    }

    @Override
    public void save(Auto auto) {
        String INSERT_AUTO = "insert into auto_table values (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            auto.setId(getMaxId());
            Connection conn = getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(INSERT_AUTO);
            preparedStatement.setInt(1, auto.getId());
            preparedStatement.setString(2, auto.getName());
            preparedStatement.setInt(3, auto.getTransmissionTypeId());
            preparedStatement.setInt(4, auto.getCarBodyTypeId());
            preparedStatement.setInt(5, auto.getEngineTypeId());
            preparedStatement.setInt(6, auto.getBrandTypeId());
            preparedStatement.setString(7, auto.getCountry());
            preparedStatement.setString(8, auto.getInfo());
            preparedStatement.executeUpdate();
        } catch(Exception ex){
            System.out.println("AutoRepositoryImpl.add : "+ex.getMessage());
        }
    }

    private AutoDto getAutoDto(ResultSet rs) throws SQLException {
        AutoDto auto = new AutoDto();
        auto.setId(rs.getInt(1));
        auto.setName(rs.getString(2));
        auto.setTransmissionType(TransmissionType.getNameById(rs.getInt(3)));
        auto.setCarBodyType(CarBodyType.getNameById(rs.getInt(4)));
        auto.setEngineType(EngineType.getNameById(rs.getInt(5)));
        auto.setBrandType(BrandType.getNameById(rs.getInt(6)));
        auto.setCountry(rs.getString(7));
        auto.setInfo(rs.getString(8));
        return auto;
    }

    private Integer getMaxId() {
        Integer maxId = 0;
        String SELECT_MAX_ID = "select max(id) from auto_table";
        try {
            Statement statement = getConnection().createStatement();
            ResultSet rs = statement.executeQuery(SELECT_MAX_ID);
            while(rs.next()) {
                maxId = rs.getInt(1);
            }
        } catch(Exception ex){
            System.out.println("AutoRepositoryImpl.getMaxId : "+ex.getMessage());
        }
        return ++maxId;
    }
}
