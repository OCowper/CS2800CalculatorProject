package calculator;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testing for the Postfix Calculator Class.
 *
 * @author zkac355
 */
public class PostfixTest {

  private PostfixCalc testCalculator;

  /**
   * Setups variables for the postfix testing.
   */
  @BeforeEach
  public void setup() {
    testCalculator = new PostfixCalc();
  }

  @Test // test 1
  void testClass() {
    testCalculator = new PostfixCalc();
  }

  @Test // test 2
  void testBasicExpression() throws InvalidExpressionException {
    String testExpression = "5 6 +";
    assertEquals(testCalculator.evaluate(testExpression), 11f, "5 6 + should return 11");
  }

  @Test // test 3
  void testAdditionImp() throws InvalidExpressionException {
    String testExpression = "3 7 +";
    assertEquals(testCalculator.evaluate(testExpression), 10f, "3 7 + should return 10");
  } // passed by implementing basic string handling. Only works with addition and single digits so
  // far.

  @Test // test 4
  void testOtherOperator() throws InvalidExpressionException {
    String testExpression = "4 2 -";
    assertEquals(testCalculator.evaluate(testExpression), 2f, "4 2 - should return 2");
    testExpression = "4 3 *";
    assertEquals(testCalculator.evaluate(testExpression), 12f, "4 3 * should return 12");
    testExpression = "8 2 /";
    assertEquals(testCalculator.evaluate(testExpression), 4f, "8 2 / should return 4");
  } // now checks the operator and converts it to the symbol enum, then uses it in calculation.

  @Test // test 5
  void testNoOperand() {
    String testExpression = "4 2";
    assertThrows(InvalidExpressionException.class, () -> testCalculator.evaluate(testExpression),
        "expression without operator should throw");
  }

  @Test // test 6
  void testWrongType() {
    String testExpression = "1 + 2";
    assertThrows(InvalidExpressionException.class, () -> testCalculator.evaluate(testExpression),
        "infix expression should throw");
  } // this test also means that any prefix expressions are thrown

  @Test // test 7
  void testLargeNumers() throws InvalidExpressionException {
    String testExpression = "10 20 *";
    assertEquals(testCalculator.evaluate(testExpression), 200f,
        "calculator should be able to handle mutiple digits");
  }

  @Test // test 8
  void testSpaceError() throws InvalidExpressionException {
    String testExpression = " 3  5   + ";
    assertEquals(testCalculator.evaluate(testExpression), 8f,
        "calculator should be able to deal with doublespacing or spaces at the start or end");
  }

  @Test // test 9
  void testDivide0() {
    String testExpression = "5 0 /";
    assertThrows(InvalidExpressionException.class, () -> testCalculator.evaluate(testExpression),
        "divide by 0 should throw");
  }

  @Test // test 10
  void testLargeExp() throws InvalidExpressionException {
    String testExpression = "5 2 + 3 -";
    assertEquals(testCalculator.evaluate(testExpression), 4f,
        "should be able to handle large expressions");
  }

  @Test // test 11
  void testDecimal() throws InvalidExpressionException {
    String testExpression = "0.1 5 +";
    assertEquals(testCalculator.evaluate(testExpression), 5.1f,
        "should be able to handle decimal numbers");
  }

  @Test // test 12
  void testRepeats() throws InvalidExpressionException {
    String testExpression = "2 3 + 5 +";
    for (int i = 0; i < 100; i++) {
      assertEquals(testCalculator.evaluate(testExpression), 10f,
          "make sure previous calculations do not effect future ones");
    }
  }

  @Test // test 13
  void testLarge() throws InvalidExpressionException {
    String testExpression = "1 ";
    for (int i = 0; i < 100; i++) {
      testExpression = testExpression + "1 + ";
    }
    assertEquals(testCalculator.evaluate(testExpression), 101f, "large expressions should work");
  
  }
}
