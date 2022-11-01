package com.veliz.presion.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PresionDTO {
    private Long id;
    private String fecha;
    private String hora;
    private String presionSys;
    private String presionDia;
    private String pulso;
    private String brazo;
    private String updated;
}
