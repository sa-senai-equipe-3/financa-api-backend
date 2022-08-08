package br.com.senai.financaapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.financaapi.entity.Usuario;
import br.com.senai.financaapi.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
    @Autowired
    private UsuarioRepository repository;
	
	public List<Usuario> listar() {
        return repository.findAll();
    }

}
