package com.veliz.presion.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "presiones")
public class Presion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="fecha")
    private String fecha;

    @Column(name = "hora")
    private String hora;

    @Column(name = "presion_sys")
    private String presionSys;

    @Column(name = "presion_dia")
    private String presionDia;

    @Column(name = "pulso")
    private String pulso;

    @Column(name = "brazo")
    private String brazo;

    @Column(name = "updated")
    private String updated;
}
