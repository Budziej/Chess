package com.blazejprzyluski.chess.Board;

import com.blazejprzyluski.chess.Pieces.*;
import com.blazejprzyluski.chess.client.Player;

import static com.blazejprzyluski.chess.client.Player.BLACK;
import static com.blazejprzyluski.chess.client.Player.WHITE;

public class GameBoard
{
    //array of tiles
    private Tile[] tiles;

    //setting turn
    private int turn;

    //variables that determine whether white or black king is beaten
    private boolean whiteKing;
    private boolean blackKing;

    private Player activePlayer;

    public GameBoard()
    {
        this.turn = 1;
        this.tiles = new Tile[64];
        //populating tiles array with empty tiles
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                tiles[xyTo1D(i,j)] = new Tile(i,j,null);
            }
        }

        //populating tiles with black and white figures
        populateBlack();
        populateWhite();

        //initially both kings are not beaten
        blackKing = true;
        whiteKing = true;
    }

    public void setWhiteKing(boolean whiteKing)
    {
        this.whiteKing = whiteKing;
    }

    public boolean isBlackKing()
    {
        return blackKing;
    }

    public void setBlackKing(boolean blackKing)
    {
        this.blackKing = blackKing;
    }

    private void populateBlack()
    {
        tiles[0].setPiece(new Rook(0,0,Color.BLACK));
        tiles[0].setImage("https://www.symbols.com/gi.php?type=1&id=3400&i=1");
        tiles[1].setPiece(new Knight(1,0,Color.BLACK));
        tiles[1].setImage("https://www.symbols.com/gi.php?type=1&id=3402&i=1");
        tiles[2].setPiece(new Bishop(2,0,Color.BLACK));
        tiles[2].setImage("https://www.symbols.com/gi.php?type=1&id=3401&i=1");
        tiles[3].setPiece(new King(3,0,Color.BLACK));
        tiles[3].setImage("https://www.symbols.com/gi.php?type=1&id=3398&i=1");
        tiles[4].setPiece(new Queen(4,0,Color.BLACK));
        tiles[4].setImage("https://www.symbols.com/gi.php?type=1&id=3399&i=1");
        tiles[5].setPiece(new Bishop(5,0,Color.BLACK));
        tiles[5].setImage("https://www.symbols.com/gi.php?type=1&id=3401&i=1");
        tiles[6].setPiece(new Knight(6,0,Color.BLACK));
        tiles[6].setImage("https://www.symbols.com/gi.php?type=1&id=3402&i=1");
        tiles[7].setPiece(new Rook(7,0,Color.BLACK));
        tiles[7].setImage("https://www.symbols.com/gi.php?type=1&id=3400&i=1");

        int x = 0;
        for(int i = 8; i <= 15;i++)
        {
            tiles[i].setPiece(new Pawn(x,1,Color.BLACK));
            tiles[i].setImage("https://www.symbols.com/gi.php?type=1&id=3403");
            x++;
        }
    }

    private void populateWhite()
    {
        tiles[56].setPiece(new Rook(0,7,Color.WHITE));
        tiles[56].setImage("https://www.symbols.com/gi.php?type=1&id=3406&i=1");
        tiles[57].setPiece(new Knight(1,7,Color.WHITE));
        tiles[57].setImage("https://www.symbols.com/gi.php?type=1&id=3408&i=1");
        tiles[58].setPiece(new Bishop(2,7,Color.WHITE));
        tiles[58].setImage("https://www.symbols.com/gi.php?type=1&id=3407&i=1");
        tiles[59].setPiece(new King(3,7,Color.WHITE));
        tiles[59].setImage("https://www.symbols.com/gi.php?type=1&id=3404&i=1");
        tiles[60].setPiece(new Queen(4,7,Color.WHITE));
        tiles[60].setImage("https://www.symbols.com/gi.php?type=1&id=3405&i=1");
        tiles[61].setPiece(new Bishop(5,7,Color.WHITE));
        tiles[61].setImage("https://www.symbols.com/gi.php?type=1&id=3407&i=1");
        tiles[62].setPiece(new Knight(6,7,Color.WHITE));
        tiles[62].setImage("https://www.symbols.com/gi.php?type=1&id=3408&i=1");
        tiles[63].setPiece(new Rook(7,7,Color.WHITE));
        tiles[63].setImage("https://www.symbols.com/gi.php?type=1&id=3406&i=1");

        int x = 0;
        for(int i = 48; i <= 55;i++)
        {
            tiles[i].setPiece(new Pawn(x,7,Color.WHITE));

            tiles[i].setImage("https://www.symbols.com/gi.php?type=1&id=3409&i=1");
            x++;
        }
    }

    //changing x and y to 1D coordinate
    private int xyTo1D(int x, int y)
    {
        return y*8 + x;
    }

    public Tile[] getTiles()
    {
        return this.tiles;
    }

    public Tile getTile(int x, int y)
    {
        if(x >=0 && x < 8 && y >= 0 && y < 8)
        {
            return tiles[xyTo1D(x,y)];
        }
        return null;
    }

    public int getTurn()
    {
        return turn;
    }

    public void setTurn(int turn)
    {
        this.turn = turn;
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public void setActivePlayer() {
        if (this.activePlayer == WHITE) {
            this.activePlayer = BLACK;
        } else {
            this.activePlayer = WHITE;
        }
    }
}
