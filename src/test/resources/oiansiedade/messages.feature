# language: pt
@messages
Funcionalidade: Ver mensagens
  Usuário conversa com um chatbot sobre um problema está enfretando

  @ver_messagem
  Esquema do Cenario: Cliente envia uma mensagem
    Dado Que cliente entra no aplicativo
    Quando Escolhe a opcao do aplicativo: <opcao aplicativo>
    E digita uma mensagem: <mensagem>
    Entao O chatbot responde: <resultado esperado>
    Exemplos:
        | username    | opcao aplicativo     | mensagem        | resultado esperado          |
        | Anderson    |   "Bom dia"          |   Bom dia!      |                             |

