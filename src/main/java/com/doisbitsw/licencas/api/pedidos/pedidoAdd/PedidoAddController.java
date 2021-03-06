package com.doisbitsw.licencas.api.pedidos.pedidoAdd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pedidoAdd")
public class PedidoAddController {
    @Autowired
    private PedidoAddService service;


    @GetMapping()
    public ResponseEntity get() {
        List<PedidoAddDTO> pedido = service.getPedido();
        return ResponseEntity.ok(pedido);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        PedidoAddDTO pedido = service.getPedidoById(id);

        return ResponseEntity.ok(pedido);
    }



    @PostMapping

    public ResponseEntity post(@RequestBody PedidoAdd pedido) {

        PedidoAddDTO c = service.insert(pedido);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }



    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody PedidoAdd pedido) {
        pedido.setId(id);
        PedidoAddDTO c = service.update(pedido, id);
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
