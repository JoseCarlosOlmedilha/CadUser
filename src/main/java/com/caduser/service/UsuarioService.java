package com.caduser.service;

import com.caduser.dto.UsuarioAtualizacaoRequestDto;
import com.caduser.dto.UsuarioCadastroRequestDto;
import com.caduser.exception.UsuarioExceprtion;
import com.caduser.model.Endereco;
import com.caduser.model.Usuario;
import com.caduser.repository.UsuarioRepository;
import com.caduser.validacao.usuarioCadastro.ValidacaoCadastroUsuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private EnderecoService enderecoService;

    List<ValidacaoCadastroUsuario> validacoes;

    public UsuarioService(UsuarioRepository usuarioRepository, EnderecoService enderecoService, List<ValidacaoCadastroUsuario> validacoes) {
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

    public Usuario atualizarUsuario(Long id, UsuarioAtualizacaoRequestDto usuarioDto){
        Usuario usuario = buscarUsuario(id);

        if (usuarioRepository.existsByEmailAndIdNot(usuarioDto.email(), id)){
            throw new UsuarioExceprtion("Email já cadastrado");
        }

        usuario.setNome(usuarioDto.nome());
        usuario.setEmail(usuarioDto.email());

        usuarioRepository.save(usuario);

        return usuario;
    }





}
