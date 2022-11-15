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

  // field containing the instance of view being used
  private CalView view;
  // field describing the current method of calculation
  private boolean isInfix;
  private String expression;

  /**
   * Creates an empty instance of the controller.
   */
  public CalcController() {}

  /**
   * Creates an instance of the controller containing the view, and which calculation method is
   * selected.
   *
   * @param view the current view being used
   * @param isInfix will be true if infix is selected, false is postfix is selected
   */
  public CalcController(CalView view, boolean isInfix) {
    this.view = view;
    this.isInfix = isInfix;
    view.addObserver(this);
  }

  /**
   * Collects the expression currently contained in the text field and returns it into expression
   * field.
   */
  public void getExpression() {
    checkType();
    expression = view.getExpression();
  }

  // collects the type from the view.
  private void checkType() {
    isInfix = view.getType();
  }

  /**
   * Sets the view field answer to the answer that has just been calculated.
   *
   * @param answer the answer to the just submitted expression
   */
  public void setAnswer(String answer) {
    view.setAnswer(answer);
  }


  @Override
  public void update(String expression, boolean calcType) {
    this.expression = expression;
    this.isInfix = calcType;
    calculate();

  }

  private void calculate() {
    String strReturn = "";
    if (isInfix == true) {

      strReturn = (expression + " infix");
    } else {
      strReturn = (expression + " postfix");
    }
    setAnswer(strReturn);
  }

}
