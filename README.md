# 🌦️ APIWeather

API REST desenvolvida com **Java e Spring Boot** para consulta de condições meteorológicas relacionadas a um determinado local e período de tempo.

O projeto recebe informações sobre uma partida ou evento, identifica as coordenadas geográficas do local informado e consulta dados meteorológicos para o intervalo de tempo solicitado.

O objetivo do projeto é praticar e demonstrar conceitos de desenvolvimento Backend, integração com APIs externas, organização em camadas, DTOs, validação de dados e tratamento de informações meteorológicas.

---

## Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Web
- Bean Validation
- Lombok
- REST API
- Integração com API de Geocoding
- Integração com API de previsão meteorológica
- Maven
- Git / GitHub

---

## Arquitetura

O projeto segue uma organização baseada na separação de responsabilidades entre Controller, Services e DTOs.

```text
Cliente
   │
   │ HTTP Request
   ▼
Controller
   │
   ▼
MatchWeatherService
   │
   ├──────────────► GeoCodingService
   │                     │
   │                     ▼
   │                 Localização
   │
   └──────────────► WeatherService
                         │
                         ▼
                 API Meteorológica
                         │
                         ▼
                   Dados do Clima
                         │
                         ▼
                     APIWeather
                         │
                         ▼
                      Cliente
```

### Fluxo da aplicação

1. O cliente envia os dados da partida ou evento.
2. A aplicação valida os dados recebidos.
3. O sistema realiza a geocodificação do local informado.
4. As coordenadas geográficas são utilizadas para consultar a API meteorológica.
5. O intervalo de consulta é definido com base no horário inicial e na duração informada.
6. Os dados meteorológicos são processados pela aplicação.
7. A API retorna as informações para o cliente.

---

## Funcionalidades

- Consulta meteorológica por localização
- Geocodificação de endereços/localizações
- Definição do período de consulta
- Consulta de previsão por intervalo de tempo

---

## Exemplos de Uso

### Endpoint

`POST /api/weather`

### Request

```json
{
  "location": "Campina Grande, PB",
  "startDateTime": "2026-08-03T18:00:00",
  "durationMinutes": 90
}
```
*Os campos e o endpoint podem variar de acordo com a configuração atual da aplicação.*

### Response
A API retorna informações meteorológicas referentes ao período solicitado.  
*Exemplo conceitual:*

```json
{
  "hourly": {
    "time": [
      "2026-08-03T18:00",
      "2026-08-03T19:00"
    ],
    "temperature_2m": [
      25.4,
      24.8
    ],
    "precipitation_probability": [
      10,
      20
    ]
  }
}
```
*Os dados retornados são obtidos a partir da integração com o serviço meteorológico utilizado pela aplicação.*

---

## Estrutura do projeto

```text
src
└── main
    └── java
        └── com.silvaSoftware.ClimaDoJogo
            ├── config
            ├── controller
            ├──exceptions
            ├── service
            │
            └── dto
                ├── dtoRequest
                └── dtoResponse
```
A estrutura busca manter as responsabilidades separadas, facilitando a manutenção e evolução do projeto.

---

## Integrações externas

A aplicação utiliza serviços externos para realizar duas etapas principais:

### Geocoding
Responsável por transformar a localização informada pelo usuário em coordenadas geográficas.  
> `Localização` ➔ `Latitude / Longitude`

### Weather
As coordenadas obtidas são utilizadas para consultar informações meteorológicas para o período solicitado.  
> `Latitude / Longitude` ➔ `Data e horário inicial` ➔ `Duração da partida` ➔ `Previsão meteorológica`

---

## Objetivo do projeto

O APIWeather foi desenvolvido como projeto de estudo e portfólio com foco no desenvolvimento Backend utilizando Java e Spring Boot. O projeto busca aplicar conceitos importantes encontrados no desenvolvimento de aplicações reais, como:

- ✔️ Desenvolvimento de APIs REST
- ✔️ Arquitetura em camadas
- ✔️ Separação de responsabilidades
- ✔️ DTOs
- ✔️ Validação de dados de entrada
- ✔️ Integração com APIs externas
- ✔️ Tratamento de dados de terceiros
- ✔️ Testes automatizados
- ✔️ Boas práticas de desenvolvimento Backend

---

## Como executar o projeto

### Pré-requisitos
Antes de executar a aplicação, certifique-se de possuir:
- Java 21 ou superior
- Maven
- Git

### Passo a Passo

1. **Clone o repositório**
   ```bash
   git clone https://github.com/ErikSilva08/APIWeather.git
   ```

2. **Acesse o projeto**
   ```bash
   cd APIWeather
   ```

3. **Execute a aplicação**
   - **Linux / macOS:**
     ```bash
     ./mvnw spring-boot:run
     ```
   - **Windows:**
     ```bash
     mvnw.cmd spring-boot:run
     ```
   *(Ou execute diretamente pela sua IDE)*

---

## Autor

**Erik Silva**  
Desenvolvedor Backend com foco em Java e Spring Boot.

**Tecnologias e áreas de interesse:**  
`Java` | `Spring Boot` | `REST API` | `JPA` | `Hibernate` | `SQL` | `Git` | `Integração de APIs`
