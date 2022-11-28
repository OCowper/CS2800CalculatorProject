package calculator;

import java.util.EmptyStackException;

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
   * @throws InvalidExpressionException if the expression is invalid, could be no operator, divide
   *         by 0, wrong order etc.
   */
  public Float evaluate(String expression) throws InvalidExpressionException {
    
    char curChar;
    String fullNumber = "";
    float leftExpression = 0;
    float rightExpression = 0;
    Symbol operator = Symbol.INVALID;
    numStackInst = new NumStack();
    for (int curPos = 0; curPos < expression.length(); curPos++) {

      curChar = expression.charAt(curPos);

      if (curChar == '.' && curPos == expression.length() - 1) {
        throw new InvalidExpressionException("decimal point error");
        // if a decimal point is the last character

      } else if (curChar == '.' && Character.isWhitespace(expression.charAt(curPos + 1))) {
        throw new InvalidExpressionException("decimal point error");
        // if a decimal point then a space

      } else if (Character.isDigit(curChar) || curChar == '.') {
        fullNumber = fullNumber + curChar;
        // upon a space, adds the currently collated multi-digit number

      } else if (Character.isWhitespace(curChar) && fullNumber == "") {
        // if the number total is empty, skips

      } else if (Character.isWhitespace(curChar) && fullNumber != "") {
        numStackInst.push(Float.parseFloat(fullNumber));
        fullNumber = ""; // resets back to empty to receive the next number

      } else { // if character not a number or . or space
        try {
          rightExpression = numStackInst.pop(); // throws if there aren't enough values on stack
          leftExpression = numStackInst.pop();
        } catch (EmptyStackException e) {
          throw new InvalidExpressionException("Invalid Expression - must be postfix");
        }

        operator = strToSymb(curChar);
        if (operator == Symbol.INVALID) { // catches characters not any of the four operators.
          throw new InvalidExpressionException("Invalid Expression - Incorrect operator submitted");
        }

        numStackInst.push(arithmetic(leftExpression, rightExpression, operator));
        // pushes the result onto the stack in case more calculations are to follow
        if (curPos == expression.length() - 1) {
          return numStackInst.pop();
        }
      }
    }

    if (operator == Symbol.INVALID) {
      // checks for expressions without any operator
      throw new InvalidExpressionException("Invalid Expression - No Operator submitted");
    }
    return numStackInst.pop();
  }

  // takes in a char and converts it into one of the possible operators
  // brackets not required as postfix doesn't use them.
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
  private float arithmetic(float leftExpression, float rightExpression, Symbol operator)
      throws InvalidExpressionException {
    switch (operator) {
      case PLUS:
        return leftExpression + rightExpression;
      case MINUS:
        return leftExpression - rightExpression;
      case TIMES:
        return leftExpression * rightExpression;
      case DIVIDE:
        if (rightExpression == 0f) {
          throw new InvalidExpressionException("Divide by 0 Error");
        }
        return leftExpression / rightExpression;
      default:
        return -1; // evaluate always throws if symbol is not one of the four
    }
  }

}
