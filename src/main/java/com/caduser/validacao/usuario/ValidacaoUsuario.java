package com.caduser.validacao.usuario;

import com.caduser.dto.UsuarioCadastroRequestDto;

public interface ValidacaoUsuario {

    void validar(UsuarioCadastroRequestDto dto);
}
