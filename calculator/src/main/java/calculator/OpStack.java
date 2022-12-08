package calculator;

/**
 * A facade to define a stack holding only operators.
 *
 * @author zkac355
 */
public class OpStack {

  // the stack instance used by OpStack for stack operations
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
   * Returns and removes the top symbol from the stack. Has to be a symbol as OpStack can only push
   * symbols.
   *
   * @return the value on top of the stack
   */
  public Symbol pop() {
    Symbol opReturn = Symbol.INVALID;
    try {
      opReturn = stackInst.pop().getSymbol();
    } catch (BadTypeException e) {
      e.printStackTrace();
    } // should never throw as opstack only pushes symbols
    return opReturn;
  }

  /**
   * Returns the top stack symbol without removing it. Should never catch as opStack can only ever
   * push symbols.
   *
   * @return the symbol on top of the stack
   */
  public Symbol top() {
    Symbol opReturn = Symbol.INVALID;
    try {
      opReturn = stackInst.top().getSymbol();
    } catch (BadTypeException e) {
      System.out.println("Something's gone very wrong here");
    } // should never happen as opStack can only push symbols.
    return opReturn;
  }

}
