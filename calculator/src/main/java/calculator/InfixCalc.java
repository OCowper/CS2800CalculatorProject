package calculator;

/**
 * Evalutes infix expressions as strings and returns the answer as a float.
 *
 * @author zkac355
 */
public class InfixCalc implements CalcFace {

  /**
   * Defines an instance of InfixCalc.
   */
  public InfixCalc() {
    postCalculator = new PostfixCalc();
  }

  private PostfixCalc postCalculator;

  /**
   * Evaluates an expression given in infix format.
   *
   * @param expression a string containing the expression to be evaluated in infix
   * @return the answer as a float
   * @throws InvalidExpressionException if an invalid expression is recieved
   */
  public Float evaluate(String expression) throws InvalidExpressionException {
    char curChar;
    String stringTotal = "";
    char curOp = 'N';
    for (int curPos = 0; curPos < expression.length(); curPos++) {
      curChar = expression.charAt(curPos);
      if (Character.isDigit(curChar)) {
        stringTotal = stringTotal + curChar + " ";
      } else if (!Character.isWhitespace(curChar) && curPos == expression.length() - 1) {
        throw new InvalidExpressionException("Must be in infix");
        // catches expressions ending in an operator

      } else if (!Character.isWhitespace(curChar)) {
        curOp = curChar;
      }
    }

    if (curOp == 'N') {
      throw new InvalidExpressionException("No operator submitted");
    }
    return postCalculator.evaluate(stringTotal + curOp);
  }
}
