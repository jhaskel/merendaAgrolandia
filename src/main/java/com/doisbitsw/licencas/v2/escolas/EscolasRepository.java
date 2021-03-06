package com.doisbitsw.licencas.v2.escolas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EscolasRepository extends JpaRepository<Escolas, Long> {

    @Query(value = "SELECT *  FROM unidade_escolar order by id;", nativeQuery = true)
    List<Escolas> findAll();

    List<Escolas> findCarroById(Long escola);

    @Query(value = "SELECT count(id) as quant  FROM unidade_escolar ", nativeQuery = true)
    long findQuantidade();

    @Query(value = "SELECT sum(alunos) as quantAlunos  FROM unidade_escolar ", nativeQuery = true)
    long findQuantAlunos();

    @Query(value = "SELECT sum(alunos) as quantAlunos  FROM unidade_escolar where nivelescolar = :nivel ", nativeQuery = true)
    long findQuantAlunosNivel(Long nivel);

    @Query(value = "SELECT sum(alunos) as quantAlunos  FROM unidade_escolar where id = :id ", nativeQuery = true)
    long findQuantAlunosEscola(Long id);

    @Query(value = "SELECT count(id) as quant  FROM unidade_escolar where nivelescolar = :nivel", nativeQuery = true)
    long findQuantEscolaNivel(Long nivel);

    @Query(value = "select nome from unidade_escolar where id = :id", nativeQuery = true)
    String findNome(Long id);





}
