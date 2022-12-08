package calculator;

import java.util.Objects;

/**
 * A container class to store different kinds of values.
 *
 * @author zkac355
 */
public class Entry {

  // each instance of entry contains either float, string or symbol, decided on construction
  // all other fields remain empty
  // except type, which is given the type corresponding to the constructor used
  private float number;
  private String str;
  private Symbol other;
  private Type type;

  /**
   * Constructs an instance of Entry containing a float.
   *
   * @param value the float for entry to contain
   */
  public Entry(float value) {
    number = value;
    type = Type.NUMBER;
    // this instance of entry is given type Number
  }

  /**
   * Constructs an instance of Entry containing a Symbol.
   *
   * @param which the Symbol for entry to contain
   */
  public Entry(Symbol which) {
    other = which;
    type = Type.SYMBOL;
    // this instance of entry is given type Symbol
  }

  /**
   * Constructs an empty instance of Entry.
   */
  public Entry() {
    type = Type.INVALID;
    // if entry is constructed to be empty it is considered invalid
  }

  /**
   * Gets the Type contained in an instance of Entry.
   *
   * @return returns the current Type
   */
  public Type getType() {
    return type;
  }

  /**
   * If Entry contains a float, returns that value. Will only function on instance of Entry
   * containing a Float.
   *
   * @return returns a float contained in Entry.
   * @throws BadTypeException throws if called on an instance of entry that is not Type Number
   */
  public Float getValue() throws BadTypeException {
    if (type != Type.NUMBER) {
      throw new BadTypeException("get Value called on non Float value");
    }
    return number;
  }

  /**
   * If Entry contains a Symbol, returns that value. Will only function on instances of Entry
   * containing a Symbol.
   *
   * @return returns a Symbol contained in Entry.
   * @throws BadTypeException throws if called on an instance of Entry that is not Type Symbol
   */
  public Symbol getSymbol() throws BadTypeException {
    if (type != Type.SYMBOL) {
      throw new BadTypeException("getSymbol called on non Symbol Entry");
    }
    return other;
  }

  /**
   * Returns a textual representation of the data stored in Entry. Will return "invalid" if the data
   * has no Type.
   *
   * @return returns text representing what is stored in this instance of Entry
   */
  @Override
  public String toString() {
    // only one field (depending on type) ever contains data, so we only return that field.
    switch (type) {
      case NUMBER:
        return Float.toString(number);
      case SYMBOL:
        return other.toString();
      default:
        return "invalid";
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, other, str, type);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Entry other = (Entry) obj;
    // if this Entry has a certain type, all other fields (except type) are null,
    // hence we only need to compare with the corresponding field in the other Entry
    switch (type) {
      case NUMBER:
        return Float.floatToIntBits(number) == Float.floatToIntBits(other.number);
      case SYMBOL:
        return this.other == other.other;
      default: // case for invalid type
        return other.type == Type.INVALID;
    }
  }
}
