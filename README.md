# Microservices de Chat

### OS ITENS INCLUSOS ###

<del> UM MICROSERVIÇO COM CHAT</del>

<del> TESTES (BDD - CUCUMBER) </del>

<del> USO DE BANCO DE DADOS MYSQL</del>

<del> DEPLOY VIA DOCKER	</del>

<del> FRONT END </del>

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





