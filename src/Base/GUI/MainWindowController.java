package Base.GUI;

import Base.Board.GameBoard;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class MainWindowController
{
    @FXML
    private ImageView tile1;

    @FXML
    private ImageView tile2;

    @FXML
    private GridPane pane;


    @FXML
    public void initialize()
    {
        test();
        GameBoard gb = new GameBoard();
//        tile1.setOnDragDetected(new EventHandler <MouseEvent>() {
//            public void handle(MouseEvent event) {
//                /* drag was detected, start drag-and-drop gesture*/
//                System.out.println("onDragDetected");
//
//                /* allow any transfer mode */
//                Dragboard db = tile1.startDragAndDrop(TransferMode.ANY);
//
//                /* put a string on dragboard */
//                ClipboardContent content = new ClipboardContent();
//                content.putImage(tile1.getImage());
//                db.setContent(content);
//
//                event.consume();
//            }
//        });
//        tile2.setOnDragOver(new EventHandler <DragEvent>() {
//            public void handle(DragEvent event) {
//                /* data is dragged over the target */
//                System.out.println("onDragOver");
//
//                /* accept it only if it is  not dragged from the same node
//                 * and if it has a string data */
//                if (event.getGestureSource() != tile2) {
//                    /* allow for both copying and moving, whatever user chooses */
//                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
//                }
//
//                event.consume();
//            }
//        });
//
//        tile2.setOnDragEntered(new EventHandler <DragEvent>() {
//            public void handle(DragEvent event) {
//                /* the drag-and-drop gesture entered the target */
//                System.out.println("onDragEntered");
//                /* show to the user that it is an actual gesture target */
//                if (event.getGestureSource() != tile2 &&
//                        event.getDragboard().hasString()) {
//                }
//
//                event.consume();
//            }
//        });
//
//        tile2.setOnDragExited(new EventHandler <DragEvent>() {
//            public void handle(DragEvent event) {
//                /* mouse moved away, remove the graphical cues */
//                System.out.println("Exited");
//
//                event.consume();
//            }
//        });
//
//        tile2.setOnDragDropped(new EventHandler <DragEvent>() {
//            public void handle(DragEvent event) {
//                /* data dropped */
//                System.out.println("onDragDropped");
//                /* if there is a string data on dragboard, read it and use it */
//                Dragboard db = event.getDragboard();
//                boolean success = false;
//                tile2.setImage(db.getImage());
//                success = true;
//
//                /* let the source know whether the string was successfully
//                 * transferred and used */
//                event.setDropCompleted(success);
//
//                event.consume();
//            }
//        });
//
//        tile1.setOnDragDone(new EventHandler <DragEvent>() {
//            public void handle(DragEvent event) {
//                /* the drag-and-drop gesture ended */
//                System.out.println("onDragDone");
//                /* if the data was successfully moved, clear it */
//                if (event.getTransferMode() == TransferMode.MOVE) {
//                    tile2.setImage(tile1.getImage());
//                    tile1.setImage(null);
//                }
//
//                event.consume();
//            }
//        });
    }

    @FXML
    public void dragOver(DragEvent event)
    {
        /* data is dragged over the target */
        System.out.println("onDragOver");

        /* accept it only if it is  not dragged from the same node
         * and if it has a string data */
        if (event.getGestureSource() != tile2 &&
                event.getDragboard().hasString()) {
            /* allow for both copying and moving, whatever user chooses */
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }

        event.consume();
    }

    @FXML
    public void dragEntered(DragEvent event)
    {
        /* the drag-and-drop gesture entered the target */
        System.out.println("onDragEntered");
        /* show to the user that it is an actual gesture target */
        if (event.getGestureSource() != tile2 &&
                event.getDragboard().hasString()) {
        }

        event.consume();
    }

    @FXML
    public void dragExited(DragEvent event)
    {
        /* mouse moved away, remove the graphical cues */

        event.consume();
    }

    @FXML
    public void dragDone(DragEvent event)
    {
        /* the drag-and-drop gesture ended */
        System.out.println("onDragDone");
        /* if the data was successfully moved, clear it */
        event.consume();
    }

    @FXML
    public void dragDropped(DragEvent event)
    {
        /* data dropped */
        System.out.println("onDragDropped");
        /* if there is a string data on dragboard, read it and use it */
        Dragboard db = event.getDragboard();
        boolean success = false;
        if (db.hasString()) {
            success = true;
        }
        tile2.setImage(tile1.getImage());
        /* let the source know whether the string was successfully
         * transferred and used */
        tile1.setImage(null);
        event.setDropCompleted(success);

        event.consume();
    }

    @FXML
    public void testOnDrop(DragEvent event)
    {
        Dragboard fb = event.getDragboard();
        if(fb.hasImage())
        {
            tile2.setImage(fb.getImage());
        }
        event.consume();
        System.out.println("I was dropped into.");
    }

    @FXML
    public void testDragOver(DragEvent event)
    {
        if(event.getGestureSource() != tile2 &&  event.getDragboard().hasImage())
        {
           event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    public void test()
    {
        ImageView img;
        Node n = getNodeFromGridPane(pane,0,0);
        AnchorPane s;
        s = (AnchorPane) n;
        ObservableList<Node> s1 = s.getChildren();
        img = (ImageView) s1.get(0);
        img.getImage();
    }

    @FXML
    public void cos()
    {
        //pane.get
    }

    private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }


}
