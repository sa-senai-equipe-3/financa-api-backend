package br.com.senai.financaapi.repository;

import br.com.senai.financaapi.entity.Titulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TituloRepository extends JpaRepository<Titulo, Integer> {

}
