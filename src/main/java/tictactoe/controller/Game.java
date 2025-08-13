package tictactoe.controller;

import java.lang.reflect.Field;
import java.util.Scanner;

import tictactoe.ai.SimpleHeuristic;
import tictactoe.model.Board;

public class Game {

    private Scanner scanner = new Scanner(System.in);
    private Board board;
    private boolean gameOver = false;
    private int moves = 0;

    public void start() {
        board = new Board();
        board.empty();

        System.out.print("Qual jogador deseja ser?(X/O): ");
        char playerChoice = scanner.next().toUpperCase().charAt(0);
        if (playerChoice != Board.PLAYER_X && playerChoice != Board.PLAYER_O) {
            System.out.println("Escolha inválida! Jogando como X por padrão.");
            playerChoice = Board.PLAYER_X;
        }
        board.display();
        char currentPlayer = Board.PLAYER_X;
        SimpleHeuristic heuristic = new SimpleHeuristic();

        while (!gameOver) {
            if (currentPlayer == playerChoice) {
                System.out.println("Sua vez!");
                System.out.print("Linha (1 - 3): ");
                int row = scanner.nextInt() - 1;
                System.out.print("Coluna (1 - 3): ");
                int col = scanner.nextInt() - 1;
                if (board.makeMove(row, col, currentPlayer)) {
                    board.display();
                    moves++;
                    if (isWinner(getFields(), currentPlayer)) {
                        System.out.println((currentPlayer == playerChoice ? "Você ganhou!" : "A máquina ganhou!"));
                        gameOver = true;
                    } else if (moves == 9) {
                        System.out.println("Empate!");
                        gameOver = true;
                    } else {
                        currentPlayer = (currentPlayer == Board.PLAYER_X) ? Board.PLAYER_O : Board.PLAYER_X;
                    }
                } else {
                    System.out.println("Jogada inválida! Tente novamente.");
                }
            } else {
                System.out.println("Vez da máquina...");
                char[][] fields = getFields();
                int[] move = heuristic.getBestMove(fields, currentPlayer, playerChoice);
                if (move != null && board.makeMove(move[0], move[1], currentPlayer)) {
                    System.out.println("Máquina jogou: Linha " + (move[0] + 1) + ", Coluna " + (move[1] + 1));
                    board.display();
                    moves++;
                    if (isWinner(getFields(), currentPlayer)) {
                        System.out.println("A máquina ganhou!");
                        gameOver = true;
                    } else if (moves == 9) {
                        System.out.println("Empate!");
                        gameOver = true;
                    } else {
                        currentPlayer = (currentPlayer == Board.PLAYER_X) ? Board.PLAYER_O : Board.PLAYER_X;
                    }
                }
            }
        }

        scanner.close();
    }

    private char[][] getFields() {
        try {
            Field f = Board.class.getDeclaredField("fields");
            f.setAccessible(true);
            return (char[][]) f.get(board);
        } catch (Exception e) {
            return new char[3][3];
        }
    }

    private boolean isWinner(char[][] fields, char symbol) {
        // Linhas
        for (int i = 0; i < 3; i++) {
            if (fields[i][0] == symbol && fields[i][1] == symbol && fields[i][2] == symbol)
                return true;
        }
        // Colunas
        for (int j = 0; j < 3; j++) {
            if (fields[0][j] == symbol && fields[1][j] == symbol && fields[2][j] == symbol)
                return true;
        }
        // Diagonais
        if (fields[0][0] == symbol && fields[1][1] == symbol && fields[2][2] == symbol)
            return true;
        if (fields[0][2] == symbol && fields[1][1] == symbol && fields[2][0] == symbol)
            return true;
        return false;
    }

    public void restart() {
        System.out.print("Deseja jogar de novo?(S/N): ");
        String resposta = scanner.nextLine();
        if (resposta.equalsIgnoreCase("S")) {
            board.empty();
            gameOver = false;
            moves = 0;
            start();
        } else {
            System.out.println("Obrigado por jogar!");
        }
    }

}