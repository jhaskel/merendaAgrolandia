package com.doisbitsw.licencas.api.itens;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class ItensDTO {
    private Long id;
    private Long setor;
    private Long escola;
    private Long produto;
    private String cod;
    private String alias;
    private Long categoria;
    private Long fornecedor;
    private Long nivel;
    private String unidade;
    private Long ano;
    private Long af;
    private String pedido;
    private String created;
    private String nomeescola;
    private String nomenivel;
    private String processo;
    private Double quantidade;
    private Double valor;
    private Double total;
    private Boolean ischeck;
    private Boolean isautorizado;
    private Boolean isagro;
    private String status;
    private String mes;
    private Boolean isativo;
    private Long licitacao;
    private String obs;

    private Double tot;
    private Double totAgro;
    private Double tots;
    private Double totalPedido;
    private String nomec;


    public static ItensDTO create(Itens itens) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(itens, ItensDTO.class);
    }
}
