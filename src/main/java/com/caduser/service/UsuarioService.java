package com.caduser.service;

import com.caduser.dto.UsuarioCadastroRequestDto;
import com.caduser.exception.UsuarioExceprtion;
import com.caduser.model.Endereco;
import com.caduser.model.Usuario;
import com.caduser.repository.UsuarioRepository;
import com.caduser.validacao.usuario.ValidacaoUsuario;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private EnderecoService enderecoService;

    List<ValidacaoUsuario> validacoes;

    public UsuarioService(UsuarioRepository usuarioRepository, EnderecoService enderecoService, List<ValidacaoUsuario> validacoes) {
        this.usuarioRepository = usuarioRepository;
        this.enderecoService = enderecoService;
        this.validacoes = validacoes;
    }

    public void cadastrarUsuario(UsuarioCadastroRequestDto usuarioDto){

        validacoes.forEach(v -> v.validar(usuarioDto));

        Usuario usuario = new Usuario(usuarioDto.email(), usuarioDto.cpf(), usuarioDto.nome(), usuarioDto.senha());

        var enderecoDto = usuarioDto.enderecoCadastroDto();

        Endereco endereco = new Endereco(enderecoDto.numero(),
                enderecoDto.estado(),
                enderecoDto.cidade(),
                enderecoDto.rua(),
                enderecoDto.bairro(),
                enderecoDto.cep());

        usuario.setEndereco(endereco);
        endereco.setUsuario(usuario);

        usuarioRepository.save(usuario);
    }

    public void deletarUsuario(Long id){

        if (!usuarioRepository.existsById(id)) {
            throw new UsuarioExceprtion("Usuario não encontrado para exclusão");
        }

        usuarioRepository.deleteById(id);

    }

    public Usuario buscarUsuario(Long id){

        return usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioExceprtion("Usuario não encontrado"));
    }

    public List<Usuario> buscarTodosUsuario(){
        return usuarioRepository.findAll();
    }

    public void atualizarUsuario(UsuarioCadastroRequestDto usuarioDto){

    }





}
