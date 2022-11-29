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

    // concatenated whenever an invalid string is detected
    String errorString = "Invalid Expression - ";
    // flag - set to false if an invalid string is detected
    boolean valid = true;
    // keeps track of the current character of the expression being handled
    char curChar;
    // string concatenated with any acceptable numeric to create multi-digit numbers
    String fullNumber = "";
    // stores the number in the LHS
    float leftExpression = 0;
    // stores the number in the RHS
    float rightExpression = 0;
    // stored the operator - if INVALID by the end, no operator has been used
    Symbol operator = Symbol.INVALID;
    // resets the stack at the start of a new calculation
    numStackInst = new NumStack();
    for (int curPos = 0; curPos < expression.length(); curPos++) {

      curChar = expression.charAt(curPos);

      if (curChar == '.' && curPos == expression.length() - 1) {
        valid = false;
        errorString = errorString + "decimal point error ";
        // if a decimal point is the last character sets an error

      } else if (curChar == '.' && !Character.isDigit(expression.charAt(curPos + 1))) {
        valid = false;
        errorString = errorString + "decimal point error ";
        // if a decimal point then anything not a number sets an error

      } else if (Character.isDigit(curChar) || curChar == '.') {
        fullNumber = fullNumber + curChar;
        // concatenates the current digit to a totaller string.


      } else if (Character.isWhitespace(curChar) && fullNumber == "") {
        // if the number total is empty, skips
        fullNumber = "";

      } else if (Character.isWhitespace(curChar) && fullNumber != "") {
        // upon a space, adds the currently collated multi-digit number
        numStackInst.push(Float.parseFloat(fullNumber));
        fullNumber = ""; // resets back to empty to receive the next number

      } else { // if character not a number or . or space
        try {
          rightExpression = numStackInst.pop(); // throws if there aren't enough values on stack
          leftExpression = numStackInst.pop();
        } catch (EmptyStackException e) {
          valid = false;
          errorString = errorString + "Not enough numbers ";
        }

        operator = strToSymb(curChar);
        if (operator == Symbol.INVALID) { // catches characters not any of the four operators.
          valid = false;
          errorString = errorString + "Incorrect operator ";
        }

        numStackInst.push(arithmetic(leftExpression, rightExpression, operator));
        // pushes the result onto the stack in case more calculations are to follow
        if (curPos == expression.length() - 1) {
          if (valid) {
            return numStackInst.pop();
          } else {
            throw new InvalidExpressionException(errorString); // if an error has ever been detected
          }
        }
      }
    }

    if (operator == Symbol.INVALID) {
      // checks for expressions without any operator
      valid = false;
      errorString = errorString + "No Operator submitted ";
    }
    if (valid) {
      return numStackInst.pop();
    } else {
      throw new InvalidExpressionException(errorString);
    }
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
        } // divide by 0 expressions are thrown.
        return leftExpression / rightExpression;
      default:
        return -1; // evaluate always throws if symbol is not one of the four so this shouldn't
                   // happen.
    }
  }

}
