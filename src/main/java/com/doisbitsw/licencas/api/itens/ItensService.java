package com.doisbitsw.licencas.api.itens;

import com.doisbitsw.licencas.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItensService {

    @Autowired

    private ItensRepository rep;
    public List<ItensDTO> getCarros() {
        List<ItensDTO> list = rep.findAll().stream().map(ItensDTO::create).collect(Collectors.toList());
        return list;
    }

    public List<ItensDTO> getCarros2() {
        List<ItensDTO> list = rep.findAll2().stream().map(ItensDTO::create).collect(Collectors.toList());
        return list;
    }

    public List<ItensDTO> getCarros3() {
        List<ItensDTO> list = rep.findAll3().stream().map(ItensDTO::create).collect(Collectors.toList());
        return list;
    }

    public ItensDTO getCarroById(Long id) {
        Optional<Itens> carro = rep.findById(id);
        return carro.map(ItensDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }


    public List<ItensDTO> getCarrosByPedido(Long pedido) {
        return rep.findByPedido(pedido).stream().map(ItensDTO::create).collect(Collectors.toList());
    }


    public List<ItensDTO> getCarrosByPedidoAll(Long pedido) {
        return rep.findByPedidoAll(pedido).stream().map(ItensDTO::create).collect(Collectors.toList());
    }


    public List<ItensDTO> getCarrosByAf(Long af) {
        return rep.findByAf(af).stream().map(ItensDTO::create).collect(Collectors.toList());
    }



    public List<ItensDTO> getCarrosByEscola(Long escola, Long pedido) {
        return rep.findByEscola(escola,pedido).stream().map(ItensDTO::create).collect(Collectors.toList());
    }


    public List<ItensDTO> getEscolar(Long escola, Long ano) {
        return rep.findEscolar(escola,ano).stream().map(ItensDTO::create).collect(Collectors.toList());
    }


    public List<ItensDTO> getMaisPedidos( Long ano) {
        return rep.findMaisPedidos(ano).stream().map(ItensDTO::create).collect(Collectors.toList());
    }


    public List<ItensDTO> getByFornecedor(Long fornecedor) {
        return rep.findByFornecedor(fornecedor).stream().map(ItensDTO::create).collect(Collectors.toList());
    }


    public List<ItensDTO> getEscolaAll(Long ano) {
        return rep.findEscolaAll(ano).stream().map(ItensDTO::create).collect(Collectors.toList());
    }


    public List<ItensDTO> getItensAno(Long ano) {
        return rep.findItensAno(ano).stream().map(ItensDTO::create).collect(Collectors.toList());
    }



    public List<ItensDTO> getTotalMes(Long ano) {
        return rep.findTotalMes(ano).stream().map(ItensDTO::create).collect(Collectors.toList());
    }


    public List<ItensDTO> getTotalMesNivel(Long nivel,Long ano) {
        return rep.findTotalMesNivel(nivel,ano).stream().map(ItensDTO::create).collect(Collectors.toList());
    }


    public List<ItensDTO> getTotalMesEscola(Long escola,Long ano) {
        return rep.findTotalMesEscola(escola,ano).stream().map(ItensDTO::create).collect(Collectors.toList());
    }


    public List<ItensDTO> getTotalCategoria(Long ano) {
        return rep.findTotalCategoria(ano).stream().map(ItensDTO::create).collect(Collectors.toList());
    }


    public List<ItensDTO> getTotalCategoriaNivel(Long nivel,Long ano) {
        return rep.findTotalCategoriaNivel(nivel,ano).stream().map(ItensDTO::create).collect(Collectors.toList());
    }


    public List<ItensDTO> getTotalCategoriaEscola(Long escola,Long ano) {
        return rep.findTotalCategoriaEscola(escola,ano).stream().map(ItensDTO::create).collect(Collectors.toList());
    }

    public double getFamiliarEscola(Long escola,Long ano){
        return rep.findFamiliarEscola(escola,ano);
    }

    public List<ItensDTO> getTotalEscolas(Long ano) {
        return rep.findTotalEscolas(ano).stream().map(ItensDTO::create).collect(Collectors.toList());
    }


    public List<ItensDTO> getTotalEscolaNivel(Long nivel,Long ano) {
        return rep.findTotalEscolaNivel(nivel,ano).stream().map(ItensDTO::create).collect(Collectors.toList());
    }




    public List<ItensDTO> getMediaAlunos(Long ano) {
        return rep.findMediaAlunos(ano).stream().map(ItensDTO::create).collect(Collectors.toList());
    }


    public List<ItensDTO> getMediaAlunosNivel(Long nivel,Long ano) {
        return rep.findMediaAlunosNivel(nivel,ano).stream().map(ItensDTO::create).collect(Collectors.toList());
    }


    public List<ItensDTO> getProdutos(Long produto,Long ano) {
        return rep.findProduto(produto,ano).stream().map(ItensDTO::create).collect(Collectors.toList());
    }


    public double getTotal(Long ano){
        return rep.findTotal(ano);
    }


    public double getTotalLimpeza(Long ano){
        return rep.findTotalLimpeza(ano);
    }



    public double getTotalNivel(Long nivel,Long ano){
        return rep.findTotalNivel(nivel,ano);
    }


    public double getTotalEscolaLimpeza(Long escola,Long ano){

            return rep.findTotalEscolaLimpeza(escola,ano);

    }

    public double getTotalEscola(Long escola,Long ano){

        return rep.findTotalEscola(escola,ano);

    }



    public double getSoma(Long escola){
        return rep.findSoma(escola);
    }



    public double getTotalAgroEscola(Long escola,Long ano){
        return rep.findTotalAgroEscola(escola,ano);
    }

    public double getTotalAgroNivel(Long nivel,Long ano){
        return rep.findTotalAgroNivel(nivel,ano);
    }


    public double getTotalAgro(Long ano){
        return rep.findTotalAgro(ano);
    }

    public double getTotalPedido(Long pedido){
        return rep.findTotalPedido(pedido);
    }

    public double getTotalAf(Long af){
        return rep.findTotalAf(af);
    }

    public double getTradicional(Long ano){
        return rep.findTradicional(ano);
    }

    //convertido para total de material de limpeza
    public double getTradicionalNivel(Long nivel,Long ano){
        return rep.findTradicionalNivel(nivel,ano);
    }


    public double getTradicionalEscola(Long escola,Long ano){
        return rep.findTradicionalEscola(escola,ano);
    }



    public double getDiversos(Long ano){
        return rep.findDiversos(ano);
    }


    public double getDiversosNivel(Long nivel,Long ano){
        return rep.findDiversosNivel(nivel,ano);
    }


    public double getDiversosEscola(Long escola,Long ano){
        return rep.findDiversosEscola(escola,ano);
    }


    public double getCart(Long escola){
        return rep.findCart(escola);
    }

    public double getEstoque(Long id){
        return rep.findEstoque(id);
    }

    public double getFamiliar(Long ano){
        return rep.findFamiliar(ano);
    }

    //verificado
    public List<ItensDTO> getProduto(Long produto) {
        return rep.findProduto(produto).stream().map(ItensDTO::create).collect(Collectors.toList());
    }

    //verificado
    public List<ItensDTO> getEstoques(Long produto,Long licitacao) {
        return rep.findEstoques(produto,licitacao).stream().map(ItensDTO::create).collect(Collectors.toList());
    }




    public ItensDTO insert(Itens pedidoItens) {
        Assert.isNull(pedidoItens.getId(),"Não foi possível inserir o registro");
        return ItensDTO.create(rep.save(pedidoItens));
    }

    public ItensDTO update(Itens itens, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Itens> optional = rep.findById(id);
        if(optional.isPresent()) {
            Itens db = optional.get();
            // Copiar as propriedades
            db.setEscola(itens.getEscola());
            db.setProduto(itens.getProduto());
            db.setCategoria(itens.getCategoria());
            db.setNivel(itens.getNivel());
            db.setFornecedor(itens.getFornecedor());
            db.setAno(itens.getAno());
            db.setAf(itens.getAf());
            db.setPedido(itens.getPedido());
            db.setAlias(itens.getAlias());
            db.setObs(itens.getObs());
            db.setStatus(itens.getStatus());
            db.setCreated(itens.getCreated());
            db.setNomeescola(itens.getNomeescola());
            db.setNomenivel(itens.getNomenivel());
            db.setUnidade(itens.getUnidade());
            db.setQuantidade(itens.getQuantidade());
            db.setValor(itens.getValor());
            db.setTotal(itens.getTotal());
            db.setIsagro(itens.getIsagro());
            db.setIscheck(itens.getIscheck());
            db.setCod(itens.getCod());
            db.setMes(itens.getMes());
            db.setIsativo(itens.getIsativo());

            System.out.println("Carro id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return ItensDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }


    public void delete(Long id) {
        rep.deleteById(id);
    }


}
