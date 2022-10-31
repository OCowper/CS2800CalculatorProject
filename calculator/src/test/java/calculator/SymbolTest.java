package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Testing for the Symbol enum. Test order numbers are unique to each test class. Comments are
 * provided to annotate the points at which I switched between implementing classes. Development
 * starts at test 1 of StackTest.
 *
 * @author zkac355
 */
class SymbolTest {

  private Symbol testSymbol;

  @Test // test 1
  void toStringTest() {
    testSymbol = Symbol.RIGHT_BRACKET;
    assertEquals(testSymbol.toString(), ")", "should return )");
    testSymbol = Symbol.LEFT_BRACKET;
    assertEquals(testSymbol.toString(), "(", "should return (");
    testSymbol = Symbol.TIMES;
    assertEquals(testSymbol.toString(), "*", "should return *");
    testSymbol = Symbol.DIVIDE;
    assertEquals(testSymbol.toString(), "/", "should return /");
    testSymbol = Symbol.PLUS;
    assertEquals(testSymbol.toString(), "+", "should return +");
    testSymbol = Symbol.MINUS;
    assertEquals(testSymbol.toString(), "-", "should return -");
    testSymbol = Symbol.INVALID;
    assertEquals(testSymbol.toString(), "INVALID", "should return invalid");
  } // passed by adding a toString

  // after this test I moved to implementing Type

}
