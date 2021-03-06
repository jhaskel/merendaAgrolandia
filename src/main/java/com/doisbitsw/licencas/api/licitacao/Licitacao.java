package com.doisbitsw.licencas.api.licitacao;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class Licitacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long ano;
    private String processo;
    private String edital;
    private String objeto;
    private String alias;
    private Double valorfinal;
    private String prazo;
    private String homologadoAt;
    private String createdAt;
    private String modifiedAt;
    private Boolean isativo;

}

