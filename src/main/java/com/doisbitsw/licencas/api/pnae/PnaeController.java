package com.doisbitsw.licencas.api.pnae;

import com.doisbitsw.licencas.api.nivel.NivelDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pnae")
public class PnaeController {
    @Autowired
    private PnaeService service;


    @GetMapping()
    public ResponseEntity get() {
        List<PnaeDTO> carros = service.getCarros();
        return ResponseEntity.ok(carros);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        PnaeDTO carro = service.getCarroById(id);
        return ResponseEntity.ok(carro);
    }

    @GetMapping("/soma/{ano}")
    public double getRep(@PathVariable("ano") Long ano) {
        return service.getSoma(ano);
    }

    @GetMapping("/ano/{ano}")
    public ResponseEntity getAno(@PathVariable("ano") Long ano) {
        List<PnaeDTO> itens = service.getAno(ano);
        return itens.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(itens);
    }


    @PostMapping

    public ResponseEntity post(@RequestBody Pnae pnae) {
        PnaeDTO c = service.insert(pnae);
        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Pnae pnae) {
        pnae.setId(id);
        PnaeDTO c = service.update(pnae, id);
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
