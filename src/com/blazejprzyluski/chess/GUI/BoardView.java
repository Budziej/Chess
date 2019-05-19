package com.blazejprzyluski.chess.GUI;

import com.blazejprzyluski.chess.Board.GameBoard;
import com.blazejprzyluski.chess.Board.Tile;
import com.blazejprzyluski.chess.Logic.GameLogic;
import com.blazejprzyluski.chess.Pieces.Color;
import com.blazejprzyluski.chess.Pieces.King;
import com.blazejprzyluski.chess.Pieces.Move;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Optional;

public class BoardView extends Application {
    // the dimensions of our background Image
    private final int BORDER_WIDTH = 320;
    private final int BORDER_HEIGHT = 320;
    private  GameBoard gb = new GameBoard();
    private final StackPane mainPane = new StackPane();
    private final GameLogic gameLogic = new GameLogic(gb);

    @Override
    public void start(Stage stage)
    {
        // Load your Image
        ImageView backgroundImageView = new ImageView(
                new Image("http://www.jinchess.com/chessboard/?p=---------------------------------" +
                        "-------------------------------"));
        // Initialize the grid
        GridPane boardGrid = initBoard();
        // Set the dimensions of the grid
        boardGrid.setPrefSize(BORDER_WIDTH, BORDER_HEIGHT);

        // Use a StackPane to display the Image and the Grid

        mainPane.getChildren().addAll(backgroundImageView, boardGrid);

        stage.setScene(new Scene(mainPane));
        stage.setResizable(false);
        stage.show();
        //Greeting screen
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainPane.getScene().getWindow());
        dialog.setTitle("New Game");
        dialog.setContentText("New game is starting! Whites go first.");
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);

        Optional<ButtonType> result = dialog.showAndWait();
    }

    private GridPane initBoard() {
        GridPane boardGrid = new GridPane();
        double tileNum = 8.0;
        double tileWidth = BORDER_WIDTH / tileNum;
        double tileHeight = BORDER_HEIGHT / tileNum;
        for(Tile t : gb.getTiles())
        {
            t.setPrefSize(tileWidth, tileHeight);
            boardGrid.add(t,t.getPositionX(),t.getPositionY());
        }

        boardGrid.setOnMouseClicked(e ->
        {
            //if the tile isn't empty
            if(e.getTarget().getClass() != Tile.class)
            {
                ImageView img =(ImageView) e.getTarget();
                Tile t = (Tile) img.getParent();
                //if black move
                if(gb.getTurn() % 2 == 0 && t.getPiece().getColor() == Color.BLACK)
                {
                    checkMoves(t,e,img);
                }
                else if(gb.getTurn() % 2 == 1 && t.getPiece().getColor() == Color.WHITE)
                {
                    checkMoves(t,e,img);
                }
            }
        });
        // Return the GridPane
        return boardGrid;
    }
    //function that lets player see the moves and make the move, also checks the win condidtion
    private void checkMoves(Tile t, MouseEvent e, ImageView img)
    {
        for(Tile tile : gb.getTiles())
        {
            tile.setStyle(null);
            tile.setOnMouseClicked(null);
        }
        ArrayList<Move> moves = t.getPiece().availableMoves(gb);
        for(Move m : moves)
        {
            gb.getTile(m.getX(),m.getY()).setStyle("-fx-background-color: #98FB98;");
            gb.getTile(m.getX(),m.getY()).setOnMouseClicked(ev -> {
                if(ev.getTarget().getClass() == Tile.class)
                {
                    movePiece(e,ev,t,img,moves);
                }
                else
                {
                    ImageView img1 = (ImageView) ev.getTarget();
                    Tile t2 = (Tile) img1.getParent();
                    if(t2.isOccupied())
                    {
                        if(t2.getPiece().getClass() == King.class)
                        {
                            gb.setBlackKing(false);
                            if(gameLogic.game(mainPane,gb.isBlackKing()))
                            {
                                cleanUp();
                            }
                            else {
                                Platform.exit();
                            }
                        }
                        t2.setImage(null);
                        t2.setImage(img.getImage().getUrl());
                        t.setImage(null);
                        t2.setPiece(t.getPiece());
                        t.setPiece(null);

                    }
                    else
                    {
                        t2.setImage(null);
                        t2.setImage(img.getImage().getUrl());
                        t.setImage(null);
                        t2.setPiece(t.getPiece());
                        t.setPiece(null);
                    }
                    cleanUpTile(moves);
                    ev.consume();
                    e.consume();
                }
            });
        }
        e.consume();
    }

    //Change piece in destined position and change the image of the tile
    private void movePiece(MouseEvent e, MouseEvent ev, Tile t, ImageView img, ArrayList<Move> moves)
    {
        Tile t1 = (Tile) ev.getTarget();
        t1.setImage(null);
        t1.setImage(img.getImage().getUrl());
        t1.setPiece(t.getPiece());
        t1.getPiece().setX(t1.getPositionX());
        t1.getPiece().setY(t1.getPositionY());
        t.setPiece(null);
        t.setImage(null);
        cleanUpTile(moves);
        ev.consume();
        e.consume();
    }

    //Clear all listeners and style sheets after a move
    private void cleanUpTile(ArrayList<Move> moves)
    {
        for(Move m1 : moves)
        {
            gb.getTile(m1.getX(),m1.getY()).setStyle(null);
            gb.getTile(m1.getX(),m1.getY()).setOnMouseClicked(null);
        }
        gb.setTurn(gb.getTurn() + 1);
    }

    public void cleanUp()
    {
        // Load your Image
        ImageView backgroundImageView = new ImageView(
                new Image("http://www.jinchess.com/chessboard/?p=---------------------------------------" +
                        "-------------------------"));
        // Initialize the grid
        gb = new GameBoard();
        gb.setTurn(0);
        GridPane boardGrid = initBoard();
        // Set the dimensions of the grid
        boardGrid.setPrefSize(BORDER_WIDTH, BORDER_HEIGHT);

        // Use a StackPane to display the Image and the Grid
        mainPane.getChildren().clear();
        mainPane.getChildren().addAll(backgroundImageView,boardGrid);
    }

    public static void main(String[] args) {
        launch(args);
    }
}