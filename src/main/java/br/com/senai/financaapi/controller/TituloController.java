package br.com.senai.financaapi.controller;

import br.com.senai.financaapi.entity.Titulo;
import br.com.senai.financaapi.service.TituloService;
import br.com.senai.financaapi.util.MapConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;

@Controller
public class TituloController {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private MapConverter mapConverter;

    @Autowired
    private TituloService service;

    @PostMapping
    public ResponseEntity<?> inserir(@RequestBody Map<String, Object> tituloMap){
        Titulo novoTitulo = mapper.convertValue(tituloMap, Titulo.class);
        Titulo tituloSalvo = service.inserir(novoTitulo);
        return ResponseEntity.created(URI.create("/titulo/id/" + tituloSalvo.getId())).build();
    }

    public ResponseEntity<?> alterar(@RequestBody Map<String, Object> tituloMap){
        Titulo tituloSalvo = mapper.convertValue(tituloMap, Titulo.class);
        Titulo tituloAtualizado = service.alterar(tituloSalvo);
        return ResponseEntity.ok(mapConverter.toJsonMap(tituloAtualizado));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> buscarPor(@PathVariable(name = "id") Integer id){
        return ResponseEntity.ok(mapConverter.toJsonMap(service.buscarPor(id)));
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> removerPor(@PathVariable(name = "id") Integer id){
        service.removerPor(id);
        return ResponseEntity.noContent().build();
    }
}
