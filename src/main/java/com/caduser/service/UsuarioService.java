package com.caduser.service;

import com.caduser.dto.UsuarioCadastroRequestDto;
import com.caduser.model.Usuario;
import com.caduser.repository.UsuarioRepository;

import java.util.Optional;

public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void cadastrarUsuario(UsuarioCadastroRequestDto usuarioDto){
        Usuario usuario = new Usuario(usuarioDto);
        usuarioRepository.save(usuario);
    }

    public void deletarUsuario(Long id){
        usuarioRepository.deleteById(id);
    }

    public void buscarUsuario(Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if(usuario.isPresent()){
            System.out.println("Usuario encontrado com sucesso");
            System.out.println(usuario.toString());
        }else{
            System.out.println("Usuario não encontrado");
        }
    }



}
