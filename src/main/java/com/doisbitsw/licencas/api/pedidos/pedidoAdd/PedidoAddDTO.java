package com.doisbitsw.licencas.api.pedidos.pedidoAdd;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class PedidoAddDTO {
    private Long id;
    private Long escola;
    private String user;
    private Double total;
    private String status;
    private Boolean isaf;
    private String createdAt;
    private String modifiedAt;
    private Boolean isativo;
    private Boolean ischeck;
    private Long licitacao;



    public static PedidoAddDTO create(PedidoAdd pedido) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(pedido, PedidoAddDTO.class);
    }
}
