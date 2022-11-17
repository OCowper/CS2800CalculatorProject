package calculator;

/**
 * Defines an observer interface to collect data from the views. Loosely based off of Head First
 * Design Patterns Observer Example.
 *
 * @author zkac355
 */
public interface Observer {
  /**
   * Updates the observer with new data.
   *
   * @param expression the submitted expression to be calculated
   * @param calcType the selected calculation type. True if infix, false if postfix.
   */
  public void update(String expression, boolean calcType);

  public void update(Float answer);
}
