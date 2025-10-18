package com.patrick.spingstudy.business;

import com.patrick.spingstudy.infrastructure.entity.Usuario;
import com.patrick.spingstudy.infrastructure.exceptions.ConflictException;
import com.patrick.spingstudy.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public Usuario salvarUsuario(Usuario usuario){
        try {
            emailExistente(usuario.getEmail());
            return usuarioRepository.save(usuario);
        } catch (Exception e){
            throw new ConflictException("Email já cadastrado",e.getCause());
        }

    }

    public void emailExistente(String email){
        try{
            boolean  existe = usuarioRepository.existsByEmail(email);
            if(existe){
                throw new ConflictException("Email já cadastrado" + email);
            }
        } catch (Exception e){
            throw new ConflictException("Email já cadastrado" + e.getCause());
        }
    }

    public boolean verificarEmailExistente(String email){
        return usuarioRepository.existsByEmail(email);
    }

}
