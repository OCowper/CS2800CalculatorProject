package calculator;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * A driver class being used to facilitate the running and testing of fx elements. Based on code
 * from the JavaFX demo. Controller functionality refactor based on MVC demo.
 *
 * @author zkac355
 */
public class Driver extends Application {
  
  /**
   * Constructs an empty instance of Driver.
   */
  public Driver() {}

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
    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("CalcView.fxml"));
    Scene scene = null;
    try {
      scene = new Scene(loader.load(), 800, 500);
    } catch (IOException e) {
      e.printStackTrace();
    }
    new CalcController(loader.getController(), Notation.POSTFIX);
    primaryStage.setScene(scene);
    primaryStage.show();

  }

}
