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
  private OpStack stackInst;

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
    Symbol curOp = Symbol.INVALID;
    stackInst = new OpStack();
    for (int curPos = 0; curPos < expression.length(); curPos++) {
      curChar = expression.charAt(curPos);
      if (Character.isDigit(curChar)) {
        stringTotal = stringTotal + curChar;

      } else if (Character.isWhitespace(curChar)) {
        stringTotal = stringTotal + " ";

      } else if (!Character.isDigit(curChar) && curPos == expression.length() - 1) {
        throw new InvalidExpressionException("Must be in infix");
        // catches expressions ending in an operator

      } else {
        curOp = strToSymb(curChar);
        stackInst.push(curOp);

      }
    }

    if (curOp == Symbol.INVALID) {
      throw new InvalidExpressionException("No operator submitted");
    }
    
    while (stackInst.getSize() != 0) {
      stringTotal = (stringTotal + " " + stackInst.pop());
    }
    return postCalculator.evaluate(stringTotal);
  }

  // takes in a char and converts it into one of the possible operators
  private Symbol strToSymb(char strSymbol) {
    switch (strSymbol) {
      case ('+'):
        return Symbol.PLUS;
      case ('-'):
        return Symbol.MINUS;
      case ('*'):
        return Symbol.TIMES;
      case ('/'):
        return Symbol.DIVIDE;
      case ('('):
        return Symbol.LEFT_BRACKET;
      case (')'):
        return Symbol.RIGHT_BRACKET;
      default:
        return Symbol.INVALID;
    }
  }
}


