package calculator;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * Defines a stack. Loosely based off code from the TDD demo.
 *
 * @author zkac355
 */
public class Stack {

  /**
   * Constructs an empty instance of stack.
   */
  public Stack() {}

  private int size = 0; // counts the current size of the stack
  private ArrayList<Entry> entries;
  // holds each value in the stack.
  // Dynamic size (handled in pop and push methods)

  /**
   * Returns the size of the stack.
   *
   * @return returns the size of the stack
   */
  public int getSize() {
    return size;
  }

  /**
   * Pushes a value onto the stack.
   *
   * @param currrent the value to be pushed.
   */
  public void push(Entry currrent) {
    // creates a temporary stack with the new size and places push value at start
    ArrayList<Entry> tempArray = new ArrayList<Entry>();
    tempArray.add(currrent);
    for (int position = 0; position < size; position++) {
      tempArray.add(entries.get(position));
      // moves each item one place higher into the new stack
    }
    entries = tempArray;
    size = size + 1; // pushing increases the size
  }

  /**
   * Returns the top value of the stack.
   *
   * @return returns the most recent push.
   * @throws EmptyStackException thrown if the stack is empty
   */
  public Entry pop() {

    if (size == 0) {
      throw new EmptyStackException();
    }
    size = size - 1; // popping decreases the size
    Entry curPop = entries.get(0);
    // creates a temporary stack without the popped value
    ArrayList<Entry> tempArray = new ArrayList<Entry>();
    for (int position = 0; position < size; position++) {
      tempArray.add(entries.get(position + 1));
      // moves each item one place lower in the new stack
    }
    entries = tempArray;
    return curPop;
  }

  /**
   * Peeks at the top value of the stack without removing it.
   *
   * @return returns the value on top of the stack.
   * @throws EmptyStackException thrown if the stack is empty
   */
  public Entry top() {
    if (size == 0) {
      throw new EmptyStackException();
    }
    return entries.get(0);
  }

  /**
   * Prints a textual representation of the stack.
   *
   * @return returns a string representing the stack
   * @throws EmptyStackException thrown if the stack is empty
   */
  @Override
  public String toString() {
    if (size == 0) {
      throw new EmptyStackException();
    }
    return entries.toString();
  }

}
