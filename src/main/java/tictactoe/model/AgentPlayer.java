package tictactoe.model;

import tictactoe.ai.SimpleHeuristic;

public abstract class AgentPlayer implements Player {

    private char id;
    private SimpleHeuristic simpleHeuristic;

    public char getId() {
        return id;
    }

    public void setId(char id) {
        this.id = id;
    }

    public SimpleHeuristic getSimpleHeuristic() {
        return simpleHeuristic;
    }

    public void setSimpleHeuristic(SimpleHeuristic simpleHeuristic) {
        this.simpleHeuristic = simpleHeuristic;
    }

}