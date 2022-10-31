package calculator;

/**
 * Defines an exception used to handle incorrectly specified Types of data.
 *
 * @author zkac355
 */
public class BadTypeException extends Exception {

  /**
   * Constructs an empty BadTypeException.
   */
  public BadTypeException() {}

  /**
   * Constructs a BadTypeException containing a message.
   *
   * @param message describes the reason for the exception
   */
  public BadTypeException(String message) {
    super(message);
  }
}
