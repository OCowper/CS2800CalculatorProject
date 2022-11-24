package calculator;

/**
 * Defines an interface to template different calculation methods.
 *
 * @author zkac355
 */
public interface CalcFace {
  
  /**
   * Evaluates an answer as a float from a string expression.
   *
   * @param expression the expression to be evaluated
   * @return returns the answer to the expression
   */
  public Float evaluate(String expression);

}