package calculator;

/**
 * Defines an exception to handle incorrect submitted expressions.
 *
 * @author zkac355
 */
public class InvalidExpressionException extends Exception {

  /**
   * Constructs an empty instance of InvalidExpressionException.
   */
  public InvalidExpressionException() {}
  
  /**
   * Constructs an instance of InvalidExpressionException containing a message.
   *
   * @param message the message to be contained in the exception.
   */
  public InvalidExpressionException(String message) {
    super(message);
  }

  
}
