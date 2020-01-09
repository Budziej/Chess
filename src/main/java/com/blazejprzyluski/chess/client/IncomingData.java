package com.blazejprzyluski.chess.client;

import com.blazejprzyluski.chess.Pieces.Move;

public class IncomingData {
    private Move move;
    private Player player;

    public IncomingData() {
    }

    public IncomingData(Move move, Player player) {
        this.move = move;
        this.player = player;
    }

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
