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

  public void evaluate(String expression, boolean infix) {
    if (infix) {
      answer = infixCalc(expression);
    } else {
      answer = postfixCalc(expression);
    }
  }

  private float postfixCalc(String expression) {
    return 11f;

  }

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

  public Float getAnswer() {
    return answer;
  }

}
