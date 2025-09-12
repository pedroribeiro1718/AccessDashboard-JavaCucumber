#language: pt

Funcionalidade: Dashboard
	Como um usuário autenticado no sistema
	Eu quero acessar o dashboard principal
	Para que possa visualizar os indicadores da minha aplicação
	
Contexto: Usuário autenticado
	Dado que estou na página de login do sistema
	E eu informo o nome do usuário "Admin"
	E eu informo a senha "admin123"
	Quando eu solicito o acesso ao sistema
	Então eu sou autenticado com sucesso
	
Cenário: Acesso ao dashboard principal
	Dado que estou na página de dashboard
	Então o sistema exibe os indicadores principais da aplicação
	
Cenário: Visualizar ações pendentes no dashboard
	Dado que estou na página de dashboard
	Quando acesso a opção de visualizar reviews de performance pendentes
	Então o sistema exibe ao menos um review de performance pendente