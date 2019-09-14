# Microservices de Chat

### OS ITENS INCLUSOS ###

- UM MICROSERVIÇO DE CHAT(Envia(POST HTTP) e recebe mensagem(GET HTTP)

- TESTES (BDD - CUCUMBER)

- USO DE BANCO DE DADOS MYSQL

- DEPLOY VIA DOCKER

- FRONT END (HTML, CSS E JAVASCRIPT)

### Para executar rode os seguintes comandos:

```docker-compose build```

```docker-compose up -d```


# Padrões de Projetos
Padrões GOF Utilizados
- Bridge

Esse padrão desacopla o serviço abstrato de sua implementação para que possam variar independentemente do provedor.

Exemplo:

Interface
```java
package br.com.oiansiedade.oiansiedade.adapter;

import br.com.oiansiedade.oiansiedade.model.ChatMessage;

public interface ChatBotService {

	ChatMessage talk(ChatMessage chatMessage);

}
```

Implementações
```java
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
```java
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

# Padrões de arquitetura

```
DDD: Serviços relacionados ao submdomínios DDD(Domain Driven Design)
RPI: Comunicação síncrona via request/response
BD: Um banco de dados por serviço
```





