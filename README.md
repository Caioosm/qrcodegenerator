
# Gerador de QR Code

![Java](https://img.shields.io/badge/Java-21-orange)  
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.4-brightgreen)  
![AWS SDK](https://img.shields.io/badge/AWS%20SDK-2.24.12-yellow)  
![Google ZXing](https://img.shields.io/badge/Google%20ZXing-3.5.2-blue)  
![Docker](https://img.shields.io/badge/Docker-✓-blue)  
![Maven](https://img.shields.io/badge/Maven-3.9.6-red)

Uma aplicação Spring Boot que gera códigos QR e os armazena no AWS S3. Este projeto demonstra a integração da biblioteca ZXing do Google para geração de QR Code e o uso do AWS S3 para armazenamento.

## Índice

- [Como Usar](#como-usar)
    - [Pré-requisitos](#pré-requisitos)
    - [Variáveis de Ambiente](#variáveis-de-ambiente)
    - [Executando a Aplicação](#executando-a-aplicação)
        - [Desenvolvimento Local](#desenvolvimento-local)
        - [Implantação com Docker](#implantação-com-docker)
    - [Configuração do AWS S3](#configuração-do-aws-s3)
- [Endpoints da API](#endpoints-da-api)
- [Licença](#licença)

## Como Usar

Esta seção fornece instruções detalhadas para configurar e executar a aplicação Geradora de QR Code.

### Pré-requisitos

- JDK Java 21
- Maven
- Docker
- Conta AWS com acesso ao S3
- AWS CLI configurado com credenciais apropriadas

### Variáveis de Ambiente

Crie um arquivo `.env` na raiz do projeto com as seguintes variáveis:

```env
AWS_ACCESS_KEY_ID=sua_chave_de_acesso
AWS_SECRET_ACCESS_KEY=sua_chave_secreta
AWS_REGION=sua_região
AWS_BUCKET_NAME=nome_do_seu_bucket
```

### Executando a Aplicação

#### Desenvolvimento Local

1. Crie o arquivo `.env` como descrito acima
2. Compile o projeto:
   ```bash
   mvn clean package
   ```
3. Execute a aplicação:
   ```bash
   mvn spring-boot:run
   ```

#### Implantação com Docker

1. Construa a imagem Docker:
   ```bash
   docker build -t qrcode-generator:X.X .
   ```
   > Lembre-se de substituir a versão e o nome da imagem, se desejar.

2. Execute o container:
   ```bash
   docker run --env-file .env -p 8080:8080 qrcode-generator:X.X
   ```

> Lembre-se de substituir o caminho do arquivo `.env` para o local correto que você criou.

### Configuração do AWS S3

1. Crie um bucket S3 na sua conta AWS
2. Atualize o `AWS_BUCKET_NAME` no seu arquivo `.env` ou comando do Docker
3. Verifique se suas credenciais da AWS têm permissões apropriadas para acessar o bucket S3

## Endpoints da API

### POST /qrcode
Gera um código QR a partir do texto fornecido e o armazena no AWS S3. O QR Code será gerado como uma imagem PNG com dimensões de 200x200 pixels.

**Parâmetros**

| Nome  | Obrigatório | Tipo   | Descrição                                                                 |
|-------|-------------|--------|---------------------------------------------------------------------------|
| `text` | sim         | string | O conteúdo de texto a ser codificado no QR Code. Pode ser qualquer string. |

**Resposta**

```json
{
    "url": "https://seu-bucket.s3.sua-região.amazonaws.com/uuid-aleatorio"
}
```

**Resposta de Erro**

Se ocorrer um erro durante a geração do QR Code ou upload no S3, a API retornará um erro 500 (Erro Interno do Servidor).

**Exemplo de Uso**

```bash
curl -X POST http://localhost:8080/qrcode \
     -H "Content-Type: application/json" \
     -d '{"text": "https://example.com"}'
```

## Licença

Este projeto está licenciado sob a Licença MIT – consulte o arquivo LICENSE para mais detalhes.
