package calculator;

/**
 * The model, for the calculator, which takes expressions passed along to it and sends them for
 * calculation. Loosely based off the MVC demo.
 *
 * @author zkac355
 */
public class CalcModel implements Subject {

  // contains the answer once calculated
  private Float answer;

  // the instance of controller observing the model - so that controller can be updated with the
  // calculated answer
  private Observer obs;
  
  // calculator used to evaluate expressions written in postfix. Instantiated in the constructor.
  private PostfixCalc postCalculator;
  
  // calculator used to evaluate expressions written in infix. Instantiated in the constructor.
  private InfixCalc inCalculator;

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
   * observer, as well as instantiating instances of both controller types to be used.
   *
   * @param cont the controller to be added as an observer.
   */
  public CalcModel(CalcController cont) {
    addObserver(cont);
    postCalculator = new PostfixCalc();
    inCalculator = new InfixCalc();
  }

  /**
   * Selects a calculation method and uses it to return a value, which is then put into the answer
   * field.
   *
   * @param expression the expression to be calculated as a string
   * @param type an enum containing either postfix or infix
   * @throws InvalidExpressionException if an incorrect expression is submitted
   */
  public void evaluate(String expression, Notation type) throws InvalidExpressionException {
    if (type == Notation.INFIX) {
      answer = infixCalc(expression);
    } else {
      answer = postfixCalc(expression);
    }
    notifyObserver(obs); // updates the observer with the result
  }

  // calculation with the postfix method - currently faked
  private float postfixCalc(String expression) throws InvalidExpressionException {
    return postCalculator.evaluate(expression);

  }

  // calculation with the infix method - currently faked
  private float infixCalc(String expression) {
    return inCalculator.evaluate(expression);

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
