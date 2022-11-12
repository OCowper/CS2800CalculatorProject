package calculator;

/**
 * An interface defining attributes shared between possible views of the calculator. Adapted from
 * the MVCDemo code.
 *
 * @author zkac355
 *
 */
public interface ViewInterface {
  /**
   * Collects the submitted expression.
   *
   * @return the expression as a string
   */
  public String getExpression();

  /**
   * Sets the calculated answer.
   *
   * @param str the answer which has been calculated
   */
  public void setAnswer(String str);

}
