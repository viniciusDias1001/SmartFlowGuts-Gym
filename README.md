# 🏋️ SmartFlowGuts Gym

> Sistema inteligente de previsão de demanda para academias  
> *Arquitetura em microserviços com Java (Spring Boot) e Python (Data Analytics)*

---

## 📌 Visão Geral

O **SmartFlowGuts Gym** é um sistema web orientado a dados que auxilia gestores de academias a **prever a lotação por faixa horária**, utilizando dados históricos de check-in e análise estatística.  
O objetivo é reduzir superlotação, otimizar recursos e melhorar a experiência dos alunos por meio de decisões baseadas em dados reais.

---

## ❗ Problema

Academias enfrentam desafios recorrentes como:

- Superlotação em horários de pico
- Ociosidade em períodos específicos
- Falta de previsibilidade do fluxo de alunos
- Decisões operacionais baseadas em intuição

Esses problemas impactam diretamente a satisfação dos alunos e a eficiência operacional da academia.

---

## 💡 Solução Proposta

O SmartFlowGuts Gym coleta e processa dados de presença para:

- Identificar padrões de utilização da academia
- Prever a demanda futura por horário
- Oferecer insights estratégicos ao gestor

As informações são apresentadas em um dashboard simples, claro e orientado à tomada de decisão.

---

## 👥 Público-Alvo

### 🎯 Gestor de Academia

- Necessita prever horários de maior movimento
- Busca melhorar a alocação de profissionais e equipamentos
- Deseja decisões baseadas em dados históricos

---

## 🎯 Objetivo do Projeto

Desenvolver uma solução real e escalável que demonstre:

- Domínio de **Java com Spring Boot**
- Aplicação prática de **arquitetura de microserviços**
- Integração entre **Java e Python**
- Uso de **análise de dados aplicada a problemas reais**

---

## 🧩 Escopo do MVP

### ✅ Funcionalidades Incluídas

- Registro de check-ins
- Histórico de presença
- Processamento de dados históricos
- Previsão de demanda por faixa horária
- Dashboard para visualização de dados

### ❌ Fora do Escopo (versões futuras)

- Aplicativo mobile
- Integração com catracas físicas
- Sistema de pagamentos
- Notificações em tempo real

---

## 🔄 Fluxo de Uso

1. O gestor registra ou importa dados de check-in
2. O sistema armazena os dados históricos
3. O serviço de análise processa os dados
4. O gestor visualiza previsões e padrões no dashboard

---

## 📊 Dados Utilizados

| Dado | Tipo | Origem |
|------|------|--------|
| Data do check-in | Date | Sistema |
| Hora do check-in | Timestamp | Sistema |
| Dia da semana | Categórico | Derivado |
| Unidade da academia | Texto | Sistema |

---

## 🤖 Objetivo Analítico

Prever a quantidade estimada de alunos por faixa horária com base em dados históricos, permitindo antecipar períodos de alta e baixa demanda e apoiar decisões operacionais.

---

## 🏗️ Arquitetura Conceitual

```text
[ Frontend ]
     ↓
[ API - Spring Boot ]
     ↓
[ Serviço de Análise - Python ]
     ↓
[ Modelo de Previsão ]

```
## 🛠️ Tecnologias Utilizadas

### 🔵 Backend (Java)
- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA

### 🟢 Análise de Dados (Python)
- Python
- Pandas
- Scikit-learn
- FastAPI

### ⚙️ Infraestrutura
- PostgreSQL
- Docker
- Docker Compose

---

## 🧪 Dados para Desenvolvimento

Para fins de desenvolvimento e testes, o projeto utiliza:
- Dados sintéticos de check-in
- Simulação de fluxo realista por horário
- Cenários de pico e baixa demanda

---

## 📈 Critérios de Sucesso

- Previsões coerentes com dados históricos
- Dashboard funcional e informativo
- Comunicação eficiente entre microserviços
- Código limpo, organizado e escalável

---

## 🧠 Aprendizados do Projeto

- Design e implementação de microserviços
- Integração entre serviços Java e Python
- Modelagem de dados para análise preditiva
- Aplicação prática de análise de dados em sistemas reais

---

## 🚀 Próximos Passos

- Integração com dados reais de academias
- Evolução do modelo de previsão
- Sistema de recomendações automáticas de horários
- Monitoramento e observabilidade dos serviços

---

## 📄 Licença

Este projeto foi desenvolvido para fins educacionais e de portfólio.

---

## ✨ Autor

**Pedro Vinicius Barros Rocha Dias**  
Desenvolvedor Backend | Java | Spring Boot | Python

