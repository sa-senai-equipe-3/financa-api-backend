package br.com.senai.financaapi.service;

import br.com.senai.financaapi.entity.Fornecedor;
import br.com.senai.financaapi.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    public Fornecedor inserir(Fornecedor novoFornecedor) {


        return repository.save(novoFornecedor);
    }

    public Fornecedor alterar(Fornecedor fornecedorSalvo) {


        return repository.save(fornecedorSalvo);
    }

    public List<Fornecedor> listPor(String nome) {


        return repository.listarPor(nome);
    }

    public List<Fornecedor> listar() {
        return repository.findAll();
    }
}
