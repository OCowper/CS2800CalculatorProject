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

  @Test // test 4
  void testPop() {
    testNumStack.push(5f);
    assertEquals(testNumStack.pop(), 5f, "pop 5 and then push should be 5");
  }

  @Test // test 5
  void testPushPushPopPop() {
    testNumStack.push(5f);
    testNumStack.push(6f);
    assertEquals(testNumStack.pop(), 6f, "first pop should be 6");
    assertEquals(testNumStack.pop(), 5f, "second pop should be 5");
  } // pop never throws bad type as only numbers are ever pushed by numstack

  @Test // test 6
  void testPushPopSize() {
    testNumStack.push(5f);
    testNumStack.pop();
    assertEquals(testNumStack.getSize(), 0, "push then pop should be 0");
  }
  
  @Test // test 7
  void testTop() {
    testNumStack.push(5f);
    assertEquals(testNumStack.top(), 5f, "top should be 5 after push");
  } // top never throws bad type as only numbers are ever pushed by numstack
  
  @Test // test 8
  void testTopTop() {
    testNumStack.push(5f);
    testNumStack.push(6f);
    assertEquals(testNumStack.top(), 6f, "top of stack should be 6");
    assertEquals(testNumStack.getSize(), 2, "size should still be 2");
    testNumStack.pop();
    assertEquals(testNumStack.top(), 5f, "after a pop top should be 5");
  }

}
