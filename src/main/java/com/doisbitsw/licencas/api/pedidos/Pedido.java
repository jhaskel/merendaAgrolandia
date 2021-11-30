package com.doisbitsw.licencas.api.pedidos;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long unidade;
    private Double total;
    private String status;
    private Boolean isaf;
    private String createdAt;
    private String modifiedAt;
    private Boolean isativo;

    //não vai pro banco
    private String nomedaunidade;
    private Long idsetor;






}

