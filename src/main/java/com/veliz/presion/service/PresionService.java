package com.veliz.presion.service;

import com.veliz.presion.dto.PresionDTO;

import java.util.List;

public interface PresionService {
    PresionDTO createPresion(PresionDTO presionDTO);
    PresionDTO updatePresion(PresionDTO presionDTO);
    PresionDTO getPresion(Long id);
    List<PresionDTO> listPresion();
    Boolean deletePresion(Long id);
    List<PresionDTO> listPresionArm(String arm);
    List<PresionDTO> listPresionDate(String date);
}
