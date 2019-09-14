package br.com.oiansiedade.oiansiedade.adapter;

import org.springframework.stereotype.Component;

import br.com.oiansiedade.oiansiedade.model.ChatMessage;
import br.com.oiansiedade.oiansiedade.model.User;

@Component
public class ChatBotDialogFlowService implements ChatBotService {
	

	@Override
	public ChatMessage talk(ChatMessage chatMessage) {
		String answer = replyBasedOnMessage(chatMessage);
		return new ChatMessage(ChatMessage.MessageType.CHAT, answer, new User("ChatBot"));
	}

	private String replyBasedOnMessage(ChatMessage chatMessage) {
		String answerText = "";
		switch (chatMessage.getContent().toUpperCase()) {
		case "BOM DIA":
			answerText = "Bom dia!";
			break;
		case "BOA TARDE":
			answerText = "Boa tarde!";
			break;
		case "BOA NOITE":
			answerText = "Boa noite!";
			break;

		default:
			answerText = "Desculpe estou em treinamento, ainda não posso te entender!";
			break;
		}
		return answerText;
		
	}

}
