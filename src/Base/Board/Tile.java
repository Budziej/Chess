package Base.Board;

import Base.Pieces.Piece;
import javafx.scene.image.ImageView;


public class Tile extends ImageView
{
    private int coord;
    private int positionX;
    private int positionY;
    private boolean isOccupied;
    private Piece p;

    public Tile(int x, int y, Piece p) {
        this.p = p;
        positionX = x;
        positionY = y;
        this.coord = x*8 + y;
        setOnMouseClicked(e -> {
            if(this.getPiece() != null)
            {
                System.out.println(this.getPiece().toString());
            }
        });
    }


    public boolean isOccupied()
    {
        return isOccupied;
    }

    public void setOccupied(boolean occupied)
    {
        this.isOccupied = occupied;
    }

    public void setPiece(Piece p)
    {
        if(p ==  null)
        {
            this.isOccupied = false;
        }else
        {
            this.isOccupied = true;
        }
        this.p = p;
    }

    public Piece getPiece()
    {
        return this.p;
    }

    public int getCoord()
    {
        return coord;
    }

    public void setCoord(int coord)
    {
        this.coord = coord;
    }

    public int getPositionX()
    {
        return positionX;
    }

    public void setPositionX(int positionX)
    {
        this.positionX = positionX;
    }

    public int getPositionY()
    {
        return positionY;
    }

    public void setPositionY(int positionY)
    {
        this.positionY = positionY;
    }
}
