/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senad.tads.dsw.exemplosspring;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Dados {

    private String nome;

    private LocalDate dataNascimento;

    private int numero;
    
    public Dados() {
        
    }

    public Dados(String nome, LocalDate dataNascimento, int numero) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public boolean isMenorIdade() {
        long idade = ChronoUnit.YEARS.between(dataNascimento, LocalDate.now());
        return idade < 18;
    }

}
