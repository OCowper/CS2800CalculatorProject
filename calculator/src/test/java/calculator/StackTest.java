package calculator;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Stack testing. Loosely based off code from the TDD demo. Test order numbers are unique to each
 * test class. Comments are provided to annotate the points at which I switched between implementing
 * classes. Development starts at test 1 of StackTest.
 *
 * @author zkac355
 */
class StackTest {


  private Stack testStack;

  @BeforeEach
  public void setup() {
    testStack = new Stack();
  }

  @Test // test 1
  void testClass() {
    testStack = new Stack();
  } // passed by creating a stack class

  @Test // test 2
  void testSize() {
    assertEquals(testStack.size(), 0, "test if the size is 0 on creation");
  } // passed by faking a size method

  @Test // test 3
  void testPush() {
    testStack.push(new Entry(3.0f));
    assertEquals(testStack.size(), 1, "test if size increments on push");
  } // passed by removing faking from size, and incrementing a private size field on push
  // refactored after test 17 to push entry instead of primitive

  @Test // test 4
  void testEmptyPop() {
    assertThrows(EmptyStackException.class, () -> testStack.pop(),
        "pop on an empty stack should throw");
  } // passed by creating a faked pop method with a throw

  @Test // test 5
  void testPushPop() {
    testStack.push(new Entry(3.0f));
    assertEquals(testStack.pop(), new Entry(3.0f), "pushing 3 should pop three");
  } // passed by creating a value field, changing that in push and returning it in pop
  // refactored after test 17 to push entry instead of primitive


  @Test // test 6
  void testDynaSize() {
    testStack.push(new Entry(3.0f));
    testStack.pop();
    assertEquals(testStack.size(), 0, "push then pop on empty stack should mean size 0");
  } // passed by adding a decrement to pop
  // refactored after test 17 to push entry instead of primitive

  @Test // test 7
  void testMultiPush() {
    testStack.push(new Entry(3.0f));
    testStack.push(new Entry(4.0f));
    assertEquals(testStack.pop(), new Entry(4.0f), "first pop should return 4");
  } // passed by changing value to an array
  // refactored after test 17 to push entry instead of primitive

  @Test // test 8
  void testMultiPushSize() {
    testStack.push(new Entry(3.0f));
    testStack.push(new Entry(4.0f));
    assertEquals(testStack.size(), 2, "2 pushes should mean size 2");
  } // already passes - demonstrates size works with multiple values
  // refactored after test 17 to push entry instead of primitive

  @Test // test 9
  void testMultiPushPop() {
    testStack.push(new Entry(3.0f));
    testStack.push(new Entry(4.0f));
    assertEquals(testStack.pop(), new Entry(4.0f), "push 3 then 4 should pop 4");
    assertEquals(testStack.pop(), new Entry(3.0f), "second pop should be 3");
    assertEquals(testStack.size(), 0, "size should be 0 after 2 pop and push");
  } // passed by moving the first value up in the array by 1 when the second is pushed
  // refactored after test 17 to push entry instead of primitive

  @Test // test 10
  void testThreePushPop() {
    testStack.push(new Entry(3.0f));
    testStack.push(new Entry(4.0f));
    testStack.push(new Entry(5.0f));
    assertEquals(testStack.pop(), new Entry(5.0f), "first pop should be 5");
    assertEquals(testStack.pop(), new Entry(4.0f), "second pop should be 4");
    assertEquals(testStack.pop(), new Entry(3.0f), "third pop should be 3");
  } // value moving now occurs for every stack item via a for loop,
  // in order to pass with more than 2 pushes.
  // refactored after test 17 to push entry instead of primitive

  @Test // test 11
  void testTop() {
    testStack.push(new Entry(3.0f));
    assertEquals(testStack.top(), new Entry(3.0f), "top of stack should be 3");
  } // passed by creating a faked top method using pop
  // refactored after test 17 to push entry instead of primitive

  @Test // test 12
  void testTopSize() {
    testStack.push(new Entry(3.0f));
    assertEquals(testStack.top(), new Entry(3.0f), "top of stack should be 3");
    assertEquals(testStack.size(), 1, "size should be 1 - item should remain on stack");
  } // passed by returning the top value instead of popping
  // refactored after test 17 to push entry instead of primitive

  @Test // test 13
  void testEmptyTop() {
    assertThrows(EmptyStackException.class, () -> testStack.top(),
        "top an empty stack should throw");
  } // passed by adding a throw in an if statement if size is 0

  @Test // test 14
  void testLargeStack() {
    for (int i = 0; i < 100; i++) {
      testStack.push(new Entry(10.0f));
    }
  } // fixed by implementing a dynamic stack and using pop and push to change size with tempStacks
  // refactored after test 17 to push entry instead of primitive

  @Test // test 15
  void testToString() {
    testStack.push(new Entry(3.0f));
    testStack.push(new Entry(4.0f));
    testStack.push(new Entry(5.0f));
    assertEquals(testStack.toString(), "[5.0, 4.0, 3.0]");
  } // passed by creating a basic toString method
  // refactored after test 17 to push entry instead of primitive

  @Test // test 16
  void testEmptyToString() {
    assertThrows(EmptyStackException.class, () -> testStack.toString(), "empty stack should throw");
  } // passed by adding an exception within toString

  // after test 16 I moved to implementing Symbol.

  @Test // test 17
  void testWithEntry() {
    Entry testEntry = new Entry(5.0f);
    testStack.push(testEntry);
  } // passed by changing the array to be of Entries rather than floats.

  @Test // test 18
  void testToStringOther() {
    testStack.push(new Entry(3.0f));
    testStack.push(new Entry(Symbol.PLUS));
    testStack.push(new Entry("teststring"));
    assertEquals(testStack.toString(), "[teststring, +, 3.0]");
  } // demonstrates the toString works with different types.

  // after test 18 stack was refactored to use an ArrayList rather than an Array.
  // difficult to show this with tests as the outside interfaces are exactly the same
  // this required some fiddling with pop and push and top to use ArrayList methods
  // rather than array methods - but the logic of the code remains the same
}


