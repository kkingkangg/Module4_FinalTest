package com.example.testfinal.service.nation;

import com.example.testfinal.model.Nation;
import com.example.testfinal.repository.INationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NationServiceImpl implements NationService{
    @Autowired
    private INationRepository iNationRepository;
    @Override
    public List<Nation> findAll() {
        return iNationRepository.findAll();
    }

    @Override
    public Optional<Nation> findById(Long id) {
        return null;
    }

    @Override
    public void save(Nation nation) {

    }

    @Override
    public void delete(Long id) {

    }
}
