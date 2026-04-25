package com.caduser.validacao.usuarioCadastro;

import com.caduser.dto.UsuarioCadastroRequestDto;
import com.caduser.exception.UsuarioEmailException;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ValidarCadastroFormatoEmail implements ValidacaoCadastroUsuario {

    @Override
    public void validar(UsuarioCadastroRequestDto dto) {

        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        Pattern pattern= Pattern.compile(regex);
        Matcher matcher= pattern.matcher(dto.email());
        if (!matcher.matches()) {
            throw new UsuarioEmailException("Formato do e-mail não corresponde ao padrão");
        }

    }
}
