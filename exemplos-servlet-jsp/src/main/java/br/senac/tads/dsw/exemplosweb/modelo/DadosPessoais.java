/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.exemplosweb.modelo;

import java.time.LocalDate;
import java.util.List;

public class DadosPessoais {

    private String nome;

    private LocalDate dataNascimento;

    private String telefone;

    private String email;
    
    private List<ExperienciaProfissional> experienciasProfissionais;

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ExperienciaProfissional> getExperienciasProfissionais() {
        return experienciasProfissionais;
    }

    public void setExperienciasProfissionais(List<ExperienciaProfissional> experienciasProfissionais) {
        this.experienciasProfissionais = experienciasProfissionais;
    }

}
