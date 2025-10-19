package com.patrick.spingstudy.business;

import com.patrick.spingstudy.infrastructure.entity.Usuario;
import com.patrick.spingstudy.infrastructure.exceptions.ConflictException;
import com.patrick.spingstudy.infrastructure.exceptions.ResourceNotFoundException;
import com.patrick.spingstudy.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public Usuario salvarUsuario(Usuario usuario){
        try {
            emailExistente(usuario.getEmail());
            usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
            return usuarioRepository.save(usuario);
        } catch (ConflictException e) {
            throw new ConflictException("Email ja cadastrado", e.getCause());
        }

    }

    public void emailExistente(String email){
        try{
            boolean  existe = verificarEmailExistente(email);
            if (existe) {
                throw new ConflictException("Email ja cadastrado" + email);
            }
        } catch (ConflictException e){
            throw new ConflictException("Email ja cadastrado" + e.getCause());
        }
    }

    public boolean verificarEmailExistente(String email){
        return usuarioRepository.existsByEmail(email);
    }

    public Usuario buscaUsuarioPorEmail(String email){
        return usuarioRepository.findByEmail(email).orElseThrow(

                () -> new ResourceNotFoundException("Email não encontrado" + email ));
    }
    public void  deletaUsuarioPorEmail(String email){
        usuarioRepository.deleteByEmail(email);
    }
}
