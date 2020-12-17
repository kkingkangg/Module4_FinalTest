package com.example.testfinal.repository;

import com.example.testfinal.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityRepository  extends JpaRepository<City, Long> {

}
