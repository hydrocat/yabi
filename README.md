
Testes
------

## Banco de Dados
cada banco é iniciado com o docker e tem os dados do [Chinook inserido](https://github.com/lerocha/chinook-database/).
então é necessario rodar o script _que vou fazer_ que inicia as imagens e insere os dados.

### Bancos usados
1. [MariaDB](https://hub.docker.com/_/mariadb/)
2. [OracleDB](https://hub.docker.com/r/alexeiled/docker-oracle-xe-11g/)
3. [PostgresSQL](https://hub.docker.com/_/postgres/)
4. [SqlServer](https://hub.docker.com/r/microsoft/mssql-server-linux/)


# Notas

Infra estutura de teste /sep 6, 2018
-----

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

Build da imagem do mssql
----

```bash
docker build -t custom-mssql .
```

Sexta 7 de setembro
--------

1. Busquei o formato das strings de conexão
2. Instalei o driver do oracle XE
   Tive que criar uma conta na oracle e adicionar um novo servidor no maven

Segunda, 10 de setembro
--------

Queries do Oracle não devem ter ; no final, dá um erro de query inválida
(é necessário avisa o admin na hora de adicionar as queries)

é clara a necessidade de gerar erros significativos para o administrador que cria a query. talvez neja necessário uma página que seja possivel testar as queries e conexões com o banco de dados... um console de SQL ?

Terça, 11 de setembro
----------

Os testes com o s quatro bancos funcionou.
A imagem do docker "_custom-mssql_" também funcionou.
**É necessário tratar as excepções do SQL**
