package br.com.senai.financaapi.repository;

import br.com.senai.financaapi.entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {

    @Query(value = "SELECT f FROM Fornecedor f WHERE Upper(f.nomeFantasia) LIKE Upper(:nome)")
    List<Fornecedor> listarPor(@Param("nome") String nome);
    
}
