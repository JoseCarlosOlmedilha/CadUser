package com.caduser.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public record UsuarioAtualizacaoRequestDto(@NotNull(message = "O campo nome não pode ser nulo") String nome,
                                           @NotNull(message = "O campo e-mail não pode ser nulo") @Email String email) {
}
