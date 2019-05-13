package Base.Board;

import Base.Pieces.*;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GameBoard
{
    private Tile[] tiles;
    private int turn;

    public GameBoard()
    {
        this.turn = 1;
        this.tiles = new Tile[64];
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                tiles[xyTo1D(i,j)] = new Tile(i,j,null);
            }
        }
        populateBlack();
        populateWhite();
    }

    private void populateBlack()
    {
        tiles[0].setPiece(new Rook(0,0,Color.BLACK));
        tiles[0].setImage(new Image("https://www.symbols.com/gi.php?type=1&id=3400&i=1"));
        tiles[1].setPiece(new Knight(1,0,Color.BLACK));
        tiles[1].setImage(new Image("https://www.symbols.com/gi.php?type=1&id=3402&i=1"));
        tiles[2].setPiece(new Bishop(2,0,Color.BLACK));
        tiles[2].setImage(new Image("https://www.symbols.com/gi.php?type=1&id=3401&i=1"));
        tiles[3].setPiece(new King(3,0,Color.BLACK));
        tiles[3].setImage(new Image("https://www.symbols.com/gi.php?type=1&id=3398&i=1"));
        tiles[4].setPiece(new Queen(4,0,Color.BLACK));
        tiles[4].setImage(new Image("https://www.symbols.com/gi.php?type=1&id=3399&i=1"));
        tiles[5].setPiece(new Bishop(5,0,Color.BLACK));
        tiles[5].setImage(new Image("https://www.symbols.com/gi.php?type=1&id=3401&i=1"));
        tiles[6].setPiece(new Knight(6,0,Color.BLACK));
        tiles[6].setImage(new Image("https://www.symbols.com/gi.php?type=1&id=3402&i=1"));
        tiles[7].setPiece(new Rook(7,0,Color.BLACK));
        tiles[7].setImage(new Image("https://www.symbols.com/gi.php?type=1&id=3400&i=1"));
        int x = 0;
        for(int i = 8; i <= 15;i++)
        {
            tiles[i].setPiece(new Pawn(x,1,Color.BLACK));
            tiles[i].setImage(new Image("https://www.symbols.com/gi.php?type=1&id=3403"));
            x++;
        }
    }

    private void populateWhite()
    {
        tiles[56].setPiece(new Rook(0,7,Color.WHITE));
        tiles[56].setImage(new Image("https://www.symbols.com/gi.php?type=1&id=3406&i=1"));
        tiles[57].setPiece(new Knight(1,7,Color.WHITE));
        tiles[57].setImage(new Image("https://www.symbols.com/gi.php?type=1&id=3408&i=1"));
        tiles[58].setPiece(new Bishop(2,7,Color.WHITE));
        tiles[58].setImage(new Image("https://www.symbols.com/gi.php?type=1&id=3407&i=1"));
        tiles[59].setPiece(new King(3,7,Color.WHITE));
        tiles[59].setImage(new Image("https://www.symbols.com/gi.php?type=1&id=3404&i=1"));
        tiles[60].setPiece(new Queen(4,7,Color.WHITE));
        tiles[60].setImage(new Image("https://www.symbols.com/gi.php?type=1&id=3405&i=1"));
        tiles[61].setPiece(new Bishop(5,7,Color.WHITE));
        tiles[61].setImage(new Image("https://www.symbols.com/gi.php?type=1&id=3407&i=1"));
        tiles[62].setPiece(new Knight(6,7,Color.WHITE));
        tiles[62].setImage(new Image("https://www.symbols.com/gi.php?type=1&id=3408&i=1"));
        tiles[63].setPiece(new Rook(7,7,Color.WHITE));
        tiles[63].setImage(new Image("https://www.symbols.com/gi.php?type=1&id=3406&i=1"));

        int x = 0;
        for(int i = 48; i <= 55;i++)
        {
            tiles[i].setPiece(new Pawn(x,7,Color.WHITE));
            Image img = null;
            try {
                img = new Image(new FileInputStream("C:\\Users\\Błażej\\Desktop\\chess\\src\\Base\\GUI\\PiecesImg\\WPAWN.png"));
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
            tiles[i].setImage(img);
            x++;
        }
    }

    private int xyTo1D(int x, int y)
    {
        return y*8 + x;
    }

    public Tile[] getTiles()
    {
        return this.tiles;
    }

    public void setPiece(int x, int y, Piece p)
    {
        Tile t = getTile(x,y);
        t.setPiece(p);
    }

    public void move(Piece p, Move m)
    {
        if(m.getClass() != Beat.class)
        {
            Tile oldTile = this.getTile(p.getX(),p.getY());
            oldTile.setPiece(null);
            Tile newTile = this.getTile(m.getX(),m.getY());
            newTile.setPiece(p);
            p.setX(m.getX());
            p.setY(m.getY());
        }
        else
        {
            beat(p,m);
        }
    }

    public Piece beat(Piece p,Move m)
    {
        Tile oldTile = this.getTile(p.getX(),p.getY());
        oldTile.setPiece(null);
        Tile newTile = this.getTile(m.getX(),m.getY());
        Piece beaten = newTile.getPiece();
        newTile.setPiece(p);
        return beaten;
    }

    public Tile getTile(int x, int y)
    {
        if(x >=0 && x < 8 && y >= 0 && y < 8)
        {
            return tiles[xyTo1D(x,y)];
        }
        return null;
    }

    public void printPieces()
    {
        for(int i = 0; i < 64;i++)
        {
            if(tiles[i].getPiece() != null)
            {
                System.out.println(tiles[i].getPiece());
            }
        }
    }

    public int getTurn()
    {
        return turn;
    }

    public void setTurn(int turn)
    {
        this.turn = turn;
    }
}
