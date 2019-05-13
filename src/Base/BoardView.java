package Base;

import Base.Board.GameBoard;
import Base.Board.Tile;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class BoardView extends Application {

    // the dimensions of our background Image
    private final int BORDER_WIDTH = 500;
    private final int BORDER_HEIGHT = 483;

    @Override
    public void start(Stage stage) throws Exception {

        // Load your Image
        ImageView backgroundImageView = new ImageView(
                new Image("https://as2.ftcdn.net/jpg/02/12/85/35/500_F_212853537_OIu21bRLIAPjZPtCf04ePyNMA3hjH8JW.jpg"));
        // Initialize the grid
        GridPane boardGrid = initBoard();
        // Set the dimensions of the grid
        boardGrid.setPrefSize(BORDER_WIDTH, BORDER_HEIGHT);

        // Use a StackPane to display the Image and the Grid
        StackPane mainPane = new StackPane();
        mainPane.getChildren().addAll(backgroundImageView, boardGrid);

        stage.setScene(new Scene(mainPane));
        stage.setResizable(false);
        stage.show();

    }

    private GridPane initBoard() {
        GridPane boardGrid = new GridPane();

        int tileNum = 8;
        double tileWidth = BORDER_WIDTH / tileNum;
        double tileHeight = BORDER_HEIGHT / tileNum;
        GameBoard gb = new GameBoard();

        for(Tile t : gb.getTiles())
        {
            t.setFitWidth(tileWidth);
            t.setFitHeight(tileHeight);
            boardGrid.add(t,t.getPositionX(),t.getPositionY());
        }

        // Return the GridPane
        return boardGrid;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
