package calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * A driver class being used to facilitate the running and testing fx elements. Based on code from
 * the JavaFX demo.
 *
 * @author zkac355
 */
public class MockDriver extends Application {

  /**
   * Initialises the objects used to run JavaFX and creates the starting screen.
   *
   * @param args arguments passed in at the command line
   */
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("CalView.fxml"));
    Scene scene = new Scene(root, 800, 500);
    primaryStage.setScene(scene);
    primaryStage.show();

  }

}
