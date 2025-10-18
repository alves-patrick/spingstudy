package com.patrick.spingstudy.infrastructure.repository;

import com.patrick.spingstudy.infrastructure.entity.Endereco;
import com.patrick.spingstudy.infrastructure.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,Long> {
}
