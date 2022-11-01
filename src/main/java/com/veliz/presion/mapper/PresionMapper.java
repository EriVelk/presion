package com.veliz.presion.mapper;

import com.veliz.presion.dto.PresionDTO;
import com.veliz.presion.entity.Presion;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PresionMapper {
    public Presion presionDTOToPresion(PresionDTO presionDTO){
        Presion presion = new Presion();
        presion.setId(presionDTO.getId());
        presion.setFecha(presionDTO.getFecha());
        presion.setHora(presionDTO.getHora());
        presion.setBrazo(presionDTO.getBrazo());
        presion.setPresionSys(presionDTO.getPresionSys());
        presion.setPulso(presionDTO.getPulso());
        presion.setPresionDia(presionDTO.getPresionDia());
        presion.setUpdated(presionDTO.getUpdated());

        return presion;
    }

    public PresionDTO presionToPresionDTO(Presion presion){
        PresionDTO presionDTO = PresionDTO.builder()
                .id(presion.getId())
                .fecha(presion.getFecha())
                .hora(presion.getHora())
                .brazo(presion.getBrazo())
                .presionSys(presion.getPresionSys())
                .presionDia(presion.getPresionDia())
                .pulso(presion.getPulso())
                .updated(presion.getUpdated())
                .build();

        return presionDTO;
    }

    public List<PresionDTO> presionListToPresionDTOList(List<Presion> presionList){
        List<PresionDTO> presionDTOList = new ArrayList<>();
        presionList.forEach(presion -> {
            presionDTOList.add(this.presionToPresionDTO(presion));
        });
        return presionDTOList;
    }
 }
