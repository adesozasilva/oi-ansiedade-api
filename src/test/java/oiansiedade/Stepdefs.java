package oiansiedade;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.oiansiedade.oiansiedade.model.ChatMessage;
import br.com.oiansiedade.oiansiedade.model.User;
import br.com.oiansiedade.oiansiedade.repository.UserRepository;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;


public class Stepdefs {

	@Autowired
	private UserRepository userRepository;
    private String username;
	private String funcionalidade;
	private String mensagem;
	private User user;
	private ChatMessage chatMessage;
	
    @Dado("Que cliente entra no aplicativo: {string}")
    public void que_cliente_entrou_no_aplicativo(String string) {
    	this.username = string;
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        
    }
    
    @Quando("Escolhe a opcao do aplicativo: {string}")
    public void escolhe_a_opcao_do_aplicativo(String string) {
        this.funcionalidade = string;
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/"+funcionalidade+"?username="+username;
        
         ResponseEntity<List<ChatMessage>> responseEntity = restTemplate.exchange(url,
        		 HttpMethod.GET,
        		 null,
        		 new ParameterizedTypeReference<List<ChatMessage>>() {});
         
        List<ChatMessage> chatMessages = responseEntity.getBody();
        chatMessages.forEach(mensagem -> {
        	if(!(mensagem instanceof ChatMessage)) fail("Não é objeto válido de mensagem");	
        });
        
    }
    
    @E("Digita uma mensagem: {string}")
    public void e_digita_uma_mensagem(String string) {
    	this.mensagem = string;
    	user = userRepository.findByUsername(this.username);
    	chatMessage = new ChatMessage(ChatMessage.MessageType.CHAT, string, user);
    	
    	assertEquals(user.getUsername(), username);
    	assertEquals(chatMessage.getContent(), mensagem);
    	
    }
    
   
    @Entao("O chatbot responde: {string}")
    public void o_chat_tem_que_responder_com(String string) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/messages";
        ResponseEntity<ChatMessage> response = restTemplate.postForEntity(url, chatMessage, ChatMessage.class);
        ChatMessage chatMessage = response.getBody();
        assertEquals(chatMessage.getContent(), string);
        
    }

}
