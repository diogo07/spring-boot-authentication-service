# Importar o Projeto


Para importação, é necessário clonar o projeto ou fazer o download dele e descompactar em qualquer diretório do computador. Após isso, na IDE do eclipse:

- Selecione a opção **File -> Import** no menu superior
- No diretório **Maven**, escolha a opção **Existing Maven Projects** e clique em **Next**
- A próxima tela irá solicitar o caminho onde a pasta do projeto foi clonada ou extraída, selecione a pasta e clique em **Finish**.
- Aguarde o maven ler o arquivo **pom.xml** e realizar a instalação das dependências.

# Configuração do banco de dados 

O arquivo de configuração do banco de dados se encontra no diretório **src/main/resource/application.properties**. A configuração atual está acessando o banco de dados do MySQL, o nome do banco que será manipulado está sendo setado na prápria url do datasource, com o nome **db_login**, as demais configurações são explicadas a seguir.
- **spring.jpa.database:** Definição do banco de dados
- **spring.datasource.url:** Caminho para conexão do bando de dados
- **spring.datasource.username:** Usuário do banco
- **spring.datasource.password:** Senha do usuário do banco
- **spring.jpa.show-sql:** Recebe um boolean que define se o console exibirá o SQL gerado pelo JPA na execução de alguma query
- **spring.jpa.hibernate.ddl-auto:** Define a forma como o gerenciamento de ferramentas esquema irá manipular o esquema de banco de dados na inicialização
- **spring.jpa.properties.hibernate.dialect:** O dialect SQL faz com que o Hibernate gere SQL melhor para o banco de dados escolhido

# 