package calculator;

/**
 * Evaluates expressions written in postfix notation.
 *
 * @author zkac355
 */
public class PostfixCalc implements CalcFace {

  /**
   * Defines an instance of PostfixCalc. Adds a NumStack as a field.
   */
  public PostfixCalc() {
    this.numStackInst = new NumStack();
  }

  // the stack used for calculation
  private NumStack numStackInst;

  /**
   * Evaluates an expression given in postfix format.
   *
   * @param expression a string containing the expression to be evaluated in postfix
   * @return the answer as a float
   */
  public Float evaluate(String expression) {
    expression = expression.replaceAll("\\s", ""); // removes all spaces standardizing handling.
    char curChar;
    float leftExpression = 0;
    float rightExpression = 0;
    Symbol operator = Symbol.INVALID;
    for (int curPos = 0; curPos < expression.length(); curPos++) {
      curChar = expression.charAt(curPos);
      if (Character.isDigit(curChar)) {
        numStackInst.push(((float) (curChar)) - 48);
        // java converts numeric chars to their ascii value, so take off 48 to get the actual number
      } else {
        rightExpression = numStackInst.pop();
        leftExpression = numStackInst.pop();
        operator = strToSymb(curChar);
      }
    }
    return arithmetic(leftExpression, rightExpression, operator);
  }

  // takes in a char and converts it into one of the possible operators
  // brackects not required as postfix doesn't use them.
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
      default:
        return Symbol.INVALID;
    }
  }

  // dependent on the operator chooses a sum and returns it.
  private float arithmetic(float leftExpression, float rightExpression, Symbol operator) {
    switch (operator) {
      case PLUS:
        return leftExpression + rightExpression;
      case MINUS:
        return leftExpression - rightExpression;
      case TIMES:
        return leftExpression * rightExpression;
      case DIVIDE:
        return leftExpression / rightExpression;
      default:
        return -1;
    }
  }

}
