# Tic Tac Toe Game

Este projeto implementa o jogo da velha (tic-tac-toe) em Java, com opção de jogar contra a máquina (IA simples)

## Como rodar o projeto

1. **Pré-requisitos:**
   - Java 17 ou superior instalado
   - Maven instalado (opcional, para build automatizado)

2. **Compilação:**
   - Pelo terminal, navegue até a pasta do projeto:
     ```
     cd tic_tac_toe_game
     ```
   - Compile usando Maven:
     ```
     mvn clean package
     ```
   - Ou compile manualmente:
     ```
     javac -d target/classes src/main/java/tictactoe/Main.java
     ```

3. **Execução:**
   - Execute o programa:
     ```
     java -cp target/classes tictactoe.Main
     ```

## Como jogar
- Ao iniciar, escolha se quer ser o jogador X ou O.
- Informe a linha e coluna (de 1 a 3) para cada jogada.
- O jogo alterna entre o jogador humano e a máquina.
- O vencedor será anunciado ao final, ou será declarado empate se o tabuleiro ficar cheio.

## Estrutura do projeto
- `src/main/java/tictactoe/` - Código principal
- `src/main/java/tictactoe/model/` - Modelos do jogo (tabuleiro, jogadores)
- `src/main/java/tictactoe/controller/` - Lógica do jogo
- `src/main/java/tictactoe/ai/` - Inteligência artificial simples

## Observações para o professor
- O código está comentado e modularizado para facilitar a leitura.
- A IA utiliza heurística simples para jogar de forma competitiva.

---

## Informações gerais
- Autores(github): dougbrunos e EntonyWittmann
- Repositório: [tic_tac_toe_game](https://github.com/dougbrunos/tic_tac_toe_game)
- Licença: MIT
