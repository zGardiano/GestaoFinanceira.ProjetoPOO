# 💰 Sistema de Gestão Financeira Pessoal

Este projeto foi desenvolvido como parte da disciplina **Laboratório de Programação Orientada a Objetos**, e tem como objetivo implementar um sistema simples de controle financeiro pessoal utilizando **Java com interface gráfica (Swing)** e estruturas de dados em memória (sem persistência em banco de dados ou arquivos).

---

## ✅ Estrutura do Projeto

O sistema foi desenvolvido em **três partes**, de modo com que fique mais organizado nas seguintes categorias:

### 1. `Main.java` – Ponto de Entrada
- Responsável por inicializar o sistema e carregar a tela de login.
- Centraliza o fluxo do sistema, chamando os outros módulos conforme necessário.

### 2. Cadastro e Login de Usuários (`CadastroLogin.java`)
- Permite criar usuários com nome e senha.
- Valida login de usuários cadastrados.
- Armazena os dados em memória com uma estrutura `Hashtable`.

### 3. Transações Financeiras (`Transacao.java`)
- Adiciona transações de entrada e saída (receitas e despesas).
- Cada transação contém: descrição, valor, tipo (entrada/saída) e data.
- As transações ficam vinculadas ao usuário logado.

### 4. Histórico e Resumo Financeiro (`TelaPrincipal.java`)
- Mostra a lista de transações realizadas.
- Calcula o saldo total com base nas transações.
- Interface gráfica intuitiva usando componentes básicos do Swing.

---

## 🧍 Observação Importante

> Embora o projeto tenha sido proposto para ser realizado em grupo, tive que desenvolver completamente sozinho devido a circunstâncias específicas deste semestre, em que acabei ficando em uma turma separada dos meus colegas.  


> Para me auxiliar nesse processo, utilizei o ChatGPT como uma ferramenta de apoio para acelerar o desenvolvimento e organizar o código, sempre respeitando o conteúdo aprendido em aula e aplicando meus próprios conhecimentos.


> Peço gentilmente que isso seja levado em consideração no momento da avaliação, pois me dediquei bastante para cumprir todas as etapas com o máximo de capricho, mesmo sem o apoio de um grupo.

---

## 🛠️ Tecnologias Utilizadas

- Java 17
- Swing (GUI)
- Estrutura de dados: Hashtable e ArrayList
