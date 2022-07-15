package br.com.senai.financaapi.service;

import br.com.senai.financaapi.entity.Titulo;
import br.com.senai.financaapi.repository.TituloRepository;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@Service
public class TituloService {

    @Autowired
    private TituloRepository repository;

    public Titulo inserir(@Valid @NotNull(message = "O titulo não pode ser nulo") Titulo novoTitulo) {
        Preconditions.checkArgument(novoTitulo.getId() == null, "O ID do titulo deve ser nulo");

        validateTitulo(novoTitulo);

        return repository.save(novoTitulo);
    }

    public Titulo alterar(@Valid @NotNull(message = "O titulo não pode ser nulo") Titulo tituloSalvo) {
        Preconditions.checkArgument(tituloSalvo.getId() != null, "O ID do fornecedor não deve ser nulo");

        validateTitulo(tituloSalvo);

        return repository.save(tituloSalvo);
    }

    public void removerPor(@NotNull(message = "O id para remoção não pode ser nulo") @Min(value = 1, message = "O id deve ser maior que zero") Integer id) {
        this.repository.deleteById(id);
    }

    private List<Titulo> listar() {
        return repository.findAll();
    }

    public Optional<Titulo> buscarPor(@NotNull(message = "O id de busca para fornecedor não pode ser nulo") Integer id) {
        Optional<Titulo> tituloEncontrado = repository.findById(id);
        if(isNull(tituloEncontrado)) {
            throw new RuntimeException("Não foi encontrado o titulo");
        }

        return tituloEncontrado;
    }

    private void validateTitulo(Titulo titulo) {
        Preconditions.checkNotNull(titulo.getValor(),
                "O valor do titulo não pode ser nulo");

        Preconditions.checkNotNull(titulo.getNomeBanco(),
                "O nome do banco do titulo não pode ser nulo");

        Preconditions.checkNotNull(titulo.getDescricao(),
                "A descrição do titulo não pode ser nula");

        Preconditions.checkArgument(titulo.getValor().compareTo(BigDecimal.ZERO) > 0,
                "O valor do titulo deve ser maior que 0");

        Preconditions.checkArgument(titulo.getNomeBanco().length() > 2 && titulo.getNomeBanco().length() < 20,
                "O nome do banco do titulo deve possuir entre 2 e 20 caracteres");

        Preconditions.checkArgument(titulo.getDescricao().length() > 10 && titulo.getDescricao().length() < 1500,
                "A descrição do titulo deve possuir entre 10 e 1500 caracteres");
    }

}
