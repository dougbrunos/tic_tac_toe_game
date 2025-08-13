package tictactoe.model;

public abstract class HumanPlayer implements Player {

    private char id;

    public HumanPlayer(char id) {
        this.id = id;
    }

    public char getId() {
        return id;
    }

    public void setId(char id) {
        this.id = id;
    }

}
