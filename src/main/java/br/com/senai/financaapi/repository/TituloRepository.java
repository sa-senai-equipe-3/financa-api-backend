package br.com.senai.financaapi.repository;

import br.com.senai.financaapi.entity.Titulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TituloRepository extends JpaRepository<Titulo, Integer> {
	
    @Query(value = "SELECT t FROM Titulo t WHERE Upper(t.descricao) LIKE Upper(:descricao)")
    List<Titulo> listarPor(@Param("descricao") String descricao);

}
