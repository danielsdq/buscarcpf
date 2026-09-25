/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ProjetoCpf.buscacpf.repository;

import com.ProjetoCpf.buscacpf.entity.Pessoa;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
/**
 *
 * @author Daniel
 */
public interface PessoaRepository extends JpaRepository<Pessoa, String> {
    
    Optional<Pessoa>findByCpf(String cpf);
    
    Optional<Pessoa> findByEmail(String email);
    
    Optional<Pessoa> findByNomeAndDataNascimento(
        String nome,
        LocalDate dataNascimento    
    );
    
}
