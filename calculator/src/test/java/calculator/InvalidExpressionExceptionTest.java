package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Testing for the invalidExpressionException.
 *
 * @author zkac355
 */
public class InvalidExpressionExceptionTest {

  InvalidExpressionException expressionTest;

  @Test // test 1
  void testClass() {
    expressionTest = new InvalidExpressionException();
  }

  @Test // test 2
  void testConstructors() {
    expressionTest = new InvalidExpressionException();
    expressionTest = new InvalidExpressionException("test message");
    assertEquals(expressionTest.getMessage(), "test message",
        "should contain the string it was constructed with");
  }

}
