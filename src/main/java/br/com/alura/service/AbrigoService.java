package br.com.alura.service;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.alura.client.ClientHttpConfig;
import br.com.alura.domain.Abrigo;

public class AbrigoService {
    private ClientHttpConfig clientHttpConfig;

    public AbrigoService(ClientHttpConfig clientHttpConfig) {
        this.clientHttpConfig = clientHttpConfig;
    }

    public void cadastrarNovoAbrigo() throws IOException, InterruptedException {
        System.out.println("Digite o nome do abrigo:");
        String nome = new Scanner(System.in).nextLine();
        System.out.println("Digite o telefone do abrigo:");
        String telefone = new Scanner(System.in).nextLine();
        System.out.println("Digite o email do abrigo:");
        String email = new Scanner(System.in).nextLine();

        Abrigo abrigo = new Abrigo(nome, telefone, email);

        HttpResponse<String> response = clientHttpConfig.requestPost("http://localhost:8080/abrigos", abrigo);

        int statusCode = response.statusCode();
        String responseBody = response.body();
        if (statusCode == 200) {
            System.out.println("Abrigo cadastrado com sucesso!");
            System.out.println(responseBody);
        } else if (statusCode == 400 || statusCode == 500) {
            System.out.println("Erro ao cadastrar o abrigo:");
            System.out.println(responseBody);
        }
    }

    public void listarAbrigosCadastrados() throws IOException, InterruptedException {

        String responseBody = clientHttpConfig.requestGet("http://localhost:8080/abrigos")
                .body();
        Abrigo[] abrigos = new ObjectMapper().readValue(responseBody, Abrigo[].class);
        List<Abrigo> abrigosList = Arrays
                .stream(abrigos)
                .toList();
        System.out.println("Abrigos cadastrados:");
        abrigosList.stream().forEach(abrigo -> {
            System.out.println(abrigo.getId() + " - " + abrigo.getNome() + " - " + abrigo.getTelefone() + " - " + abrigo.getEmail());
            System.out.println("Pets disponíveis para adoção: ");
            abrigo.getPets().forEach(System.out::println);
        });
    }
}
