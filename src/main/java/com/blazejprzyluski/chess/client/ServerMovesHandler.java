package com.blazejprzyluski.chess.client;

import com.blazejprzyluski.chess.Board.GameBoard;
import com.blazejprzyluski.chess.Board.Tile;
import com.blazejprzyluski.chess.Pieces.Move;
import javafx.concurrent.Task;
import javafx.scene.image.ImageView;

import static com.blazejprzyluski.chess.GUI.BoardView.movePiece;

public class ServerMovesHandler extends Task<Void> {
    private final Client chessClient;
    private final GameBoard gb;
    private Move moveToMake;
    private ImageView image;

    public ServerMovesHandler(Client chessClient, GameBoard gb) {
        this.chessClient = chessClient;
        this.gb = gb;
    }

    @Override
    protected Void call() throws Exception {
        while (true) {
            try {
                moveToMake = chessClient.getMoveToMake();
                Tile sentTile = gb.getTile(moveToMake.getFrom() % 8, moveToMake.getFrom() / 8);
                image = (ImageView) sentTile.getChildren().get(0);
                System.out.println("In call block");
                break;
            } catch (NullPointerException ex) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException exc) {
                    exc.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    protected void succeeded() {
        super.succeeded();
        System.out.println("Making move");
        movePiece(this.moveToMake, this.image);
        chessClient.setMoveToMake(null);
    }

    @Override
    protected void failed() {
        super.failed();
        System.out.println("Failed to make move");
    }
}
