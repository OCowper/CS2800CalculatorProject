package calculator;

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

}
