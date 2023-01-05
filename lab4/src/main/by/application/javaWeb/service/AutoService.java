package by.application.javaWeb.service;

import by.application.javaWeb.model.dto.AutoDto;
import by.application.javaWeb.model.entity.Auto;
import by.application.javaWeb.repository.impl.AutoRepositoryImpl;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AutoService {

    private AutoRepositoryImpl autoRepository;

    public AutoService() {
        autoRepository = new AutoRepositoryImpl();
    }

    public Optional<Auto> getAutoById(Integer id) {
        return autoRepository.findById(id);
    }

    public List<AutoDto> getCatalogAuto() {
        return autoRepository.findAll();
    }

    public void save(Auto auto) {
        autoRepository.save(auto);
    }
}
