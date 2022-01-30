package com.doisbitsw.licencas.api.pedidos;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long escola;
    private Long licitacao;
    private Double total;
    private String status;
    private String user;
    private Boolean isaf;
    private String createdAt;
    private String modifiedAt;
    private Boolean isativo;
    private Boolean ischeck;

    //não vai pro banco
    @Column(nullable = false)
    private String nomedaescola;
    @Column(nullable = false)
    private Long idsetor;






}

