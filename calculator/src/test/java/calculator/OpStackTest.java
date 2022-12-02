package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testing for the OpStack class.
 *
 * @author zkac355
 */
public class OpStackTest {
  
  OpStack testOpStack;
  
  /**
   * Setup for the testOpStack.
   */
  @BeforeEach
  public void setup() {
    testOpStack = new OpStack();
  }
  
  @Test // test 1
  void testClass() {
    testOpStack = new OpStack();
  }
  
  @Test // test 2
  void testSize() {
    assertEquals(testOpStack.size(), 0, "size should be 0 upon creation");
  }

}
