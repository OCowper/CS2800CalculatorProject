package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    assertEquals(testCalc.evaluate(testExpresson), 10f, "1 + 9 should return 10");
  }

  @Test // test 4
  void testOtherOp() throws InvalidExpressionException {
    String testExpression = "1 * 9";
    assertEquals(testCalc.evaluate(testExpression), 9f, "1 * 9 should return 9");
  }

  @Test // test 5
  void testNoOp() {
    String testExpression = "5 6";
    assertThrows(InvalidExpressionException.class, () -> testCalc.evaluate(testExpression));
  }

  @Test // test 6
  void testWrongType() {
    String testExpression = "5 6 +";
    assertThrows(InvalidExpressionException.class, () -> testCalc.evaluate(testExpression));
  }

  @Test // test 7
  void testLargeNumbers() throws InvalidExpressionException {
    String testExpression = "100 - 50";
    assertEquals(testCalc.evaluate(testExpression), 50f, "100 - 50 should be 50");
  } // the calculator should be able to handle mutiple digits

  @Test // test 8
  void testSpaceError() throws InvalidExpressionException {
    String testExpression = " 100 +   6  ";
    assertEquals(testCalc.evaluate(testExpression), 106f,
        "extra spaces should not affect the calculator");
  }

  @Test // test 9
  void testMutipleExpressions() throws InvalidExpressionException {
    String testExpression = "100 + 6 + 7";
    assertEquals(testCalc.evaluate(testExpression), 113f,
        "should be able to handle mutiple calculations");
  }

  @Test // test 10
  void testPrecedence() throws InvalidExpressionException {
    String testExpression = "10 + 5 - 4 - 4";
    assertEquals(testCalc.evaluate(testExpression), 7f, "should be able to deal with BODMAS");
    testExpression = "10 + 5 / 5";
    assertEquals(testCalc.evaluate(testExpression), 11f, "should evaluate 5/5 first");
  }
  
  @Test // test 11
  void testBrackets() throws InvalidExpressionException {
    String testExpression = ("(10 + 5) / (3 * 1)");
    assertEquals(testCalc.evaluate(testExpression), 5f, "should be able to handle brackets");
  }

}
