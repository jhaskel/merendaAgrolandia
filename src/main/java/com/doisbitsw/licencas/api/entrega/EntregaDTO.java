package com.doisbitsw.licencas.api.entrega;


import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class EntregaDTO {
    private Long id;
    private Long ordem;
    private Long pedido;
    private Long escola;
    private String dia;
    private String produto;
    private Double valor;
    private String unidade;
    private String fornecedor;
    private Double quantidade;


    public static EntregaDTO create(Entrega entrega) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(entrega, EntregaDTO.class);
    }
}
