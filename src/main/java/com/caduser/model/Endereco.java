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
    @JoinColumn(name = "endereco")
    private Usuario usuario;

}
