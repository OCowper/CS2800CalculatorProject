package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testing for the Entry class. Test order numbers are unique to each test class. Comments are
 * provided to annotate the points at which I switched between implementing classes. Development
 * starts at test 1 of StackTest.
 *
 * @author zkac355
 */
class EntryTest {

  private Entry testEntry;
  private Entry testEntry2;
  private Entry testEntry3;

  @BeforeEach
  public void setup() {
    testEntry = new Entry();
    testEntry2 = new Entry();
    testEntry3 = new Entry();
  }

  @Test // test 1
  void testClass() {
    testEntry = new Entry();
  } // passed by creating an entry class

  @Test // test 2
  void testConstruction() {
    testEntry = new Entry(5.0f);
    testEntry = new Entry(Symbol.TIMES);
  } // passed by creating constructors for constrained types (and empty constructor for test 1)
  // refactored in cleanup branch to remove string as a possible type

  @Test // test 3
  void testGetType() {
    testEntry = new Entry(5.0f);
    assertEquals(testEntry.getType(), Type.NUMBER, "float should have type number");
  } // passed by adding a faked getType method

  @Test // test 4
  void testAllTypes() {
    testEntry = new Entry(Symbol.DIVIDE);
    assertEquals(testEntry.getType(), Type.SYMBOL, "divide should have type symbol");
  } // passed by setting the value of type in each constructor
  // refactored in cleanup branch to remove string as a possible type

  @Test // test 5
  void testGetValues() throws BadTypeException {
    testEntry = new Entry(5.0f);
    assertEquals(testEntry.getValue(), 5.0f, "should return 5 as a float");
    testEntry = new Entry(Symbol.PLUS);
    assertEquals(testEntry.getSymbol(), Symbol.PLUS, "should return a plus sign");
  } // passed by adding a faked getters
  // fakery here was removed much later on (see test 11)
  // this test was refactored after test 6 to throw BadTypeException
  // refactored in cleanup branch to remove string as a possible type

  @Test // test 6
  void testWrongValues() {
    testEntry = new Entry(5.0f);
    assertThrows(BadTypeException.class, () -> testEntry.getSymbol(),
        "getSymbol on a value should throw");
    testEntry = new Entry(Symbol.MINUS);
    assertThrows(BadTypeException.class, () -> testEntry.getValue(),
        "getValue on a symbol should throw");
  } // passed by adding throws in all getters for when the type does not match
  // In order to pass this test I moved to implementing BadTypeException during.
  // refactored in cleanup branch to remove string as a possible type

  @Test // test 7
  void testToString() {
    testEntry = new Entry(5.0f);
    assertEquals(testEntry.toString(), "5.0", "should print 5");
    testEntry = new Entry(Symbol.PLUS);
    assertEquals(testEntry.toString(), "+", "should print plus symbol");
    testEntry = new Entry();
    assertEquals(testEntry.toString(), "invalid", "empty entry should print invalid");
  } // added a case switched toString and removed constructor fakery to actually assign inputs to
  // fields
  // refactored in cleanup branch to remove string as a possible type

  @Test // test 8
  void testEquals() {
    testEntry = new Entry(5.576f);
    testEntry2 = new Entry(5.576f);
    testEntry3 = new Entry(6.0f);
    assertEquals(testEntry, testEntry, "the same entry should be equal");
    assertEquals(testEntry, testEntry2, "two floats of same type with same value should be equal");
    assertFalse(testEntry == testEntry3,
        "two floats of same type with different value should be unequal");
    testEntry = new Entry(Symbol.PLUS);
    testEntry2 = new Entry(Symbol.PLUS);
    testEntry3 = new Entry(Symbol.MINUS);
    assertEquals(testEntry, testEntry2, "two symbols with same value should be equal");
    assertFalse(testEntry == testEntry3, "two symbols with different value should be unequal");
    Entry nullEntry = null;
    Entry nullEntry2 = null;
    assertEquals(nullEntry, nullEntry2, "two invalids should be equal");
  } // passed by adding an equals method with cases for each type
  // refactored in cleanup branch to remove string as a possible type

  @Test // test 9
  void testNotEquals() {
    testEntry = new Entry(5.0f);
    testEntry2 = new Entry(Symbol.PLUS);
    assertFalse(testEntry == testEntry2, "float and symbol should be unequal");
    assertFalse(testEntry2 == testEntry, "symbol and float should be unequal");
    Entry nullEntry = null;
    assertFalse(testEntry == nullEntry, "valid and null data should be unequal");
  } // demonstrates equals also works when comparing different types
  // refactored in cleanup branch to remove string as a possible type

  @Test // test 10
  void testHash() {
    testEntry = new Entry(5.0f);
    testEntry.hashCode();
  } // passed by adding a hashcode method

  @Test // test 11
  void testOtherValues() throws BadTypeException {
    testEntry = new Entry(8.4f);
    testEntry2 = new Entry(Symbol.LEFT_BRACKET);
    assertEquals(testEntry.getValue(), 8.4f, "8.4 should return 8.4");
    assertEquals(testEntry2.getSymbol(), Symbol.LEFT_BRACKET, "( should return (");
  }
  // at this point I realised I never removed the fakery on the getters
  // passed by replacing hard coded getters with getters that actually access the fields
  // refactored in cleanup branch to remove string as a possible type

  // after test 11 I moved back to Stack and refactored to work with Entries
  // This can be seen in test 17 of StackTest

}

