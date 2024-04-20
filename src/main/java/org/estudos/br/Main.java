package org.estudos.br;

import java.io.IOException;
import java.util.Scanner;

/**
 * Classe principal para interação com o usuário e consulta de informações de estados brasileiros e distritos.
 */
public class Main {

    /**
     * Método principal para execução do programa.
     *
     * @param args Argumentos da linha de comando (não utilizados neste programa).
     */
    public static void main(String[] args) {
        // Cria um objeto Scanner para ler entrada do usuário a partir do console
        Scanner scanner = new Scanner(System.in);

        // Variável para controlar o loop do menu
        boolean continuar = true;

        // Loop do menu
        while (continuar) {
            // Imprime um menu para o usuário escolher qual API consultar
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Consultar informações de uma regiao");
            System.out.println("2. Consultar informações dos estados de uma região");
            System.out.println("3. Consultar informações de todos os estados");
            System.out.println("4. Consultar informações de um distrito");
            System.out.println("5. Sair");

            System.out.print("Opção: ");

            // Lê a opção do usuário
            int opcao = scanner.nextInt();

            try {
                // Verifica a opção do usuário e executa a ação correspondente
                switch (opcao) {
                    case 1:
                        consultarRegiao(scanner);
                        break;
                    case 2:
                        consultarEstadosRegiao(scanner);
                        break;
                    case 3:
                        consultarEstados();
                        break;
                    case 4:
                        consultarDistritoIdentificador(scanner);
                        break;
                    case 5:
                        continuar = false;
                        System.out.println("\n Obrigado por usar nossos serviços!");// Sair do loop do menu
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (IOException e) {
                // Trata exceção caso ocorra um erro durante a consulta
                System.err.println("Ocorreu um erro ao realizar a consulta: " + e.getMessage());
            }
        }

        // Fecha o objeto Scanner para liberar recursos
        scanner.close();
    }

    /**
     * Método para consultar informações de uma região.
     *
     * @param scanner O Scanner para ler a entrada do usuário.
     * @throws IOException Se houver algum erro de conexão ou leitura.
     */

    private static void consultarRegiao(Scanner scanner) throws IOException {
        // Imprime uma mensagem de instrução para o usuário
        System.out.println("Digite o id da região a ser consultada: ");

        // Lê o id da região fornecido pelo usuário
        int id = scanner.nextInt();

        // Chama o método consultarRegiao da classe ConsultaIBGE para obter informações da região
        String resultado = ConsultaIBGE.consultarRegiao(id);

        // Imprime o resultado da consulta
        System.out.println("Resultado da consulta: ");
        System.out.println(resultado);
    }

    /**
     * Método para consultar informações dos estados de uma região.
     *
     * @param scanner O Scanner para ler a entrada do usuário.
     * @throws IOException Se houver algum erro de conexão ou leitura.
     */

    private static void consultarEstadosRegiao(Scanner scanner) throws IOException {
        // Imprime uma mensagem de instrução para o usuário
        System.out.println("Digite o id da região que pretende consultar os estados: ");

        // Lê a sigla do estado fornecida pelo usuário
        int id = scanner.nextInt();

        // Chama o método consultarEstadosRegiao da classe ConsultaIBGE para obter informações da região
        String resultado = ConsultaIBGE.consultarEstadosRegiao(id);

        // Imprime o resultado da consulta
        System.out.println("Resultado da consulta: ");
        System.out.println(resultado);
    }




    /**
     * Método para consultar informações de todos os estados.
     *
     *
     * @throws IOException Se houver algum erro de conexão ou leitura.
     */
    private static void consultarEstados() throws IOException {

        // Chama o método consultarEstados da classe ConsultaIBGE para obter informações dos Estados
        String resultado = ConsultaIBGE.consultarEstados();

        // Imprime o resultado da consulta
        System.out.println("Resultado da consulta: ");
        System.out.println(resultado);
    }



    /**
     * Método para consultar informações de um distrito.
     *
     * @param scanner O Scanner para ler a entrada do usuário.
     * @throws IOException Se houver algum erro de conexão ou leitura.
     */
    private static void consultarDistritoIdentificador(Scanner scanner) throws IOException {
        // Imprime uma mensagem de instrução para o usuário
        System.out.println("Digite o identificador do distrito a ser consultado: ");

        // Lê o Identificador do distrito fornecido pelo usuário
        int identificador = scanner.nextInt();

        // Chama o método consultarDistritoIdentificador da classe ConsultaIBGE para obter informações do distrito
        String resultado = ConsultaIBGE.consultarDistritoIndentificador(identificador);

        // Imprime o resultado da consulta
        System.out.println("Resultado da consulta: ");
        System.out.println(resultado);
    }

}

