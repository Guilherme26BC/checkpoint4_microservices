#!/bin/bash

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
