package br.com.senai.financaapi.controller;

import br.com.senai.financaapi.entity.Fornecedor;
import br.com.senai.financaapi.service.FornecedorService;
import br.com.senai.financaapi.util.MapConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private MapConverter mapConverter;

    @Autowired
    private FornecedorService service;

    @PostMapping
    public ResponseEntity<?> inserir(@RequestBody Map<String, Object> fornecedorMap){
        Fornecedor novoFornecedor = mapper.convertValue(fornecedorMap, Fornecedor.class);
        Fornecedor fornecedorSalvo = service.inserir(novoFornecedor);
        return ResponseEntity.created(URI.create("/fornecedor/id/" + fornecedorSalvo.getId())).build();
    }

    public ResponseEntity<?> alterar(@RequestBody Map<String, Object> transportadoraMap){
        Fornecedor fornecedorSalvo = mapper.convertValue(transportadoraMap, Fornecedor.class);
        Fornecedor fornecedorAtualizado = service.alterar(fornecedorSalvo);
        return ResponseEntity.ok(mapConverter.toJsonMap(fornecedorAtualizado));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> buscarPor(@PathVariable(name = "id") Integer id){
        return ResponseEntity.ok(mapConverter.toJsonMap(service.buscarPor(id)));
    }

    @GetMapping("/nome-fantasia/{nome-fantasia}")
    public ResponseEntity<?> listarPor(@PathVariable(name = "nome-fantasia") String nomeFantasia) {
        return ResponseEntity.ok(mapConverter.toJsonList(service.listarPor(nomeFantasia)));
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> removerPor(@PathVariable(name = "id") Integer id){
        service.removerPor(id);
        return ResponseEntity.noContent().build();
    }

}
