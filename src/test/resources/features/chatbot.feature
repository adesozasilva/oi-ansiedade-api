# language: pt
@chatbot
Funcionalidade: Conversar com chatbot
  Usuário conversa com um chatbot sobre um problema está enfretando

  @envia_messagem
  Esquema do Cenario: Cliente envia uma mensagem
    Dado Que cliente entra no aplicativo: "<username>"
    Quando Escolhe a opcao do aplicativo: "<opcao aplicativo>"
    E Digita uma mensagem: "<mensagem>"
    Entao O chatbot responde: "<resultado esperado>"
    Exemplos:
        | username    | opcao aplicativo     | mensagem        | resultado esperado          |
        | Anderson    |   messages           |   Bom dia       |  Bom dia!                   |

