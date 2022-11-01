package com.veliz.presion.dao;

import com.veliz.presion.entity.Presion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PresionDAO extends JpaRepository<Presion, Long> {
}
