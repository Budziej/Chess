package Base.Logic;

import Base.Board.GameBoard;
import Base.Pieces.Color;

public class GameLogic
{
    private GameBoard gb;
    private Color turn;
    private boolean whiteWin;
    private boolean blackWin;

    public GameLogic()
    {
        this.gb = new GameBoard();
        this.turn = Color.WHITE;
        this.whiteWin = false;
        this.blackWin = false;
    }
}
