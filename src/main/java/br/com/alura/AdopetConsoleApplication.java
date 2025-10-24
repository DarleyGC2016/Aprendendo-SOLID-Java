package br.com.alura;

import br.com.alura.client.ClientHttpConfig;
import br.com.alura.service.AbrigoService;
import br.com.alura.service.PetService;

import java.util.Scanner;

public class AdopetConsoleApplication {

    public static void main(String[] args) {

         ClientHttpConfig clientHttpConfig = new ClientHttpConfig();

        AbrigoService abrigoService = new AbrigoService(clientHttpConfig);
        PetService petService = new PetService(clientHttpConfig);

        System.out.println("##### BOAS VINDAS AO SISTEMA ADOPET CONSOLE #####");
        try {
           int opcaoEscolhida = 0;
            Scanner scanner = null;
            while (opcaoEscolhida != 5) {
                opcaoEscolhida = menuSystem();
                switch (opcaoEscolhida) {
                    case 1:
                        abrigoService.listarAbrigosCadastrados();
                        break;
                    case 2:
                        abrigoService.cadastrarNovoAbrigo();
                        break;
                    case 3:
                        petService.ListarPetsAbrigo();
                        break;
                    case 4:
                        petService.importarPetsAbrigo();
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("NÚMERO INVÁLIDO!");
                        opcaoEscolhida = 0;
                        break;
                }

            }
            System.out.println("Finalizando o programa...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    @SuppressWarnings("resource")
    private static int menuSystem() {
        System.out.println("\nDIGITE O NÚMERO DA OPERAÇÃO DESEJADA:");
        System.out.println("1 -> Listar abrigos cadastrados");
        System.out.println("2 -> Cadastrar novo abrigo");
        System.out.println("3 -> Listar pets do abrigo");
        System.out.println("4 -> Importar pets do abrigo");
        System.out.println("5 -> Sair");
        return new Scanner(System.in).nextInt();
    }

}
