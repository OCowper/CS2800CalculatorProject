package calculator;

/**
 * An enum defining possible entry types. Very loosely based on code from the Planet Enums demo
 *
 * @author zkac355
 */
public enum Type {
  NUMBER("value"), SYMBOL("operator"), STRING("string"), INVALID("invalid type");

  private String name;

  private Type(String name) {
    this.name = name; // gives each enum its associated name
  }

  @Override
  public String toString() {
    return this.name;
  }

}
