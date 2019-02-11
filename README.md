# Yet Another Business Inteligence

Fornece uma interface web para os dados importantes para uma instituição.

- - -

## TODO

1. Tratar erros das conexões SQL
2. Remover System.out.println's do fluxo de segurança
3. Lidar com erros no backend.
   Adicionar algum tipo de chip no front-end
   retornar mensagens de erro melhores ?
4. Lidar com o .csrf().disable() no WebConfiguration no backend

## Testes

### Banco de Dados
cada banco é iniciado com o docker e tem os dados do [Chinook inserido](https://github.com/lerocha/chinook-database/).
então é necessario rodar o script _que vou fazer_ que inicia as imagens e insere os dados.

#### Bancos usados
1. [MariaDB](https://hub.docker.com/_/mariadb/)
2. [OracleDB](https://hub.docker.com/r/alexeiled/docker-oracle-xe-11g/)
3. [PostgresSQL](https://hub.docker.com/_/postgres/)
4. [SqlServer](https://hub.docker.com/r/microsoft/mssql-server-linux/)


# Log

## Infra estutura de teste /sep 6, 2018

Cada banco vai sobe com o docker-compose (yabi/backend/Databases).

```bash
O comando para subir tudo é o docker-compose up
```

O docker do sqlserver não tem um ponto de inicialização do diretório entao eu fiz meu proprio dockerfile que inicia o servidor e depois importa os dados em /docker-entrypoint-initdb.d, como os outros bancos.

```Dockerfile
#This custom dockerfile reads database file from /docker-entrypoint.d
FROM microsoft/mssql-server-linux AS mssql-custom

CMD ( sleep 20 ; /opt/mssql-tools/bin/sqlcmd -U sa -P $SA_PASSWORD -i /docker-entrypoint-initdb.d/Chinook_SqlServer.sql/* ) & /opt/mssql/bin/sqlservr
```

a parte 

>( sleep 20 ; -yadayada- ) &

inicia um subshell que inicia primeiro mas dorme por 20 segundos e depois roda o comando que importa os dados. Enquanto o $sleep está acontecendo, a segunda parte do comando corre. Ela inicia o servidor do mssql. Com sorte, a inicalização do banco é mais rápida que 20 segundos. Outra coisa legal é que como o comando que inicia o servidor é executado por último, qualquer erro que acontece durante a inicialização sobe (ou desce ?) para o docker.

### Build da imagem do mssql


```bash
docker build -t custom-mssql .
```

## Sexta 7 de setembro


1. Busquei o formato das strings de conexão
2. Instalei o driver do oracle XE
   Tive que criar uma conta na oracle e adicionar um novo servidor no maven

## Segunda, 10 de setembro

Queries do Oracle não devem ter ; no final, dá um erro de query inválida
(é necessário avisa o admin na hora de adicionar as queries)

é clara a necessidade de gerar erros significativos para o administrador que cria a query. talvez neja necessário uma página que seja possivel testar as queries e conexões com o banco de dados... um console de SQL ?

## Terça, 11 de setembro

Os testes com os quatro bancos funcionou.
A imagem do docker "_custom-mssql_" também funcionou.
**É necessário tratar as excepções do SQL**

## Terça, 5 de fevereiro 2019

Implementado autorização básica na api, sem acessar o servidor LDAP.

Experimentação com o Spring Security, depois de obter conselhos e códigos de exemplo
Retorna um YabiUser qualquer
Imprime na tela os estágios da autenticação

## Quarta, 6 de Fevereiro de 2019

Implementei autenticação que traz da base de dados um YabiUser no authentication.getDetails().
**Dá um erro de autenticação ao acessar uma página de conteúdo, como é o caso do /sqlQueries.**

## Quinta, 7 de fevereiro

*Adicionar o .csrf().disable() resolveu o problema de não autorização*
*Nao devo considerar como resolvido. Adicionei ao TODO*

### Há um erro que deixa o sistema inconsistente
	o nome do usuário não é único. 
	Na bateria de testes o usuário admin é inserido uma outra vez (já é inserido na inicialização)
	*Thu Feb  7 23:30:42 WET 2019*
	Para isso eu inseri @Column(unique = true) no atributro nome
	Adicionei a mesma anotação em:
		* PermissionTree.nodePath (já havia)
		* SqlQuery ficou com a combinação de PermissionTree.id e SqlQuery.name unica
			@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"permission", "name"}))
		* Directory.name e Directory.connectionString não podem repetir
	Criei uma coleção no postman que testa conflitos de entradas duplicadas e exportei em:
		* ./tests/Yabi.postman_collection.jsons

## Sat Feb  9 22:38:29 WET 2019

Alterei a aplicação angular para utilizar autenticação em todas requisições para a api.
Utilizei um serviço *HttpInterceptor* que é *provided* na raiz da aplicação. O serviço adiciona o
cabeçalho as requisições:
	*Authentication: Basic ${base64(username):base64(password)}*

É necessário usar um método melhor de autenticação. Preferencialmente, [jwt tokens](https://jwt.io/)

A coleção do Yabi-init no postman mudou os id do diretório. Trava a aplicação
Adicionado a lista de TODO:
* Lidar com erros no backend.
  Adicionar algum tipo de chip no front-end
  retornar mensagens de erro melhores ?
  
Configurei o CORS no back-end para autorizar pedidos do *http://localhost/**


## Mon Feb 11 18:42:54 WET 2019

Parece que o Spring já usa o JSESSIONID como token. É um cookie. JWT não parece necessário.

Comecei a implementar um endpoint que será usado para buscar as queries em função do usuário logado.

Comecei a implementar uma validação no permissionTree:
  * garantir que o parentNode existe
  * garantir que o nodepath está correto
	Talvez o nodePath pode ser calculado.


