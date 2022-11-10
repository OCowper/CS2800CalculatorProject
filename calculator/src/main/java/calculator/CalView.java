package calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * View class to handle GUI elements and some behaviours. Adapted from the javafx demo.
 *
 * @author zkac355
 */
public class CalView {

  @FXML
  private Label answerLabel;

  @FXML
  private Button calButton;

  @FXML
  private TextField calEntry;

  @FXML
  private RadioButton infixSel;

  @FXML
  private RadioButton postfixSel;
  
  @FXML
  private ToggleGroup fixGroup;

  @FXML
  void isEntered(ActionEvent event) {

  }

  @FXML
  void isPressed(ActionEvent event) {
    answerLabel.setText("24.7");

  }

  @FXML
  void postIsSelected(ActionEvent event) {
  }

  @FXML
  void inIsSelected(ActionEvent event) {
  }

}
