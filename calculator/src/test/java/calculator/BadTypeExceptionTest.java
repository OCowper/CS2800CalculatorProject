package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * BadTypeException testing. Test order numbers are unique to each test class. Comments are provided
 * to annotate the points at which I switched between implementing classes. Development starts at
 * test 1 of StackTest.
 *
 * @author zkac355
 */
class BadTypeExceptionTest {

  BadTypeException testException;

  @Test // test 1
  void testClass() {
    testException = new BadTypeException();
  } // passed by creating the exception class

  @Test // test 2
  void testConstructors() {
    testException = new BadTypeException();
    testException = new BadTypeException("teststring");
    assertEquals(testException.getMessage(), "teststring", "message should be teststring");
  } // passed by adding 2 constructors

}
