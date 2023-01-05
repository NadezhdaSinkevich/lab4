package by.application.javaWeb.repository;

import by.application.javaWeb.model.dto.AutoDto;
import by.application.javaWeb.model.entity.Auto;

import java.util.List;
import java.util.Optional;

public interface AutoRepository {
    Optional<Auto> findById(Integer id);
    List<AutoDto> findAll();
    void save(Auto auto);
}
