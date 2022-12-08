package calculator;

/**
 * Defines an interface to template different calculation notations.
 *
 * @author zkac355
 */
public interface CalcFace {
  
  /**
   * Evaluates an answer as a float from a string expression.
   *
   * @param expression the expression to be evaluated
   * @return returns the answer to the expression
   * @throws InvalidExpressionException if the expression is wrong
   */
  public Float evaluate(String expression) throws InvalidExpressionException;

}
