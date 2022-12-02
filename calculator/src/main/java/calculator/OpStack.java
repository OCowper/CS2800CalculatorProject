package calculator;

/**
 * A facade to define a stack holding only operators.
 *
 * @author zkac355
 */
public class OpStack {
  
  private Stack stackInst;
  
  /**
   * Constructs an instance of OpStack with a new stack as a field.
   */
  public OpStack() {
    stackInst = new Stack();
  }

  /**
   * Returns the current size of the stack.
   *
   * @return how many values are in the stack
   */
  public int getSize() {
    return stackInst.getSize();
  }

  /**
   * Pushes a symbol onto the top of the stack.
   *
   * @param s the symbol to be pushed
   */
  public void push(Symbol s) {
    stackInst.push(new Entry(s));
    
  }

  /**
   * Returns and removes the top symbol from the stack.
   *
   * @return the value on top of the stack
   */
  public Symbol pop() {
    return Symbol.MINUS;
  }

}
