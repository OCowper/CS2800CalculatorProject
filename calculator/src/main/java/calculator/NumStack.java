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

}
