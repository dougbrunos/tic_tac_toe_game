package tictactoe.ai;

public class SimpleHeuristic {

    public int[] getBestMove(char[][] fields, char agentSymbol, char opponentSymbol) {
        // Verifica se pode vencer
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (fields[i][j] == ' ') {
                    fields[i][j] = agentSymbol;
                    if (isWinning(fields, agentSymbol)) {
                        fields[i][j] = ' ';
                        return new int[] { i, j };
                    }
                    fields[i][j] = ' ';
                }
            }
        }
        // Bloqueia oponente
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (fields[i][j] == ' ') {
                    fields[i][j] = opponentSymbol;
                    if (isWinning(fields, opponentSymbol)) {
                        fields[i][j] = ' ';
                        return new int[] { i, j };
                    }
                    fields[i][j] = ' ';
                }
            }
        }
        // Escolhe primeira posição livre
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (fields[i][j] == ' ') {
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }

    private boolean isWinning(char[][] fields, char symbol) {
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

}