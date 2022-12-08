package calculator;

/**
 * A factory used to generate instances of calculators to be used in expression evaluation.
 *
 * @author zkac355
 */
public class CalcFactory {

  // the calculator used for postfix calculations
  private CalcFace postCalc = new PostfixCalc();
  // the calculator used for infix calculations
  private CalcFace inCalc = new InfixCalc();

  /**
   * Constructs a new instance of the calculator factory. 
   */
  public CalcFactory() {}

  /**
   * Creates a type of calculator based on which notation was submitted.
   *
   * @param type the type of expression. Either postfix or infix
   * @return the calculator to be used
   */
  public CalcFace createCalculator(Notation type) {
    if (type == Notation.POSTFIX) {
      return postCalc;
    } else {
      return inCalc;
    }
  }

}
