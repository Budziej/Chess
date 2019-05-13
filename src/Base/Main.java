package Base;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        try
        {
            Image image = new Image(new FileInputStream("C:\\Users\\Błażej\\Desktop\\chess\\src\\Base\\GUI\\PiecesImg\\BROOK.png"));
        }catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

    }
}
