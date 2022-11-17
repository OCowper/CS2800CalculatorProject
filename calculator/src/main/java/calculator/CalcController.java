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

  private CalcModel model = new CalcModel(this);
  // field containing the instance of view being used
  private CalView view;
  // field describing the current method of calculation
  private Notation type;
  private String expression;
  private Float answer;

  /**
   * Creates an empty instance of the controller.
   */
  public CalcController() {}

  /**
   * Creates an instance of the controller containing the view, and which calculation method is
   * selected.
   *
   * @param view the current view being used
   * @param type will be true if infix is selected, false is postfix is selected
   */
  public CalcController(CalView view, Notation type) {
    this.view = view;
    this.type = type;
    view.addObserver(this);
  }

  /**
   * Collects the expression currently contained in the text field and returns it into expression
   * field.
   */
  public void collectExpression() {
    checkType();
    expression = view.getExpression();
  }
  
  /**
   * Returns the currently stored answer.
   *
   * @return the answer as a float.
   */
  public Float getAnswer() {
    return answer;
  }

  // collects the type from the view.
  private void checkType() {
    type = view.getType();
  }

  /**
   * Sets the view field answer to the answer that has just been calculated.
   *
   * @param answer the answer to the just submitted expression
   */
  public void returnAnswer(String answer) {
    view.setAnswer(answer);
  }


  @Override
  public void update(String expression, Notation calcType) {
    this.expression = expression;
    this.type = calcType;
    calculate();

  }
  
  @Override
  public void update(Float answer) {
    this.answer = answer;
  }

  private void calculate() {
    model.evaluate(expression, type);
    returnAnswer(Float.toString(answer));
  }

}
