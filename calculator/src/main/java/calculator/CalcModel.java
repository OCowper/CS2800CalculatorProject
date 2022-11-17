package calculator;

/**
 * The model, for the calculator, which takes expressions passed along to it and sends them for
 * calculation. Loosely based off the MVC demo.
 *
 * @author zkac355
 */
public class CalcModel implements Subject {

  private Float answer;

  private Observer obs;

  /**
   * Returns the answer as a float.
   * 
   * @return a float containing the calculated answer
   */
  public Float getAnswer() {
    return answer;
  }

  /**
   * Constructs a new instance of the model. It immediately adds the parsed in controller as an
   * observer.
   *
   * @param cont the controller to be added as an observer.
   */
  public CalcModel(CalcController cont) {
    addObserver(cont);
  }

  /**
   * Selects a calculation method and uses it to return a value, which is then put into the answer
   * field.
   *
   * @param expression the expression to be calculated as a string
   * @param type an enum containing either postfix or infix
   */
  public void evaluate(String expression, Notation type) {
    if (type == Notation.INFIX) {
      answer = infixCalc(expression);
    } else {
      answer = postfixCalc(expression);
    }
    notifyObserver(obs); // updates the observer with the result
  }

  // calculation with the postfix method - currently faked
  private float postfixCalc(String expression) {
    return 11f;

  }

  // calculation with the infix method - currently faked
  private float infixCalc(String expression) {
    return 11f;

  }

  @Override
  public void addObserver(Observer obs) {
    this.obs = obs;

  }

  @Override
  public void notifyObserver(Observer obs) {
    obs.update(answer);

  }

}
