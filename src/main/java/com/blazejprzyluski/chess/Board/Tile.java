package com.blazejprzyluski.chess.Board;

import com.blazejprzyluski.chess.Pieces.Piece;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class Tile extends Pane {
    private int positionX;
    private int positionY;
    private boolean isOccupied;
    private Piece p;

    public Tile(int x, int y, Piece p) {
        this.p = p;
        positionX = x;
        positionY = y;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setPiece(Piece p) {
        if (p == null) {
            this.isOccupied = false;
            return;
        } else {
            this.isOccupied = true;
        }
        this.p = p;
        p.setY(this.positionY);
        p.setX(this.getPositionX());
    }

    public Piece getPiece() {
        return this.p;
    }


    public int getPositionX() {
        return positionX;
    }


    public int getPositionY() {
        return positionY;
    }

    //Adds Imageview as a child and sets it's image via url
    public void setImage(String url) {
        if (url == null) {
            this.getChildren().clear();
            return;
        }
        ImageView img = new ImageView(url);
        img.setFitHeight(40);
        img.setFitWidth(40);
        this.getChildren().add(img);
    }
}
