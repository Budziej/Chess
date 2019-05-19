package com.blazejprzyluski.chess.Pieces;

import com.blazejprzyluski.chess.Board.GameBoard;

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

    @Override
    public String toString()
    {
        return this.getColor() + " KING";
    }
}
