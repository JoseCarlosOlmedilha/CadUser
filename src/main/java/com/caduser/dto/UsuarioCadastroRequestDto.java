package com.caduser.dto;

public record UsuarioCadastroRequestDto(String nome,
                                        String cpf,
                                        String email,
                                        String senha) {
}
