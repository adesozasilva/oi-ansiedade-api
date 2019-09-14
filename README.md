# Microservices de Chat

### OS ITENS INCLUSOS ###

Padrões GOF Utilizados
- Adapter

Exemplo:

Interface
```
package br.com.oiansiedade.oiansiedade.adapter;

import br.com.oiansiedade.oiansiedade.model.ChatMessage;

public interface ChatBotService {

	ChatMessage talk(ChatMessage chatMessage);

}
```

Implementações
```
package br.com.oiansiedade.oiansiedade.adapter;

import br.com.oiansiedade.oiansiedade.model.ChatMessage;

public interface ChatBotService {

	ChatMessage talk(ChatMessage chatMessage);
}

public class ChatBotDialogFlowService implements ChatBotService {
	
	@Override
	public ChatMessage talk(ChatMessage chatMessage) {
    //Implmentação do chat do DialogFlow
	}
  
}

public class ChatBotIbmWatsonService implements ChatBotService {
	
	@Override
	public ChatMessage talk(ChatMessage chatMessage) {
    //Implmentação do chat do  IBM Watson
	}
  
}

```
Usabilidade
```
@Service
public class ChatMessageService {

	@Autowired
	private ChatBotService chatBotDialogFlowService;
  
  @Autowired
	private ChatBotService chatBotIbmWatsonService;
	
	
  public ChatMessage sendMessage(ChatMessage chatMessage) {
			ChatMessage answerOfDialogFlow = chatBotDialogFlowService.talk(chatMessage);
      //ChatMessage answerMessageOfIbmWatson = chatBotIbmWatsonService.talk(chatMessage);
			
      return answerOfDialogFlow;
	}
}

```

<del> UM MICROSERVIÇO DE MENSAGENS</del>

<del> TESTES (UNITÁRIOS + INTEGRAÇÃO) </del>

<del> USO DE BANCO DE DADOS MYSQL</del>

<del> DEPLOY VIA DOCKER	</del>

<del> FRONT END </del>


### Para executar rode os seguintes comandos:

```docker-compose build```

```docker-compose up -d```




