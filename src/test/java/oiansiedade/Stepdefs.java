package oiansiedade;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.springframework.web.client.RestTemplate;

import br.com.oiansiedade.oiansiedade.model.ChatMessage;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class Stepdefs {

    private static String username;
	private static String tipo;


    @Dado("Que cliente entra no aplicativo: {string}")
    public void que_cliente_entrou_no_aplicativo(String username) {
    	Stepdefs.username = username;
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/";
        String ok = restTemplate.getForObject(url, String.class);
    }
    
    @Quando("Escolhe a opcao de pagamento: {string}")
    public void escolhe_a_opcao_de_pagamento(String funcionalidade) {
        Stepdefs.tipo = funcionalidade;
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/"+tipo+"?username="+username;
        List<ChatMessage> messages = restTemplate.getForObject(url, List.class);
        
    }

    @Entao("O pagamento tem que ser concluido com sucesso: {string}")
    public void o_pagamento_tem_que_ser_concluido_com_sucesso(String string) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/messages?username="+username;
        List<ChatMessage> messages = restTemplate.getForObject(url, List.class);
        assertTrue(messages instanceof List);
        
    }

}
