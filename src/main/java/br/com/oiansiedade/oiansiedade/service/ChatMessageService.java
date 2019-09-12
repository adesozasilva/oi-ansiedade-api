package br.com.oiansiedade.oiansiedade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.oiansiedade.oiansiedade.adapter.ChatBotService;
import br.com.oiansiedade.oiansiedade.model.ChatMessage;
import br.com.oiansiedade.oiansiedade.model.User;
import br.com.oiansiedade.oiansiedade.repository.ChatMessageRepository;
import br.com.oiansiedade.oiansiedade.repository.UserRepository;

@Service
public class ChatMessageService {

	@Autowired
	private ChatMessageRepository chatMessageRepository;
	@Autowired
	private ChatBotService chatBotDialogFlowService;
	@Autowired
	private UserRepository userRepository;
	
	public void saveMessage(ChatMessage chatMessage) {
		User sender = userRepository.findByUsername(chatMessage.getSender().getUsername());
		chatMessage.setSender(sender);
		chatMessage.setRecipient(getLoggedUser());
		chatMessageRepository.save(chatMessage);
		
	}


	public ChatMessage sendMessage(ChatMessage chatMessage) {
		saveMessage(chatMessage);
		ChatMessage answerMessage = chatBotDialogFlowService.talk(chatMessage);
		saveMessage(answerMessage);
		
		return answerMessage;
	}

	public List<ChatMessage> findMessagesByUsername(String username) {
		User user = userRepository.findByUsername(username);
		List<ChatMessage> messages = (List<ChatMessage>) chatMessageRepository.findByRecipient(user);
		
		return messages;
	}

	private User getLoggedUser() {
		return userRepository.findByUsername("Anderson");
	}
}
