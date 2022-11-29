package calculator;

/**
 * A facade for Stack used for handling only numeric values (in this case floats).
 *
 * @author zkac355
 */
public class NumStack {

  private Stack stackInst;


  /**
   * Constructs an instance of NumStack containing a behavioural stack.
   */
  public NumStack() {
    stackInst = new Stack();
  }


  /**
   * Returns the size of the stack instance.
   *
   * @return The current size of the stack being used.
   */
  public int getSize() {
    return stackInst.getSize();
  }


  /**
   * Stores a float into the instance of stack. Achieved by translating whatever float entered into
   * an instance of Entry.
   *
   * @param f the float to be stored
   */
  public void push(float f) {
    stackInst.push(new Entry(f));
  }


  /**
   * Returns and removes the float value at the top of the stack. Has to be a float - NumStack only
   * ever pushes floats.
   *
   * @return the float on the stack top.
   */
  public float pop() {
    float floatReturn = 0f;
    try {
      floatReturn = stackInst.pop().getValue();
    } catch (BadTypeException e) {
      System.out.println("something's gone very wrong here");
    }
    return floatReturn;

  }


  /**
   * Returns the float at the top of the stack without removing it. Has to be a float - NumStack
   * only ever pushes floats.
   *
   * @return the float on the top of the stack
   */
  public float top() {
    float topReturn = 0f;
    try {
      topReturn = stackInst.top().getValue();
    } catch (BadTypeException e) {
      System.out.println("something's gone very wrong here");
    }
    return topReturn;
  }
}
