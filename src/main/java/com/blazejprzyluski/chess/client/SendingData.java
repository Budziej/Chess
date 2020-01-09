package com.blazejprzyluski.chess.client;

import com.blazejprzyluski.chess.Pieces.Move;

public class SendingData {
    private Player player;
    private Move move;

    public SendingData() {
    }

    public SendingData(Player player, Move move) {
        this.player = player;
        this.move = move;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }
}
