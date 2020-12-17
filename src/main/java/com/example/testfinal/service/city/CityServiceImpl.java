package com.example.testfinal.service.city;

import com.example.testfinal.model.City;
import com.example.testfinal.repository.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService{
    @Autowired
    private ICityRepository iCityRepository;
    @Override
    public List<City> findAll() {
        return iCityRepository.findAll();

    }

    @Override
    public Optional<City> findById(Long id) {
        return iCityRepository.findById(id);
    }

    @Override
    public void save(City city) {
        iCityRepository.save(city);
    }

    @Override
    public void delete(Long id) {
        iCityRepository.deleteById(id);
    }
}
