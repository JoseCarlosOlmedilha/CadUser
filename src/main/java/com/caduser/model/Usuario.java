package com.caduser.model;

import com.caduser.dto.UsuarioCadastroRequestDto;
import jakarta.persistence.*;

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

    public Usuario(){
    }

    public Usuario(UsuarioCadastroRequestDto usuarioDto){
        this.nome = usuarioDto.nome();
        this.cpf = usuarioDto.cpf();
        this.email = usuarioDto.email();
        this.senha = usuarioDto.senha();
    }


}
