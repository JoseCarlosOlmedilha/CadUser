package com.caduser.model;

import com.caduser.dto.UsuarioCadastroRequestDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String senha;

    @OneToOne(mappedBy = "usuario",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Endereco endereco;

    public Usuario() {}

    public Usuario(String email, String cpf, String nome, String senha) {
        this.email = email;
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }
}
