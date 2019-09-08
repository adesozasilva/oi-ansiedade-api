package br.com.oiansiedade.oiansiedade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.oiansiedade.oiansiedade.model.ChatMessage;
import br.com.oiansiedade.oiansiedade.model.User;
import br.com.oiansiedade.oiansiedade.repository.ChatMessageRepository;
import br.com.oiansiedade.oiansiedade.repository.UserRepository;


@RestController
@RequestMapping("/messages")
public class ChatController {
	
	@Autowired
	private ChatMessageRepository chatMessagerepository;
	@Autowired
	private UserRepository userRepository;

	@PostMapping
	public ChatMessage sendMessage(@RequestBody ChatMessage chatMessage) {
		chatMessagerepository.save(chatMessage);
		ChatMessage messageChatBot = new ChatMessage(ChatMessage.MessageType.CHAT,"Olá meu amigo!", new User("Ansiosinho"));
		chatMessagerepository.save(messageChatBot);
		return messageChatBot;
	}

	@GetMapping
	public List<ChatMessage> addUser(@RequestParam("user")  String user) {
		User username = userRepository.findByUsername(user);
		List<ChatMessage> messages = (List<ChatMessage>) chatMessagerepository.findByUser(username);
		
		return messages;
	}

}
