package calculator;

import org.junit.jupiter.api.Test;

/**
 * Testing for the MockDriver class.
 *
 * @author zkac355
 *
 */
public class MockDriverTest {
  
  private MockDriver driverTest;
  
  @Test // test 1
  void testClass() {
    driverTest = new MockDriver();
  } // passed by creating a mock driver class
  
  // mock driver, as it's function is to run a visual fx window, is tested visually from here on.
}