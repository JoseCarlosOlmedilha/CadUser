package com.caduser.model;

import jakarta.persistence.*;

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String numero;

    @OneToOne()
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Endereco() {}

    public Endereco(String numero, String estado, String cidade, String rua, String bairro, String cep) {
        this.numero = numero;
        this.estado = estado;
        this.cidade = cidade;
        this.rua = rua;
        this.bairro = bairro;
        this.cep = cep;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
