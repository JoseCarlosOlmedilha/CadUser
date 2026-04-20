package com.caduser.dto;

import jakarta.validation.constraints.NotBlank;

public record EnderecoCadastroDto(@NotBlank String cep,
                                  @NotBlank String rua,
                                  @NotBlank String bairro,
                                  @NotBlank String cidade,
                                  @NotBlank String estado,
                                  @NotBlank String numero) {
}
