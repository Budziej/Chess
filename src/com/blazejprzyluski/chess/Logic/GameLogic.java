package com.blazejprzyluski.chess.Logic;

import com.blazejprzyluski.chess.Board.GameBoard;
import com.blazejprzyluski.chess.Board.Tile;
import com.blazejprzyluski.chess.Pieces.Color;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.StackPane;

import java.util.Optional;

public class GameLogic
{
    private GameBoard gb;
    private Color turn;
    private Tile[] tiles;

    public GameLogic(GameBoard gb)
    {
        this.gb = gb;
        this.turn = Color.WHITE;
        this.tiles = gb.getTiles();
    }

    public boolean game(StackPane mainPane, boolean blackWin)
    {
        if(blackWin)
        {
            return dialogue(mainPane,"Blacks");
        }else
        {
            return dialogue(mainPane,"Whites");
        }
    }

    //dialogue window that pops up after one side won
    private boolean dialogue(StackPane pane, String winner)
    {
        boolean state = false;

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(pane.getScene().getWindow());
        dialog.setTitle(winner + " Have Won!");
        dialog.setContentText(winner + " have won! Do you want to start a new game? ");
        dialog.getDialogPane().getButtonTypes().add(ButtonType.YES);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.NO);

        Optional<ButtonType> result = dialog.showAndWait();

        if(result.isPresent() && result.get() == ButtonType.YES)
        {
            state = true;
        }

        return state;
    }

}
