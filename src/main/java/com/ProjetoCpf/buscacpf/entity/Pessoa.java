/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProjetoCpf.buscacpf.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Daniel
 */
@Entity
@Getter
@Setter

public class Pessoa {
    
    @Id
    private String cpf;
    
    private String nome;
    private String telefone;
    private String email;
    private LocalDate dataNascimento;
    
   
}

