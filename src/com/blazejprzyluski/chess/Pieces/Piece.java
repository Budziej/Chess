package com.blazejprzyluski.chess.Pieces;


import com.blazejprzyluski.chess.Board.GameBoard;

import java.util.ArrayList;

public abstract class Piece
{
    private int x;
    private int y;
    private Color color;

    public Piece(int x, int y, Color color)
    {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public abstract ArrayList<Move> availableMoves(GameBoard gb);

    protected void beatCheck(int x, int y,ArrayList<Move> m, GameBoard gb)
    {
        if(x >=0 && x < 8 && y >= 0 && y < 8) {
            if (gb.getTile(x, y).isOccupied() && gb.getTile(x, y).getPiece().getColor() != this.getColor()) {
                m.add(new Beat(x, y));
            }
        }
    }

    protected void checkDiagonally(int x, int y, GameBoard gb, ArrayList<Move> moves)
    {
        checker(x + 1, y + 1, gb, moves, 1 , 1);
        checker(x + 1, y - 1, gb, moves, 1 , -1);
        checker(x - 1, y + 1, gb, moves, -1 , 1);
        checker(x - 1, y - 1, gb, moves, -1 , -1);
    }

    protected void checkVerticallyHorizontally(int x, int y, GameBoard gb, ArrayList<Move> moves)
    {
        checker(x + 1, y, gb, moves, 1 , 0);
        checker(x - 1, y, gb, moves, -1 , 0);
        checker(x, y + 1, gb, moves, 0 , 1);
        checker(x, y - 1, gb, moves, 0 , -1);
    }

    //checks iteratively whether tiles on the way are occupied and adds moves accordingly
    private void checker(int x, int y, GameBoard gb, ArrayList<Move> moves, int addX, int addY)
    {
        while(true)
        {
            if(x > 7 || y > 7 || x < 0 || y < 0)
                return;
            if(gb.getTile(x,y).isOccupied() && gb.getTile(x,y).getPiece().getColor() == this.getColor())
            {
                return;
            }
            else if(gb.getTile(x,y).isOccupied() && gb.getTile(x,y).getPiece().getColor() != this.getColor())
            {
                moves.add(new Beat(x,y));
                return;
            }
            moves.add(new Move(x,y));
            x += addX;
            y += addY;
        }
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public Color getColor()
    {
        return color;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }

    @Override
    public String toString()
    {
        return this.getColor() + " " + this.getClass().toString();
    }
}
