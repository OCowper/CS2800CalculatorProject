package calculator;

/**
 * A controller for the Calculator. Collects expressions from the view and sends them to the model
 * to be calculated, and then collects and sends on those results. Early framework loosely based off
 * code from the MVC demo, later implementation of Observer from Head First Design Patterns Observer
 * Example.
 *
 * @author zkac355
 */
public class CalcController implements Observer {

  // field containing the instance of model being used.
  private CalcModel model = new CalcModel(this);
  // field containing the instance of view being used. This is instantiated by the launcher.
  private CalView view;
  // field describing the current method of calculation
  private Notation type;
  // field containing the current expression
  private String expression;
  // field containing the current answer.
  private Float answer;

  /**
   * Creates an empty instance of the controller.
   */
  public CalcController() {}

  /**
   * Creates an instance of the controller containing the view, and which calculation method is
   * selected. Adds the view as an observer of this instance of the controller.
   *
   * @param view the current view being used
   * @param type enum containing either Postfix or Infix.
   */
  public CalcController(CalView view, Notation type) {
    this.view = view;
    this.type = type;
    view.addObserver(this); // adds itself as an observer to the view.
  }

  /**
   * Returns the currently stored answer.
   *
   * @return the answer as a float.
   */
  public Float getAnswer() {
    return answer;
  }

  /**
   * Sets the view field answer to the answer that has just been calculated.
   *
   * @param answer the answer to the just submitted expression
   */
  public void returnAnswer(String answer) {
    view.setAnswer(answer); // gives the calculated answer back to view
  }

  /**
   * This version of update is used to collect information from the view, containing the expression
   * and the notation. Will only calculate if a new expression is submitted.
   *
   * @throws InvalidExpressionException if an invalid expression is submitted
   */
  @Override
  public void update(String expression, Notation calcType) {
   
    String curExpression = this.expression;
    this.expression = expression;
    this.type = calcType;
    if (curExpression != expression) { // does not recalculate if only the method has changed
      calculate();
    }
  }

  /**
   * This version of update is used to collect information from the model, containing the calculated
   * answer.
   */
  @Override
  public void update(Float answer) {
    this.answer = answer;
  }

  // calls the model to calculate the answer and then returns it to the view. the answer field is
  // updated by model using observer.
  private void calculate() {
    try {
      model.evaluate(expression, type);
    } catch (InvalidExpressionException e) {
      returnAnswer(e.getMessage());
    }
    returnAnswer(Float.toString(answer));
  }

}
