package com.doisbitsw.licencas.api.afPedido;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class AfPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long af;
    private Long setor;
    private Long pedido;
    private Double total;
    private Long nivel;
    private Long fornecedor;













}

