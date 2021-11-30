package com.doisbitsw.licencas.api.usuario;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class UsuarioDTO {
    private Long id;
    private String nome;
    private String email;
    private String login;
    private Long setor;
    private Long escola;
    private String nivel;
    private String recuperar;
    private String role;
    private Boolean isativo;
    private String created;
    private String modified;



    public static UsuarioDTO create(Usuario usuario) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(usuario, UsuarioDTO.class);
    }
}
