package Base.Pieces;

import Base.Board.GameBoard;
import Base.Board.Tile;

import java.util.ArrayList;

public class Bishop extends Piece
{
    public Bishop(int x, int y, Color color)
    {
        super(x, y, color);
    }

    @Override
    public ArrayList<Move> availableMoves(GameBoard gb)
    {
        ArrayList<Move> moves = new ArrayList<>();
        int x = this.getX();
        int y = this.getY();
        checker(x+1,y+1,gb,moves);
        checker2(x-1,y-1,gb,moves);
        checker3(x-1,y+1,gb,moves);
        checker4(x+1,y-1,gb,moves);
        return moves;
    }
    private int checker(int x, int y,GameBoard gb,ArrayList<Move> moves)
    {
        if(x > 7 || y > 7 || x < 0 || y < 0)
            return 0;
        if(gb.getTile(x,y).isOccupied() && gb.getTile(x,y).getPiece().getColor() == this.getColor())
        {
            return 0;
        }
        else if(gb.getTile(x,y).isOccupied() && gb.getTile(x,y).getPiece().getColor() != this.getColor())
        {
            moves.add(new Beat(x,y));
            return 0;
        }
        moves.add(new Move(x,y));
        return checker(x+1,y+1,gb,moves);
    }

    private int checker2(int x, int y,GameBoard gb, ArrayList<Move> moves)
    {
        if(x > 7 || y > 7 || x < 0 || y < 0)
            return 0;
        if(gb.getTile(x,y).isOccupied() && gb.getTile(x,y).getPiece().getColor() == this.getColor())
        {
            return 0;
        }
        else if(gb.getTile(x,y).isOccupied() && gb.getTile(x,y).getPiece().getColor() != this.getColor())
        {
            moves.add(new Beat(x,y));
            return 0;
        }
        moves.add(new Move(x,y));
        return checker2(x-1,y-1,gb,moves);
    }

    private int checker3(int x, int y,GameBoard gb, ArrayList<Move> moves)
    {
        if(x > 7 || y > 7 || x < 0 || y < 0)
            return 0;
        if(gb.getTile(x,y).isOccupied() && gb.getTile(x,y).getPiece().getColor() == this.getColor())
        {
            return 0;
        }
        else if(gb.getTile(x,y).isOccupied() && gb.getTile(x,y).getPiece().getColor() != this.getColor())
        {
            moves.add(new Beat(x,y));
            return 0;
        }
        moves.add(new Move(x,y));
        return checker3(x-1,y+1,gb,moves);
    }

    private int checker4(int x, int y,GameBoard gb, ArrayList<Move> moves)
    {
        if(x > 7 || y > 7 || x < 0 || y < 0)
            return 0;
        if(gb.getTile(x,y).isOccupied() && gb.getTile(x,y).getPiece().getColor() == this.getColor())
        {
            return 0;
        }
        else if(gb.getTile(x,y).isOccupied() && gb.getTile(x,y).getPiece().getColor() != this.getColor())
        {
            moves.add(new Beat(x,y));
            return 0;
        }
        moves.add(new Move(x,y));
        return checker4(x+1,y-1,gb,moves);
    }

    @Override
    public String toString()
    {
        return this.getColor() + " BISHOP";
    }

    public static void main(String[] args)
    {
        Bishop b1 = new Bishop(0,0,Color.BLACK);
        Bishop b2 = new Bishop(3,3,Color.WHITE);
        GameBoard gb = new GameBoard();
        Tile t = gb.getTile(0,0);
        t.setPiece(b1);
        t = gb.getTile(3,3);
        t.setPiece(b2);
        ArrayList<Move> moves = b2.availableMoves(gb);
        for(Move m : moves)
        {
            System.out.println(m);
        }
    }
}
