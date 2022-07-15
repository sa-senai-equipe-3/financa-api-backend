package br.com.senai.financaapi.entity;

import br.com.senai.financaapi.enums.Perfil;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Entity(name = "Usuario")
@Table(name = "usuarios")
public class Usuario {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome_completo")
    @NotEmpty(message = "O nome do usuário não pode ser vazio")
    @Size(max = 50, message = "O nome d usuário não deve conter mais que 50 caracteres")
    private String nomeCompleto;

    @Column(name = "login")
    @NotEmpty(message = "O login do usuário não pode ser vazio")
    @Size(max = 20, message = "O login do usuário não deve possuir mais que 20 caracters")
    private String login;

    @Column(name = "senha")
    @NotEmpty(message = "A senha do usuário não pode ser vazia")
    @Size(max = 10, message = "A senha do usuário não deve possuir mais que 10 caracteres")
    private String senha;

    @Column(name = "perfil")
    @NotEmpty(message = "O tipo de perfil do usuário não pode ser nulo")
    @Enumerated(EnumType.STRING)
    private Perfil perfil;

}
