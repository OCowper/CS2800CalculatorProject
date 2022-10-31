package calculator;

/**
 * An enum defining possible symbols. Very loosely based on the Planet Enums demo
 *
 * @author zkac355
 */
public enum Symbol {
  LEFT_BRACKET("("), RIGHT_BRACKET(")"), TIMES("*"), DIVIDE("/"), PLUS("+"), MINUS("-"), INVALID(
      "INVALID");

  private String character;
  // field containing the particular symbol as an char

  private Symbol(String c) {
    character = c; // gives each enum its associated char
  }

  @Override
  public String toString() {
    return this.character;
  }

}
