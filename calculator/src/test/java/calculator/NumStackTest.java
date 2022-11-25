package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testing for the NumStack facade.
 *
 * @author zkac355
 */
public class NumStackTest {
  
  private NumStack testNumStack;
  
  /**
   * Setup for NumStack testing.
   */
  @BeforeEach
  public void setup() {
    testNumStack = new NumStack();
  }
  
  @Test // test 1
  void testClass() {
    testNumStack = new NumStack();
  }
  
  @Test // test 2
  void testSize() {
    assertEquals(testNumStack.getSize(), 0, "size should be zero upon creation");
  }
  
  @Test // test 3
  void testPush() {
    testNumStack.push(5f);
    assertEquals(testNumStack.getSize(), 1, "size should increment on push");
  }

}
