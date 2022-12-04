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
    assertEquals(testOpStack.getSize(), 0, "size should be 0 upon creation");
  }

  @Test // test 3
  void testPush() {
    testOpStack.push(Symbol.PLUS);
    assertEquals(testOpStack.getSize(), 1, "size should be 1 after a push");
  }

  @Test // test 4
  void testPop() {
    testOpStack.push(Symbol.MINUS);
    assertEquals(testOpStack.pop(), Symbol.MINUS, "pop should push the top value");
  }

  @Test // test 6
  void testPushPushPopPop() {
    testOpStack.push(Symbol.DIVIDE);
    testOpStack.push(Symbol.TIMES);
    assertEquals(testOpStack.pop(), Symbol.TIMES, "first pop should be times");
    assertEquals(testOpStack.pop(), Symbol.DIVIDE, "second pop should be divide");
  }

  @Test // test 7
  void testPushPopSize() {
    testOpStack.push(Symbol.RIGHT_BRACKET);
    testOpStack.pop();
    assertEquals(testOpStack.getSize(), 0, "push then pop should be size 0");
  }
  
  @Test // test 8
  void testTop() {
    testOpStack.push(Symbol.LEFT_BRACKET);
    assertEquals(testOpStack.top(), Symbol.LEFT_BRACKET, "top should return the top value");
  }
  
  @Test // test 9
  void testTopTop() {
    testOpStack.push(Symbol.PLUS);
    testOpStack.push(Symbol.MINUS);
    assertEquals(testOpStack.top(), Symbol.MINUS, "top of stack is a minus");
    assertEquals(testOpStack.getSize(), 2, "size should not reduce after a top");
    testOpStack.pop();
    assertEquals(testOpStack.top(), Symbol.PLUS, "after a pop the top should by plus");
  }
}
