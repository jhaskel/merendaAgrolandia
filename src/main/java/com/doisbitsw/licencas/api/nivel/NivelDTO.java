package com.doisbitsw.licencas.api.nivel;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class NivelDTO {
    private Long id;
    private String nome;
    private Boolean ativo;
    private String created;
    private String modified;

    public static NivelDTO create(Nivel nivel) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(nivel, NivelDTO.class);
    }
}