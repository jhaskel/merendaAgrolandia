package com.doisbitsw.licencas.api.entrega;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EntregaRepository extends JpaRepository<Entrega, Long> {

    @Query(value = "SELECT * from entrega order by dia", nativeQuery = true)
    List<Entrega> findAll();

    @Query(value = "SELECT *  FROM entega WHERE id = :id ", nativeQuery = true)
    List<Entrega> findId(Long id);

    @Query(value = "SELECT * FROM entrega WHERE ordem = :ordem order by escola ", nativeQuery = true)
    List<Entrega> findOrdem(Long ordem);


}
