/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senad.tads.dsw.exemplosspring;

import br.senad.tads.dsw.exemplosspring.validadores.RepetirSenha;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author ftsuda
 */
@RepetirSenha
public class DadosPessoais {

    private Integer id;

    @NotBlank(message = "O preenchimento do nome é obrigatório")
    @Size(max = 100)
    private String nome;

    @NotBlank
    @Size(max = 100)
    @Email
    private String email;

    private String telefone;

    @NotBlank
    private String senha;

    @NotBlank
    private String repetirSenha;

    private String descricao;

    @Min(1)
    @Max(99)
    private int numero;

    @Min(0)
    @Digits(integer = 3, fraction = 1, message = "Valor do peso inválido. Deve ser no máximo 999,9")
    private BigDecimal peso;
    
    @Min(0)
    @Digits(integer = 1, fraction = 2, message = "Valor da altura inválido. Deve ser no máximo 9,99")
    private BigDecimal altura;

    @PastOrPresent
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) // ISO-8601
    private LocalDate dataNascimento;

    private int genero;

    @NotEmpty
    private List<String> interesses;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRepetirSenha() {
        return repetirSenha;
    }

    public void setRepetirSenha(String repetirSenha) {
        this.repetirSenha = repetirSenha;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public BigDecimal getAltura() {
        return altura;
    }

    public void setAltura(BigDecimal altura) {
        this.altura = altura;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public List<String> getInteresses() {
        return interesses;
    }

    public void setInteresses(List<String> interesses) {
        this.interesses = interesses;
    }

}
