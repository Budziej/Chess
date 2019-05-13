package Base.Pieces;

import Base.Board.GameBoard;
import Base.Board.Tile;

import java.util.ArrayList;

public class Queen extends Piece
{

    public Queen(int x, int y, Color color)
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
        return this.getColor() +  " QUEEN";
    }


    public static void main(String[] args)
    {
        GameBoard gb = new GameBoard();
        Tile t = gb.getTile(3,3);
        Queen q1 = new Queen(3,3,Color.BLACK);
        t.setPiece(q1);
        t = gb.getTile(4,3);
        Queen q2 = new Queen(4,3,Color.WHITE);
        t.setPiece(q2);
        ArrayList<Move> moves = q1.availableMoves(gb);

//        for(Move m : moves)
//        {
//            System.out.println(m);
//        }
        gb.printPieces();
        gb.move(q2,moves.get(14));
        moves = q2.availableMoves(gb);
        System.out.println("***************************");
        for(Move m : moves)
        {
            System.out.println(m);
        }
        gb.move(q2,moves.get(17));
        gb.printPieces();
    }
}
