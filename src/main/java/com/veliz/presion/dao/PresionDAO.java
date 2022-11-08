package com.veliz.presion.dao;

import com.veliz.presion.entity.Presion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PresionDAO extends JpaRepository<Presion, Long> {
    List<Presion> findByBrazoEquals(String brazo);
    List<Presion> findByFechaEquals(String fecha);



}
