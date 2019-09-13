package oiansiedade;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.springframework.web.client.RestTemplate;

import br.com.oiansiedade.oiansiedade.model.ChatMessage;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;


public class Stepdefs {

    private static String username;
	private static String funcionalidade;
	private static String mensagem;
	
    @Dado("Que cliente entra no aplicativo: {string}")
    public void que_cliente_entrou_no_aplicativo(String string) {
    	Stepdefs.username = string;
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/";
        String statusOk = restTemplate.getForObject(url, String.class);
        assertTrue(!statusOk.isEmpty());
        
    }
    
    @Quando("Escolhe a opcao do aplicativo: {string}")
    public void escolhe_a_opcao_do_aplicativo(String string) {
        Stepdefs.funcionalidade = string;
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/"+funcionalidade+"?username="+username;
        List<ChatMessage> messages = restTemplate.getForObject(url, List.class);
        
    }
    
    @E("Digita uma mensagem: {string}")
    public void e_digita_uma_mensagem(String string) {
    	Stepdefs.mensagem = string;
//    	User user = userRepository.findByUsername(Stepdefs.username);
//    	ChatMessage chatMessage = new ChatMessage(ChatMessage.MessageType.CHAT, string, user);
    }
    
   
    @Entao("O chatbot responde: {string}")
    public void o_chat_tem_que_responder_com(String string) {
        RestTemplate restTemplate = new RestTemplate();
        String message = "http://localhost:8080/messages?username="+username;
        
    }

}
