package calculator;

/**
 * A controller for the Calculator. Collects expressions from the view and sends them to the model
 * to be calculated, and then collects and sends on those results. Loosely based off code from the
 * MVC demo.
 *
 * @author zkac355
 */
public class CalcController {

  // field containing the instance of view being used
  private CalView view;
  // field describing the current method of calculation
  private boolean isInfix;

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
  }

  /**
   * Collects the expression currently contained in the text field and returns it.
   *
   * @return a string representing what has been submitted by the user
   */
  public String getExpression() {
    checkType();
    return view.getExpression();
  }

  /**
   * Sets the view field answer to the answer that has just been calculated.
   *
   * @param answer the answer to the just submitted expression
   */
  public void setAnswer(String answer) {
    view.setAnswer(answer);
  }
  
  private void checkType() {
    isInfix = view.getType();
  }

}
