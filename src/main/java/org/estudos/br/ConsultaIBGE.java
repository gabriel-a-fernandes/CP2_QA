package org.estudos.br;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Classe para consulta de informações de estados brasileiros e distritos na API do IBGE.
 */
public class ConsultaIBGE {

    private static final String REGIOES_API_URL = "https://servicodados.ibge.gov.br/api/v1/localidades/regioes/";

    // URL base da API do IBGE para estados
    private static final String ESTADOS_API_URL = "https://servicodados.ibge.gov.br/api/v1/localidades/estados/";

    // URL base da API do IBGE para distritos
    private static final String DISTRITOS_API_URL = "https://servicodados.ibge.gov.br/api/v1/localidades/distritos/";

    //URL base da API do IBGE para regioes





    /**
     * Método para consultar informações de uma região específica.
     *
     * @param id O id da região a ser consultada.
     * @return Uma string contendo a resposta da API.
     * @throws IOException Se houver algum erro de conexão ou leitura.
     */
    public static String consultarRegiao(int id) throws IOException {
        // Monta a URL completa para consulta da região específica
        URL url = new URL(REGIOES_API_URL + id);

        // Abre uma conexão HTTP com a URL
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        // Define o método da requisição como GET
        connection.setRequestMethod("GET");

        // Prepara para ler a resposta da conexão
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        // Lê cada linha da resposta e a adiciona ao StringBuilder
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Retorna a resposta da API como uma string
        return response.toString();
    }





    /**
     * Método para consultar informações dos estados de uma região.
     *@param id A sigla da região a ser consultada.
     * @return Uma string contendo a resposta da API.
     * @throws IOException Se houver algum erro de conexão ou leitura.
     */
    public static String consultarEstadosRegiao(int id) throws IOException {
        // Monta a URL completa para consulta dos estados da região específica
        URL url = new URL(REGIOES_API_URL + id + "/estados");

        // Abre uma conexão HTTP com a URL
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        // Define o método da requisição como GET
        connection.setRequestMethod("GET");

        // Prepara para ler a resposta da conexão
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        // Lê cada linha da resposta e a adiciona ao StringBuilder
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Retorna a resposta da API como uma string
        return response.toString();
    }







    /**
     * Método para consultar informações de todos os estados.
     *
     * @return Uma string contendo a resposta da API.
     * @throws IOException Se houver algum erro de conexão ou leitura.
     */
    public static String consultarEstados() throws IOException {
        // Monta a URL completa para consulta dos estados.
        URL url = new URL(ESTADOS_API_URL);

        // Abre uma conexão HTTP com a URL
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        // Define o método da requisição como GET
        connection.setRequestMethod("GET");

        // Prepara para ler a resposta da conexão
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        // Lê cada linha da resposta e a adiciona ao StringBuilder
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Retorna a resposta da API como uma string
        return response.toString();
    }


    /**
     * Método para consultar informações de um distrito por identificador.
     *
     * @param identificador O Identificador do distrito a ser consultado.
     * @return Uma string contendo a resposta da API.
     * @throws IOException Se houver algum erro de conexão ou leitura.
     */
    public static String consultarDistritoIndentificador(int identificador) throws IOException {
        // Monta a URL completa para consulta do distrito específico
        URL url = new URL(DISTRITOS_API_URL + identificador);

        // Abre uma conexão HTTP com a URL
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        // Define o método da requisição como GET
        connection.setRequestMethod("GET");

        // Prepara para ler a resposta da conexão
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        // Lê cada linha da resposta e a adiciona ao StringBuilder
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Retorna a resposta da API como uma string
        return response.toString();
    }



}
