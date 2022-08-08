package br.com.senai.financaapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.senai.financaapi.service.UsuarioService;
import br.com.senai.financaapi.util.MapConverter;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
    @Autowired
    private MapConverter mapConverter;

    @Autowired
    private UsuarioService service;
	
	@GetMapping
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok(mapConverter.toJsonList(service.listar()));
    }
	
}
