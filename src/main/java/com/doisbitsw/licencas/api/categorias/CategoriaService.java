package com.doisbitsw.licencas.api.categorias;

import com.doisbitsw.licencas.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired

    private CategoriaRepository rep;
    public List<CategoriaDTO> getCategorias() {
        List<CategoriaDTO> list = rep.findAll().stream().map(CategoriaDTO::create).collect(Collectors.toList());
        return list;
    }

    public CategoriaDTO getCategoriaById(Long id) {
        Optional<Categoria> carro = rep.findById(id);
        return carro.map(CategoriaDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }


    public List<CategoriaDTO> getCategoriaId(Long id) {
        return rep.findId(id).stream().map(CategoriaDTO::create).collect(Collectors.toList());
    }


    public List<CategoriaDTO> getAtivo() {
        return rep.findAtivo().stream().map(CategoriaDTO::create).collect(Collectors.toList());
    }



    public CategoriaDTO insert(Categoria categoria) {
        Assert.isNull(categoria.getId(),"Não foi possível inserir o registro");
        return CategoriaDTO.create(rep.save(categoria));
    }

    public CategoriaDTO update(Categoria categoria, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Categoria> optional = rep.findById(id);
        if(optional.isPresent()) {
            Categoria db = optional.get();
            // Copiar as propriedades
            db.setNome(categoria.getNome());
            db.setImage(categoria.getImage());
            db.setIsativo(categoria.getIsativo());
            System.out.println("Carro id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return CategoriaDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }


}
