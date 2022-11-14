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
public class CalView implements ViewInterface {

  // contains the given expression
  private String expression;
  // contains the answer to be returned
  private String answer = "24.7";
  private boolean infix;

  /**
   * Returns the expression entered by the user in the text field.
   *
   * @return the string currently in the text field
   */
  public String getExpression() {
    return calEntry.getText();
  }

  /**
   * Returns the last calculated answer.
   *
   * @return the last calculation completed.
   */
  public String getAnswer() {
    return answer;
  }

  /**
   * Sets the answer to the given parameter.
   *
   * @param answer the answer answer calculated as a String.
   */
  public void setAnswer(String answer) {
    this.answer = answer;
  }
  
  public boolean getType() {
    return infix;
  }

  @FXML
  // label representing the answer of the calculation. Starts as "______", then changed to the
  // answer when the calculate button is pressed.
  private Label answerLabel;

  @FXML
  // when this button is pressed, the answer is calculated. Labelled with "Calculate"
  private Button calButton;

  @FXML
  // the text field which receives the expression as an input
  private TextField calEntry;

  @FXML
  // a radio button for selecting Infix calculation.
  private RadioButton infixSel;

  @FXML
  // a radio button for selecting Postfix calculation.
  private RadioButton postfixSel;

  @FXML
  // a toggle group containing the two radio buttons - meaning that if one is toggled on the other
  // is toggled off.
  private ToggleGroup fixGroup;


  @FXML
  // triggered when the button is pressed.
  void isPressed(ActionEvent event) {
    expression = getExpression();
    setAnswer(answer);

  }

  @FXML
  // triggered when the Postfix radio button is selected.
  void postIsSelected(ActionEvent event) {
    infix = false;
  }

  @FXML
  // triggered when the Infix radio button is selected.
  void inIsSelected(ActionEvent event) {
    infix = true;
  }



}
