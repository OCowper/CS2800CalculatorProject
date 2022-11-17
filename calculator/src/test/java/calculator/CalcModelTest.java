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

  @BeforeEach
  public void setup() {
    testModel = new CalcModel();
  }

  @Test // test 1
  void testClass() {
    testModel = new CalcModel();
  }

  @Test // test 2
  void testCalculateMethod() {
    assertEquals(testModel.evaluate("5 + 6", true), 11f, "5 + 6 should return 11");
    assertEquals(testModel.evaluate("5 + 6", false), 11f,
        "the same should be true for postfix or infix");
  }

}
