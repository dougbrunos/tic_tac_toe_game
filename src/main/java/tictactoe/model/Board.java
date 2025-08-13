package tictactoe.model;

public class Board {

    public static final char PLAYER_X = 'X';
    public static final char PLAYER_O = 'O';
    public static final char NONE = ' ';

    private char[][] fields = new char[3][3];

    public Board() {
    }

    public void display() {
        System.out.println("------------");
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[i].length; j++) {
                System.out.print("[" + fields[i][j] + "] ");
            }
            System.out.print("\n");
        }
        System.out.println("------------");
    }

    public void empty() {
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[i].length; j++) {
                fields[i][j] = NONE;
            }
        }
    }

    public boolean makeMove(int row, int col, char symbol) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }
        if (fields[row][col] != NONE) {
            return false;
        }
        fields[row][col] = symbol;
        return true;
    }

}