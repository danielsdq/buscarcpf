/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProjetoCpf.buscacpf.service;

import com.ProjetoCpf.buscacpf.entity.Pessoa;
import com.ProjetoCpf.buscacpf.repository.PessoaRepository;
import java.time.LocalDate;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author Daniel
 */
@Service
public class PessoaService {
    
    private final PessoaRepository pessoaRepository;
    
    
    
    public Pessoa salvar(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }
    
    public Pessoa alterar(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }
    public void deletarPorCpf(String cpf){
        pessoaRepository.deleteById(cpf);
    }
    
    public PessoaService(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }
    
    public Optional<Pessoa> buscaPorCpf(String cpf){
        return pessoaRepository.findById(cpf); 
    }
    
    public Optional<Pessoa> buscaPorEmail (String email){
        return pessoaRepository.findByEmail(email);
    }
    public Optional<Pessoa> buscaPorNomeAndDataNascimento(
            String nome,
            LocalDate dataNascimento       
    ){
        return pessoaRepository.findByNomeAndDataNascimento(
                nome, 
                dataNascimento);
    }
            
             
     
     
    
}
