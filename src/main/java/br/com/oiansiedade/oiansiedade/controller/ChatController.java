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
import br.com.oiansiedade.oiansiedade.service.ChatMessageService;


@RestController
@RequestMapping("/messages")
public class ChatController {
	
	@Autowired
	private ChatMessageService chatMessageservice;

	@PostMapping
	public ChatMessage sendMessage(@RequestBody ChatMessage chatMessage) {
		
		ChatMessage messageChatBot = chatMessageservice.sendMessage(chatMessage);
		
		return messageChatBot;
	}
	
	@GetMapping
	public List<ChatMessage> getMessages(@RequestParam("username") String username) {
		
		List<ChatMessage> messages = chatMessageservice.findMessagesByUsername(username);

		return messages;
	}


}
