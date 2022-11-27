package calculator;

/**
 * Defines a Subject interface, for a class under observation by an Observer. Loosely based off Head
 * First Design Patterns Observer Example.
 *
 * @author zkac355
 *
 */
public interface Subject {
  /**
   * Adds an object using Observer as a viewer of the subject.
   *
   * @param obs the object to be added
   */
  public void addObserver(Observer obs);


  /**
   * Notify observers of a change in data.
   *
   * @param obs the object to be notified
   *
   * @throws InvalidExpressionException if an incorrect expression has been submitted
   */
  public void notifyObserver(Observer obs) throws InvalidExpressionException;

}
