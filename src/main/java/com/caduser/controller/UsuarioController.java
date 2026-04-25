package com.caduser.controller;

import com.caduser.dto.UsuarioAtualizacaoRequestDto;
import com.caduser.dto.UsuarioCadastroRequestDto;
import com.caduser.model.Usuario;
import com.caduser.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {


    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarUsuario(@RequestBody @Valid UsuarioCadastroRequestDto usuarioDto){
        usuarioService.cadastrarUsuario(usuarioDto);
        return ResponseEntity.ok("Cadastro realizado com sucesso");
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String> deletarUsuario(@PathVariable Long id){
        usuarioService.deletarUsuario(id);
        return ResponseEntity.ok("Exclusão realizada com sucesso");
    }

    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id ,@RequestBody UsuarioAtualizacaoRequestDto dto){
        Usuario usuario = usuarioService.atualizarUsuario(id ,dto);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable Long id){
        Usuario ususario = usuarioService.buscarUsuario(id);
        return ResponseEntity.ok(ususario);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Usuario>> buscarTodosUsuarios(){
        List<Usuario> usuarios = usuarioService.buscarTodosUsuario();
        return ResponseEntity.ok(usuarios);
    }


}
