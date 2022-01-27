package com.doisbitsw.licencas.api.entrega;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@NoArgsConstructor
@Data
@Entity
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long ordem;
    private Long pedido;
    private Long escola;
    private String dia;
    private String produto;
    private String unidade;
    private String fornecedor;
    private Double quantidade;



}

