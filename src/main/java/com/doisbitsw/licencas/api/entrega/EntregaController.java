package com.doisbitsw.licencas.api.entrega;

import com.doisbitsw.licencas.api.contabilidade.ContabilidadeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/entrega")
public class EntregaController {
    @Autowired
    private EntregaService service;


    @GetMapping()
    public ResponseEntity get() {
        List<EntregaDTO> cardapio = service.getCardapio();
        return ResponseEntity.ok(cardapio);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        EntregaDTO cardapio = service.getCardapioById(id);
        return ResponseEntity.ok(cardapio);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity getFornecId(@PathVariable("id") Long id) {
        List<EntregaDTO> cardapio = service.getFornecId(id);
        return cardapio.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(cardapio);
    }

    @GetMapping("/ordem/{ordem}")
    public ResponseEntity getNivel(@PathVariable("ordem") Long ordem) {
        List<EntregaDTO> carros = service.getOrdem(ordem);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }

    @PostMapping
    public ResponseEntity post(@RequestBody Entrega entrega) {
        EntregaDTO c = service.insert(entrega);
        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Entrega entrega) {
        entrega.setId(id);
        EntregaDTO c = service.update(entrega, id);
        return c != null ?
                ResponseEntity.ok(c) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
