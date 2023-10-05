package com.example.demo.model;

import com.example.demo.form.AutoForm;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "auto")
@Getter
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Auto implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "marca")
    private String marca;

    @Column(name = "placas")
    private String placas;



    public Auto(AutoForm autoForm){
        this.marca= autoForm.getMarca();
        this.placas=autoForm.getPlacas();
    }

    public void update(AutoForm autoForm){
        this.marca= autoForm.getMarca();
        this.placas=autoForm.getPlacas();
    }
}
