package org.estudos.br;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ConsultaIBGEMockTest {
    // Mock para simular a conexão HTTP
    @Mock
    private HttpURLConnection connectionMock;

    // JSON de resposta simulada
    private static final String JSON_RESPONSE = "[{\"id\":160030312,\"nome\":\"Fazendinha\",\"municipio\":{\"id\":1600303,\"nome\":\"Macapá\",\"microrregiao\":{\"id\":16003,\"nome\":\"Macapá\",\"mesorregiao\":{\"id\":1602,\"nome\":\"Sul do Amapá\",\"UF\":{\"id\":16,\"sigla\":\"AP\",\"nome\":\"Amapá\",\"regiao\":{\"id\":1,\"sigla\":\"N\",\"nome\":\"Norte\"}}}},\"regiao-imediata\":{\"id\":160001,\"nome\":\"Macapá\",\"regiao-intermediaria\":{\"id\":1601,\"nome\":\"Macapá\",\"UF\":{\"id\":16,\"sigla\":\"AP\",\"nome\":\"Amapá\",\"regiao\":{\"id\":1,\"sigla\":\"N\",\"nome\":\"Norte\"}}}}}}]";  // Método executado antes de cada teste
    @BeforeEach
    public void setup() throws IOException {
        // Inicializa os mocks
        MockitoAnnotations.openMocks(this);

        // Configura o comportamento do mock
        InputStream inputStream = new ByteArrayInputStream(JSON_RESPONSE.getBytes());
        when(connectionMock.getInputStream()).thenReturn(inputStream);
    }

    // Teste para verificar se o método consultarDistritoIdentificador retorna o JSON esperado para o distrido Fazendinha
    @Test
    @DisplayName("Consulta usando o Mock")
    public void testConsultarDistritoIdentificadorComMock() throws IOException {
        // Identificador do distrito a ser consultado
        int identificadorDistrito = 160030312;

        // Act (Execução do método a ser testado)
        String response = ConsultaIBGE.consultarDistritoIndentificador(identificadorDistrito);

        // Verificamos se o JSON retornado é o mesmo que o JSON de resposta simulada
        assertEquals(JSON_RESPONSE, response, "O JSON retornado não corresponde ao esperado.");
    }
}
