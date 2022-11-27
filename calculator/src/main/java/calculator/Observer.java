package calculator;

/**
 * Defines an observer interface to collect data from the views. Loosely based off of Head First
 * Design Patterns Observer Example.
 *
 * @author zkac355
 */
public interface Observer {
  /**
   * Updates the observer with question and type data.
   *
   * @param expression the submitted expression to be calculated
   * @param calcType the selected calculation type. Enum can be Post or Infix
   * 
   * @throws InvalidExpressionException if an incorrect expression is submitted
   */
  public void update(String expression, Notation calcType);

  /**
   * Updates the observer with answer data.
   *
   * @param answer the calculated answer
   */
  public void update(Float answer);
}
