package com.doisbitsw.licencas.api.config;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class Config {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String entidade;
    private String setor;
    private String nomeContato;
    private String cargo;
    private String email;
    private String celular;
    private Boolean isativo;
    private String created;
    private String modified;




}

