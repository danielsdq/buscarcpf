/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProjetoCpf.buscacpf.controller;

import com.ProjetoCpf.buscacpf.entity.Pessoa;
import com.ProjetoCpf.buscacpf.service.PessoaService;
import java.time.LocalDate;
import java.util.Optional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import static tools.jackson.databind.type.LogicalType.DateTime;

/**
 *
 * @author Daniel
 */
@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    
    private final PessoaService pessoaService;
    
    @PostMapping
    public Pessoa cadastrar(@RequestBody Pessoa pessoa){
        return pessoaService.salvar(pessoa);
    }
    @PutMapping
    public Pessoa alterar(@RequestBody Pessoa pessoa){
        return pessoaService.alterar(pessoa);
    }
    
    public PessoaController(PessoaService pessoaService){
        this.pessoaService = pessoaService;
    }
    
    @GetMapping("/cpf")
    public ResponseEntity<Pessoa> buscaPorCpf(
        @RequestParam String cpf
    ){
        Optional<Pessoa> pessoa = pessoaService.buscaPorCpf(cpf);
        
        return pessoa
                .map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    
    @GetMapping("/email")
    public ResponseEntity<Pessoa> buscaPorEmail(
    
            @RequestParam String email
            
            
    ){
        Optional<Pessoa> pessoa = pessoaService.buscaPorEmail(email);
        
        return pessoa
                .map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    @GetMapping("/nome-data")
    public ResponseEntity<Pessoa> buscarPorNomeDataNascimento(
            @RequestParam String nome,
            
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate dataNascimento
    ){
        
        Optional<Pessoa> pessoa = pessoaService.buscaPorNomeAndDataNascimento(
                nome, 
                dataNascimento
        );
    
    return pessoa

            .map(ResponseEntity::ok)
            .orElseGet(()-> ResponseEntity.notFound().build());
    } 
    @DeleteMapping("/{cpf}")
    public void deletar(@PathVariable String cpf){
        pessoaService.deletarPorCpf(cpf);
    }
}
