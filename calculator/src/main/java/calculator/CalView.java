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
public class CalView implements ViewInterface, Subject {

  // the observer viewing this class
  public Observer obs;
  // contains the given expression
  private String expression;
  // contains the answer to be returned
  private String answer = "24.7";
  // contains true if infix, false if postfix. Must be instatiated with a variable as a calculation
  // cannot occur if empty.
  private Notation type = Notation.POSTFIX;

  /**
   * Returns the expression entered by the user in the text field.
   *
   * @return the string currently in the text field
   */
  public String getExpression() {
    return calEntry.getText();
  }


  /**
   * Sets the answer to the given parameter.
   *
   * @param answer the answer answer calculated as a String.
   */
  public void setAnswer(String answer) {
    this.answer = answer;
    answerLabel.setText(answer);
  }

  /**
   * Returns the currently selected calculation type.
   *
   * @return a boolean containing true if infix, false if postfix.
   */
  public Notation getType() {
    return type;
  }

  @Override
  public void addObserver(Observer obs) {
    this.obs = obs;

  }

  @Override
  public void notifyObserver(Observer obs) {
    obs.update(expression, type);
  }


  ///////////////////////////////////////////////////////////// FXML STARTS HERE

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
    notifyObserver(obs);
    setAnswer(answer);
  }

  @FXML
  // triggered when the Postfix radio button is selected.
  void postIsSelected(ActionEvent event) {
    type = Notation.POSTFIX;
    notifyObserver(obs);
  }

  @FXML
  // triggered when the Infix radio button is selected.
  void inIsSelected(ActionEvent event) {
    type = Notation.INFIX;
    notifyObserver(obs);
  }

}
