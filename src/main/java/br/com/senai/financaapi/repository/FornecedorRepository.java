package br.com.senai.financaapi.repository;

import br.com.senai.financaapi.entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {

}
