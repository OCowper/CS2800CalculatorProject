package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Testing for the Type enum. Test order numbers are unique to each test class. Comments are
 * provided to annotate the points at which I switched between implementing classes. Development
 * starts at test 1 of StackTest.
 *
 * @author zkac355
 */
class TypeTest {

  private Type testType;

  @Test // test 1
  void testToString() {
    testType = Type.NUMBER;
    assertEquals(testType.toString(), "value", "should print number");
    testType = Type.SYMBOL;
    assertEquals(testType.toString(), "operator", "should print operator");
    testType = Type.INVALID;
    assertEquals(testType.toString(), "invalid type", "should print invalid type");
  } // passed by adding a toString to type to print types
  // refactored in cleanup branch to remove string as a possible type

  // after this test I moved to implementing entry

}
