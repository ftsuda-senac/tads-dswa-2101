/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senad.tads.dsw.exemplosspring;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author ftsuda
 */
public class MainPadrao {

    private DadosService service = new DadosService();

    public void executar() {

        Scanner entrada = new Scanner(System.in);
        while(true) {
            System.out.println("Digite o nome: ");
            String nome = entrada.nextLine();
            System.out.println("Digite a data de nascimento no formato yyyy-MM-dd: ");
            String dataStr = entrada.nextLine();
            System.out.println("Digite um número de 1 a 99: ");
            String numeroStr = entrada.nextLine();

            Dados dado = service.gerarDados(nome, LocalDate.parse(dataStr), Integer.parseInt(numeroStr));

            System.out.println("Dados digitados:\r\nNome: " + dado.getNome() + "\r\nData nascimento: " + dado.getDataNascimento() + "\r\nNúmero: " + dado.getNumero());
        }
    }

    public static void main(String[] args) {
        MainPadrao main = new MainPadrao();
        main.executar();
    }

}
