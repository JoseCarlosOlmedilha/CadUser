package com.caduser.validacao.usuarioCadastro;

import com.caduser.dto.UsuarioCadastroRequestDto;
import com.caduser.exception.UsuarioEmailException;
import com.caduser.repository.UsuarioRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidarCadastroEmail implements ValidacaoCadastroUsuario {

    private UsuarioRepository usuarioRepository;

    public ValidarCadastroEmail(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void validar(UsuarioCadastroRequestDto dto) {
       var usuario = usuarioRepository.findByEmail(dto.email());

       if(dto.email().equalsIgnoreCase(usuario.getEmail())){
           throw new UsuarioEmailException("Email já cadastrado");
       }

    }
}
