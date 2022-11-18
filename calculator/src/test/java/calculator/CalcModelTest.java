package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testing for the CalcModel class.
 *
 * @author zkac355
 */
public class CalcModelTest {

  private CalcModel testModel;
  private CalcController cont;

  @BeforeEach
  public void setup() {
    cont = new CalcController();
    testModel = new CalcModel(cont);
  }

  @Test // test 1
  void testClass() {
    testModel = new CalcModel(cont);
  } // refactored after test 3 to work with new constructor

  @Test // test 2
  void testCalculateMethod() {
    testModel.evaluate("5 + 6", Notation.POSTFIX);
    assertEquals(testModel.getAnswer(), 11f, "5 + 6 should return 11");
    testModel.evaluate("5 + 6", Notation.POSTFIX);
    assertEquals(testModel.getAnswer(), 11f,
        "the same should be true for postfix or infix");
  } // test later refactored to work with evaluate now a void method.

  @Test // test 3
  void returnAnswer() {
    CalcController cont = new CalcController();
    testModel.addObserver(cont);
    testModel.evaluate("5 + 6", Notation.POSTFIX);
    testModel.notifyObserver(cont);
    assertEquals(cont.getAnswer(), 11f, "evaluating an expression should return to answer");
    testModel.evaluate("5 + 6", Notation.INFIX);
    assertEquals(cont.getAnswer(), 11f, "same should return for infix.");
  } // passed by adding the controller as an observer of the model and refactoring
  
  @Test // test 4. The trigger for work on actual calculation methods
  void returnOther() {
    CalcController cont = new CalcController();
    testModel.addObserver(cont);
    testModel.evaluate("7 * 11", Notation.POSTFIX);
    assertEquals(cont.getAnswer(), 77f, "evaluation a different expression should also work");
  }
  

}
