package Base.Pieces;

import Base.Board.GameBoard;

import java.util.ArrayList;

public class Rook extends Piece
{
    public Rook(int x, int y, Color color)
    {
        super(x, y, color);
    }

    @Override
    public ArrayList<Move> availableMoves(GameBoard gb)
    {
        ArrayList<Move> moves = new ArrayList<>();
        int x = this.getX();
        int y = this.getY();
        for(int i = x  - 1; i >= 0;i--)
        {
            if(!gb.getTile(i,y).isOccupied())
            {
                moves.add(new Move(i,y));
            }
            else if(gb.getTile(i,y).isOccupied() && gb.getTile(i,y).getPiece().getColor() != this.getColor())
            {
                moves.add(new Beat(i,y));
                break;
            }
            else
            {
                break;
            }
        }

        for(int i = x  + 1; i < 8; i++)
        {
            if(!gb.getTile(i,y).isOccupied())
            {
                moves.add(new Move(i,y));
            }
            else if(gb.getTile(i,y).isOccupied() && gb.getTile(i,y).getPiece().getColor() != this.getColor())
            {
                moves.add(new Beat(i,y));
                break;
            }
            else
            {
                break;
            }
        }

        for(int i = y - 1; i >= 0; i--)
        {
            if(!gb.getTile(x,i).isOccupied())
            {
                moves.add(new Move(x,i));
            }
            else if(gb.getTile(x,i).isOccupied() && gb.getTile(x,i).getPiece().getColor() != this.getColor())
            {
                moves.add(new Beat(x,i));
                break;
            }
            else
            {
                break;
            }
        }

        for(int i = y + 1; i < 8; i++)
        {
            if(!gb.getTile(x,i).isOccupied())
            {
                moves.add(new Move(x,i));
            }
            else if(gb.getTile(x,i).isOccupied() && gb.getTile(x,i).getPiece().getColor() != this.getColor())
            {
                moves.add(new Beat(x,i));
                break;
            }
            else
            {
                break;
            }
        }

        return moves;
    }

    @Override
    public String toString()
    {
        return this.getColor() + " ROOK";
    }
}
