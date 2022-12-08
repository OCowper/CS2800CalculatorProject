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

  // the factory used to generate calculators when required
  private CalcFactory generator;

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
   * observer, as well as instantiating the factory for selecting calculator types.
   *
   * @param cont the controller to be added as an observer.
   */
  public CalcModel(CalcController cont) {
    addObserver(cont);
    generator = new CalcFactory();
  }

  /**
   * Generates an appropriate calculator and uses it to evaluate the expression, and then updates
   * the controller.
   *
   * @param expression the expression to be calculated as a string
   * @param type an enum containing either postfix or infix
   * @throws InvalidExpressionException if an incorrect expression is submitted
   */
  public void evaluate(String expression, Notation type) throws InvalidExpressionException {
    answer = generator.createCalculator(type).evaluate(expression);
    // receives the correct calculator then evaluates on it
    notifyObserver(obs); // updates the observer with the result
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
