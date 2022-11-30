package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testing for the infix calculator.
 *
 * @author zkac355
 */
public class InfixTest {

  private InfixCalc testCalc;

  /**
   * Setup for the infix testing class.
   */
  @BeforeEach
  public void setup() {
    testCalc = new InfixCalc();
  }

  @Test // test 1
  void testClass() {
    testCalc = new InfixCalc();
  }

  @Test // test 2
  void testCalculation() throws InvalidExpressionException {
    String testExpression = "5 + 6";
    assertEquals(testCalc.evaluate(testExpression), 11f, "5 + 6 should return 11");
  }
  
  @Test // test 3
  void testOtherAddition() throws InvalidExpressionException {
    String testExpresson = "1 + 9";
    assertEquals(testCalc.evaluate(testExpresson), 10f, "1 + 9 sould return 10");
  }

}
