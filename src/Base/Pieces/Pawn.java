package Base.Pieces;

import Base.Board.GameBoard;
import Base.Board.Tile;

import java.util.ArrayList;

public class Pawn extends Piece
{
    public Pawn(int x, int y, Color color)
    {
        super(x, y, color);
    }

    @Override
    public ArrayList<Move> availableMoves(GameBoard gb)
    {
        ArrayList<Move> moves = new ArrayList<>();
        int x = this.getX();
        int y = this.getY();
        if(this.getColor() == Color.BLACK)
        {
            checkMovesBlack(x,y,gb,moves);
        }
        else
        {
            checkMovesWhite(x,y,gb,moves);
        }

        return moves;
    }

    private void checkMovesBlack(int x, int y, GameBoard gb, ArrayList<Move> m)
    {
        if(gb.getTurn() == 1)
        {
            m.add(new Move(x,y + 2));
            m.add(new Move(x,y + 1));
        }
        else
        {
            if(y + 1 < 8 && !gb.getTile(x,y + 1).isOccupied())
            {
                m.add(new Move(x,y + 1));
            }
        }
        if(gb.getTile(x + 1,y + 1).isOccupied() && gb.getTile(x + 1, y + 1).getPiece().getColor() != this.getColor())
        {
            m.add(new Beat(x  + 1, y + 1));
        }
        if(gb.getTile(x - 1, y + 1).isOccupied() && gb.getTile(x -1, y + 1).getPiece().getColor() != this.getColor())
        {
            m.add(new Beat(x - 1,y + 1));
        }
    }

    private void checkMovesWhite(int x, int y, GameBoard gb, ArrayList<Move> m)
    {
        if(gb.getTurn() == 1)
        {
            m.add(new Move(x,y - 2));
            m.add(new Move(x,y - 1));
        }
        else
        {
            if(y - 1 < 8 && !gb.getTile(x,y - 1).isOccupied())
            {
                m.add(new Move(x,y - 1));
            }
        }
        if(gb.getTile(x + 1,y - 1).isOccupied() && gb.getTile(x + 1, y - 1).getPiece().getColor() != this.getColor())
        {
            m.add(new Beat(x  + 1, y - 1));
        }
        if(gb.getTile(x - 1, y - 1).isOccupied() && gb.getTile(x - 1, y - 1).getPiece().getColor() != this.getColor())
        {
            m.add(new Beat(x - 1,y - 1));
        }
    }

    @Override
    public String toString()
    {
        return this.getColor() + " PAWN";
    }

    public static void main(String[] args)
    {
        GameBoard gb = new GameBoard();
        Tile t = gb.getTile(1,6);
        Pawn p = new Pawn(1,6,Color.WHITE);
        Pawn p1 = new Pawn(2,5,Color.BLACK);
        t.setPiece(p);
        t = gb.getTile(2,5);
        t.setPiece(p1);
        ArrayList<Move> moves = p.availableMoves(gb);
        for(Move m : moves)
        {
            System.out.println(m);
        }
        gb.beat(p,moves.get(2));
        gb.printPieces();
    }
}
