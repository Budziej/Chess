package com.blazejprzyluski.chess.Pieces;

import com.blazejprzyluski.chess.Board.GameBoard;

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


    @Override
    public String toString()
    {
        return this.getColor() + " KNIGHT";
    }

}
