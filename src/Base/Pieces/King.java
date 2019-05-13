package Base.Pieces;

import Base.Board.GameBoard;
import Base.Board.Tile;

import java.util.ArrayList;

public class King extends Piece
{
    public King(int x, int y, Color color)
    {
        super(x, y, color);
    }

    @Override
    public ArrayList<Move> availableMoves(GameBoard gb)
    {
        int x = this.getX();
        int y = this.getY();
        ArrayList<Move> moves = new ArrayList<>();

        beatCheck(x,y + 1,moves,gb);
        if(y + 1 < 8)
        {
            if(!gb.getTile(x,y + 1).isOccupied())
            {
                moves.add(new Move(x,y + 1));
            }
        }
        beatCheck(x,y - 1,moves,gb);
        if(y - 1 >= 0)
        {
            if(!gb.getTile(x,y - 1).isOccupied())
            {
                moves.add(new Move(x,y - 1));
            }
        }
        beatCheck(x + 1,y,moves,gb);
        if(x + 1 < 8)
        {
            if(!gb.getTile(x + 1,y).isOccupied())
            {
                moves.add(new Move(x + 1,y));
            }
        }
        beatCheck(x -1,y,moves,gb);
        if(x - 1 >= 0)
        {
            if(!gb.getTile(x - 1,y).isOccupied())
            {
                moves.add(new Move(x - 1,y));
            }
        }
        beatCheck(x + 1,y + 1,moves,gb);
        if(x + 1 < 8 && y + 1 < 8)
        {
            if(!gb.getTile(x + 1,y + 1).isOccupied())
            {
                moves.add(new Move(x + 1,y + 1));
            }
        }
        beatCheck(x - 1,y - 1,moves,gb);
        if(x - 1 >= 0 && y - 1 >= 0)
        {
            if(!gb.getTile(x - 1,y - 1).isOccupied())
            {
                moves.add(new Move(x - 1,y - 1));
            }
        }
        beatCheck(x + 1,y - 1,moves,gb);
        if(x + 1 < 8 && y - 1 >= 0)
        {
            if(!gb.getTile(x + 1,y - 1).isOccupied())
            {
                moves.add(new Move(x + 1,y - 1));
            }
        }
        beatCheck(x - 1,y + 1,moves,gb);
        if(x - 1 >= 0 && y + 1 < 8)
        {
            if(!gb.getTile(x - 1,y + 1).isOccupied())
            {
                moves.add(new Move(x - 1,y + 1));
            }
        }

        return moves;
    }

    private void beatCheck(int x, int y,ArrayList<Move> m, GameBoard gb)
    {
        if(x >=0 && x < 8 && y >= 0 && y < 8) {
            if (gb.getTile(x, y).isOccupied() && gb.getTile(x, y).getPiece().getColor() != this.getColor()) {
                m.add(new Beat(x, y));
            }
        }
    }

    @Override
    public String toString()
    {
        return this.getColor() + " KING";
    }

    public static void main(String[] args)
    {
        King k = new King(7,7,Color.WHITE);
        GameBoard gb = new GameBoard();
        Tile t  = gb.getTile(7,7);
        t.setPiece(k);
        ArrayList<Move> moves = k.availableMoves(gb);

        for(Move m : moves)
        {
            System.out.println(m);
        }
    }

}
