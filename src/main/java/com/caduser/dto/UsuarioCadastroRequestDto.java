package com.caduser.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

public record UsuarioCadastroRequestDto(@NotBlank String nome,
                                        @NotBlank @CPF(message = "CPF inválido") String cpf,
                                        @NotBlank String email,
                                        @NotBlank String senha,
                                        @Valid EnderecoCadastroDto enderecoCadastroDto) {
}
