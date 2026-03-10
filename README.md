# 📨 Serviço de Envio de E-mails

Este é um microsserviço especializado, integrante do ecossistema **[agendadortarefas/BFF]**. Sua única responsabilidade é processar e disparar e-mails.

## 🏗️ Papel na Arquitetura
Este serviço atua como um braço de suporte para o **BFF (Backend For Frontend)**. 
- O **BFF** orquestra a regra de negócio e solicita o envio.
- **Este Serviço** renderiza o template (Thymeleaf) e comunica-se com o servidor SMTP (Gmail).

## 🛠️ Tecnologias Principais
* **Spring Boot**: Framework base.
* **Spring Mail**: Integração com protocolos de envio.
* **Thymeleaf**: Motor de templates para e-mails HTML dinâmicos.
* **Lombok**: Redução de código boilerplate.
* **docker**.

### 🛡️ Tratamento de Erros (Padronização)

Este serviço utiliza uma abordagem de **Erro Minimalista**, delegando a lógica de exposição e tratamento de mensagens complexas ao **BFF**.

- **Fluxo:** O serviço captura exceções de baixo nível.
- **Resposta:** A API retorna um JSON simplificado com a mensagem `"Erro ao enviar email"`.
- **Objetivo:** Manter o contrato de integração limpo e permitir que o **BFF** centralize a inteligência de tratamento de exceções e a tradução de mensagens para o cliente final.
---

## ⚙️ Configurações Necessárias para Teste

Para que a aplicação consiga enviar e-mails via Gmail, você deve preencher as credenciais no arquivo `src/main/resources/application.yml`:

| Campo | Descrição |
| :--- | :--- |
| **username** | Seu endereço de e-mail. |
| **password** | **Senha de App** gerada na conta Google (16 dígitos). |
| **remetente** | O e-mail que aparecerá como quem enviou a mensagem. |
| **nomeRemetente** | O nome que aparecerá na caixa de entrada do destinatário. |

### ⚠️ Importante: Senha de App (Gmail)
O Google não permite mais o uso da sua senha comum de login em aplicações de terceiros. Para funcionar, siga estes passos:

1. Acesse sua [Conta Google](https://myaccount.google.com/).
2. Certifique-se de que a **Verificação em Duas Etapas** está ativada.
3. Busque por **"Senhas de App"** na barra de pesquisa da sua conta.
4. Gere uma senha para o app "E-mail" e copie o código de 16 dígitos.
5. Cole esse código no campo `password` do seu arquivo de configuração.
