#This custom dockerfile reads database file from /docker-entrypoint.d
FROM microsoft/mssql-server-linux AS custom-mssql

CMD ( sleep 20 ; /opt/mssql-tools/bin/sqlcmd -U sa -P $SA_PASSWORD -i /docker-entrypoint-initdb.d/* ) & /opt/mssql/bin/sqlservr
