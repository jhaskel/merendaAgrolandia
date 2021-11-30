package com.doisbitsw.licencas.api.usuario;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@Entity(name = "user")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String login;
    private String senha;
    private Long escola;
    private String nivel;
    private String recuperar;
    private String role;
    private Boolean isativo;
    private String created;
    private String modified;
    private Long setor;





}

