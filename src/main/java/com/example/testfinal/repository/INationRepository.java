package com.example.testfinal.repository;

import com.example.testfinal.model.Nation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INationRepository extends JpaRepository<Nation, Long> {
}
