package br.com.oiansiedade.oiansiedade.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.oiansiedade.oiansiedade.model.ChatMessage;
import br.com.oiansiedade.oiansiedade.model.User;

public interface ChatMessageRepository extends CrudRepository<ChatMessage, Integer> {
	
	List<ChatMessage> findByRecipient(User recipient);

}