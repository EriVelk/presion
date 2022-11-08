package com.veliz.presion.service.impl;

import com.veliz.presion.dao.PresionDAO;
import com.veliz.presion.dto.PresionDTO;
import com.veliz.presion.entity.Presion;
import com.veliz.presion.mapper.PresionMapper;
import com.veliz.presion.service.PresionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PresionServiceImpl implements PresionService {
    @Autowired
    PresionDAO presionDAO;

    @Autowired
    PresionMapper presionMapper;

    @Override
    public PresionDTO createPresion(PresionDTO presionDTO) {
        try{
            presionDTO.setUpdated(LocalDateTime.now().toString());
            return presionMapper.presionToPresionDTO(presionDAO.save(presionMapper.presionDTOToPresion(presionDTO)));
        }catch (Exception e){
            return null;
        }

    }

    @Override
    public PresionDTO updatePresion(PresionDTO presionDTO) {
        try{
            Presion presion = presionDAO.findById(presionDTO.getId()).get();
            Presion presionUpdated = presion;
            presionUpdated.setUpdated(LocalDateTime.now().toString());
            presionUpdated.setPresionSys(presionDTO.getPresionSys() == null ? presion.getPresionSys() : presionDTO.getPresionSys());
            presionUpdated.setPresionDia(presionDTO.getPresionDia() == null ? presion.getPresionDia() : presionDTO.getPresionDia());
            presionUpdated.setBrazo(presionDTO.getBrazo() == null ? presion.getBrazo() : presionDTO.getBrazo());
            presionUpdated.setPulso(presionDTO.getPulso() == null ? presion.getPulso() : presionDTO.getPulso());

            return presionMapper.presionToPresionDTO(presionDAO.save(presionUpdated));
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public PresionDTO getPresion(Long id) {
        try{
            PresionDTO presionDTO = presionMapper.presionToPresionDTO(presionDAO.findById(id).get());
            return presionDTO;
        }catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<PresionDTO> listPresion() {
        try{
         List<PresionDTO> list = presionMapper.presionListToPresionDTOList(presionDAO.findAll());
         return list;
        }catch (Exception e) {
            return null;
        }
    }

    @Override
    public Boolean deletePresion(Long id) {
        try{
            presionDAO.deleteById(id);
            return true;
        }catch (Exception e){
            return  false;
        }
    }
    @Override
    public List<PresionDTO> listPresionArm(String arm) {
        try{
            List<PresionDTO> list = presionMapper.presionListToPresionDTOList(presionDAO.findByBrazoEquals(arm));
            return list;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public List<PresionDTO> listPresionDate(String date) {
        try{
            String dateTemp = date.replace("-", "/");
            if(date.charAt(0) == '0'){
                dateTemp = dateTemp.substring(1);
            }
            List<PresionDTO> list = presionMapper.presionListToPresionDTOList(presionDAO.findByFechaEquals(dateTemp));
            System.out.println(list.size());
            return list;
        }catch (Exception e){
            return null;
        }
    }
}
