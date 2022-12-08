package calculator;

import java.util.EmptyStackException;

/**
 * Evaluates infix expressions as strings and returns the answer as a float.
 *
 * @author zkac355
 */
public class InfixCalc implements CalcFace {

  /**
   * Defines an instance of InfixCalc containing a postfix calculator.
   */
  public InfixCalc() {
    postCalculator = new PostfixCalc();
  }

  // the calculator used to evaluate expressions once converted
  private PostfixCalc postCalculator;
  // the stack used to store operators during conversion
  private OpStack stackInst;

  /**
   * Evaluates an expression given in infix format.
   *
   * @param expression a string containing the expression to be evaluated in infix
   * @return the answer as a float
   * @throws InvalidExpressionException if an invalid expression is recieved
   */

  // shunting yard algorithm writeup found at https://en.wikipedia.org/wiki/Shunting_yard_algorithm
  public Float evaluate(String expression) throws InvalidExpressionException {
    // the currently considered character
    char curChar;
    // used as the output queue - a expression token is added when necessary
    String stringTotal = "";
    // the current operator - if invalid by the end, no operator submitted
    Symbol curOp = Symbol.INVALID;
    // constructs a new stack each time so that old error stacks do not affect subsequent calcs
    stackInst = new OpStack();
    // flag to detect errors
    boolean valid = true;
    // string for error printing
    String errorString = "Invalid Expression - ";

    for (int curPos = 0; curPos < expression.length(); curPos++) {
      curChar = expression.charAt(curPos);

      if (Character.isDigit(curChar)) {
        stringTotal = stringTotal + curChar;
        // appends the character into the output queue

      } else if (curChar == '.') {
        if (curPos == expression.length() - 1) {
          valid = false;
          errorString = errorString + "decimal error";
          // ensures a decimal is not the last character
        } else if (!Character.isDigit(expression.charAt(curPos + 1))) {
          valid = false;
          errorString = errorString + "decimal error";
          // ensures only digits after decimals
          // has to be in a seperate branch
          // or it could do curChar + 1 and be out of bounds
        }
        stringTotal = stringTotal + curChar;

      } else if (Character.isWhitespace(curChar)) {
        stringTotal = stringTotal + " ";
        // whitespace must be sent to queue for postfix calc to work

      } else if (curChar == '(') {
        stackInst.push(strToSymb(curChar));

      } else if (curChar == ')') {
        try {
          while (stackInst.top() != Symbol.LEFT_BRACKET) {
            stringTotal = (stringTotal + " " + stackInst.pop());
          }
          stackInst.pop(); // discards now useless left bracket
        } catch (EmptyStackException e) {
          valid = false;
          errorString = errorString + "Right without Left Bracket";
        }
        // if a right bracket appears there should always be a left
        // bracket on the stack somewhere

      } else if (!Character.isDigit(curChar) && curPos == expression.length() - 1) {
        valid = false;
        errorString = errorString + "Must be in infix";
        // catches expressions ending in an operator

      } else {
        curOp = strToSymb(curChar);
        while (stackInst.getSize() > 0
            && (precedenceCheck(curOp) <= precedenceCheck(stackInst.top()))) {
          stringTotal = (stringTotal + "" + stackInst.pop());
        } // pops onto queue if the operator on stack is higher or equal precedence
        stackInst.push(curOp);
      }
    }

    if (curOp == Symbol.INVALID) {
      valid = false;
      errorString = errorString + "No operator submitted";
    } // if no symbol detected throws

    while (stackInst.getSize() != 0) {
      if (stackInst.top() == Symbol.LEFT_BRACKET) {
        valid = false;
        errorString = errorString + "left without right bracket";
        // if there is still a left bracket left at this point then there is an error
      }
      stringTotal = (stringTotal + " " + stackInst.pop());
    }
    // there should be no left brackets left on stack - as that would mean left without right
    // bracket
    if (valid == false) {
      throw new InvalidExpressionException(errorString);
    }
    return postCalculator.evaluate(stringTotal);
  } // parses the now postfix expression into the postfix calculator

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

  // returns the precedence of an operator. Left Bracket needs to be discarded in favour of any
  // other operator so it is given -1
  private int precedenceCheck(Symbol operand) throws InvalidExpressionException {
    switch (operand) {
      case TIMES:
      case DIVIDE:
        return 1;
      case PLUS:
      case MINUS:
        return 0;
      case LEFT_BRACKET:
        return -1;
      // ensures no popping on a left bracket as per shunting algorithm
      default:
        throw new InvalidExpressionException("Incorrect Operator");
    }

  }
}


