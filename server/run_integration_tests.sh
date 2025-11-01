#!/bin/bash

apt update
apt install -y jq
echo "Aguardando a API ficar pronta em http://localhost:8080 ..."

# Tenta por 60 segundos (12 tentativas de 5s)
RETRY_COUNT=0
MAX_RETRIES=12
RETRY_INTERVAL=5

# -s (silencioso), -f (falha em erro http), -o (joga saída fora)
# Vamos testar o endpoint / (Swagger) que você configurou.
until $(curl -s -f -o /dev/null "http://localhost:8080/"); do
    RETRY_COUNT=$((RETRY_COUNT+1))
    if [ $RETRY_COUNT -gt $MAX_RETRIES ]; then
        echo "Erro: A API não respondeu após $MAX_RETRIES tentativas."
        # Se falhar, mostre os logs da API antes de sair!
        echo "================ LOGS DA API ================"
        docker compose logs api
        echo "============================================="
        exit 1
    fi
    echo "API ainda não está pronta... (tentativa $RETRY_COUNT/$MAX_RETRIES). Aguardando $RETRY_INTERVAL segundos."
    sleep $RETRY_INTERVAL
done

echo "API está pronta! Iniciando os testes..."

HTTP_STATUS=$(curl -X 'POST' \
  'http://localhost:8080/profissionais' \
  -o profissional_created.json \
  -w "%{http_code}"\
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "Frank Ocean",
  "especialidade": "Cardiologista",
  "valor_hora": 150
}')

echo "Status HTTP POST: $HTTP_STATUS"

if [ "$HTTP_STATUS" -ne 201 ]; then 
    echo "ERRO ao processar dados da API de profissionais"
    exit 1 
fi
PROFISIONAL_ID=$(jq '.id' profissional_created.json) 
echo $PROFISIONAL_ID

HTTP_STATUS=$(curl -X 'GET' \
  'http://localhost:8080/profissionais' \
  -o profissionais.json\
  -w "%{http_code}"
  -H 'accept: */*')

echo "Status HTTP: $HTTP_STATUS"
if [ "$HTTP_STATUS" -ne 200 ]; then 
    echo "ERRO ao processar dados da API de Profissionais"
    exit 1 
fi


HTTP_STATUS=$(curl -X 'GET' \
  http://localhost:8080/profissionais/$PROFISIONAL_ID \
  -w "%{http_code}"\
  -o profissional_especifico.json \
  -H 'accept: */*')

echo "Status HTTP: $HTTP_STATUS"

if [ "$HTTP_STATUS" -ne "200" ]; then 
    echo "ERRO ao processar dados da API de Profissionais"
    exit 1 
fi



HTTP_STATUS=$(curl -X 'PUT' \
  http://localhost:8080/profissionais/$PROFISIONAL_ID \
  -w "%{http_code}" \
  -o profissional_update.json \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "Frank Ocean",
  "especialidade": "psiquiatria",
  "valor_hora": 150
}')

echo "Status HTTP: $HTTP_STATUS"

if [ "$HTTP_STATUS" -ne "200" ]; then 
    echo "ERRO ao processar dados da API de Profissionais"
    exit 1 
fi


HTTP_STATUS=$(curl -X 'PUT' \
  http://localhost:8080/profissionais/$PROFISIONAL_ID \
  -w "%{http_code}" \
  -o profissional_update.json \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "Frank Ocean",
  "especialidade": "psiquiatria",
  "valor_hora": 150
}')

echo "Status HTTP: $HTTP_STATUS"

if [ "$HTTP_STATUS" -ne "200" ]; then 
    echo "ERRO ao processar dados da API de Profissionais"
    exit 1 
fi


HTTP_STATUS=$(curl -X 'DELETE' \
  http://localhost:8080/profissionais/$PROFISIONAL_ID \
  -w "%{http_code}"\
  -H 'accept: */*')

echo "Status HTTP: $HTTP_STATUS"

if [ "$HTTP_STATUS" -ne "200" ]; then 
    echo "ERRO ao processar dados da API de Profissionais"
    exit 1 
fi
