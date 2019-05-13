package Base.Pieces;

import Base.Board.GameBoard;
import Base.Board.Tile;

import java.util.ArrayList;


public class Knight extends Piece
{
    public Knight(int x, int y, Color color)
    {
        super(x, y, color);
    }

    @Override
    public ArrayList<Move> availableMoves(GameBoard gb)
    {
        ArrayList<Move> moves = new ArrayList<>();
        int x = this.getX();
        int y = this.getY();

        beatCheck(x-2,y-1,moves,gb);
        if(x - 2 >= 0 && y - 1 >= 0)
        {
            if(!gb.getTile(x-2,y-1).isOccupied())
                moves.add(new Move(x - 2,y - 1));
        }
        beatCheck(x-2,y+1,moves,gb);
        if(x - 2 >= 0 && y + 1 < 8)
        {
            if(!gb.getTile(x-2,y+1).isOccupied())
                moves.add(new Move(x - 2,y + 1));
        }
        beatCheck(x-1,y+2,moves,gb);
        if(x - 1 >= 0 && y + 2 < 8)
        {
            if(!gb.getTile(x-1,y+2).isOccupied())
                moves.add(new Move(x - 1,y + 2));
        }
        beatCheck(x-1,y-2,moves,gb);
        if(x - 1 >= 0 && y - 2 >= 0)
        {
            if(!gb.getTile(x-1,y-2).isOccupied())
                moves.add(new Move(x -1,y - 2));
        }
        beatCheck(x+2,y-1,moves,gb);
        if(x + 2 < 8 && y - 1 >= 0)
        {
            if(!gb.getTile(x+2,y-1).isOccupied())
                moves.add(new Move(x + 2,y -1));
        }
        beatCheck(x+2,y+1,moves,gb);
        if(x + 2 < 8 && y + 1 < 8)
        {
            if(!gb.getTile(x+2,y+1).isOccupied())
                moves.add(new Move(x + 2,y + 1));
        }
        beatCheck(x+1,y+2,moves,gb);
        if(x + 1 < 8 && y + 2 < 8)
        {
            if(!gb.getTile(x+1,y+2).isOccupied())
                moves.add(new Move(x + 1,y + 2));
        }
        beatCheck(x+1,y-2,moves,gb);
        if(x + 1 < 8 && y - 2 >= 0)
        {
            if(!gb.getTile(x+1,y-2).isOccupied())
                moves.add(new Move(x + 1,y -2));
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
        return this.getColor() + " KNIGHT";
    }

    public static void main(String[] args)
    {
        GameBoard gb = new GameBoard();
        Tile t = gb.getTile(0,0);
        Knight k1 = new Knight(0,0,Color.WHITE);
        t.setPiece(k1);
        t = gb.getTile(1,2);
        Knight k2 =new Knight(1,2,Color.BLACK);
        t.setPiece(k2);
        ArrayList<Move> moves = k2.availableMoves(gb);
        for(Move m : moves)
        {
            System.out.println(m);
        }
        gb.printPieces();
        gb.move(k2,moves.get(1));
        gb.printPieces();
    }
}
