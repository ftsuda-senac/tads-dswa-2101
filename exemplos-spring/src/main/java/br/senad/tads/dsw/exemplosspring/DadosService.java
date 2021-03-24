/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senad.tads.dsw.exemplosspring;

import java.time.LocalDate;

public class DadosService {
    
    public Dados gerarDados(String nome, LocalDate dataNascimento, int numero) {
        Dados dados = new Dados();
        dados.setNome(nome);
        dados.setDataNascimento(dataNascimento);
        dados.setNumero(numero);
        return dados;
    }
    
}
