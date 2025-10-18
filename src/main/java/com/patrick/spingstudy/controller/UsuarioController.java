package com.patrick.spingstudy.controller;

import com.patrick.spingstudy.business.UsuarioService;
import com.patrick.spingstudy.infrastructure.entity.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor

public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping

    public ResponseEntity<Usuario> salvarUsuario(Usuario usuario){
        return ResponseEntity.ok(usuarioService.salvarUsuario(usuario));
    }

}
