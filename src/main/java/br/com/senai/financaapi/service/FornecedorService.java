package br.com.senai.financaapi.service;

import br.com.senai.financaapi.entity.Fornecedor;
import br.com.senai.financaapi.repository.FornecedorRepository;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    public Fornecedor inserir(@Valid @NotNull(message = "O fornecedor não pode ser nulo") Fornecedor novoFornecedor) {
        Preconditions.checkArgument(novoFornecedor.getId() == null, "O ID do fornecedor deve ser nulo");

        validateFornecedor(novoFornecedor);

        return repository.save(novoFornecedor);
    }

    public Fornecedor alterar(@Valid @NotNull(message = "O fornecedor não pode ser nulo") Fornecedor fornecedorSalvo) {
        Preconditions.checkArgument(fornecedorSalvo.getId() != null, "O ID do fornecedor não deve ser nulo");

        validateFornecedor(fornecedorSalvo);

        return repository.save(fornecedorSalvo);
    }

    public void removerPor(@NotNull(message = "O id para remoção não pode ser nulo") @Min(value = 1, message = "O id deve ser maior que zero") Integer id) {
            this.repository.deleteById(id);
    }

    public List<Fornecedor> listarPor(@NotEmpty(message = "O nome para busca do fornecedor não pode ser vazio") String nome) {
        return repository.listarPor("%" + nome + "%");
    }

    public Optional<Fornecedor> buscarPor(@NotNull(message = "O id de busca para fornecedor não pode ser nulo") Integer id) {
        Optional<Fornecedor> fornecedorEncontrado = repository.findById(id);
        if(isNull(fornecedorEncontrado)) {
            throw new RuntimeException("Não foi encontrado o fornecedor");
        }

        return fornecedorEncontrado;
    }

    public List<Fornecedor> listar() {
        return repository.findAll();
    }

    public void validateFornecedor(Fornecedor fornecedor) {
        Preconditions.checkNotNull(fornecedor.getNomeFantasia(),
                "O nome fantasia do fornecedor não pode ser nulo");

        Preconditions.checkNotNull(fornecedor.getRazaoSocial(),
                "A razão social do fornecedor não pode ser nulo ");

        Preconditions.checkNotNull(fornecedor.getCnpj(),
                "O CNPJ do fornecedor não pode ser nulo");

        Preconditions.checkNotNull(fornecedor.getLogin(),
                "O login do fornecedor não pode ser nulo");

        Preconditions.checkNotNull(fornecedor.getSenha(),
                "A senha do fornecedor não pode ser nula");

        Preconditions.checkArgument(fornecedor.getRazaoSocial().length() > 2 && fornecedor.getRazaoSocial().length() < 80,
                "A razão social do fornecedor deve ter entre 2 e 80 caracteres");

        Preconditions.checkArgument(fornecedor.getNomeFantasia().length() > 1 && fornecedor.getNomeFantasia().length() < 90,
                "O nome fantasia do fornecedor deve ter entre 1 e 90 caracteres");

        Preconditions.checkArgument(fornecedor.getCnpj().length() == 18,
                "O CNPJ do fornecedor deve possuir 18 caracteres");

        Preconditions.checkArgument(fornecedor.getLogin().length() > 2 && fornecedor.getLogin().length() < 20,
                "O login do fornecedor deve possuir entre 2 e 20 caracteres");

        Preconditions.checkArgument(fornecedor.getSenha().length() > 2 && fornecedor.getSenha().length() < 10,
                "A senha do fornecedor deve possuir entre 2 e 10 caracteres");
    }
}
