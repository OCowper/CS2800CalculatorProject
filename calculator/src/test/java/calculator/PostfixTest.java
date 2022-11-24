package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testing for the Postfix Calculator Class.
 *
 * @author zkac355
 */
public class PostfixTest {
  
  private PostfixCalc testCalculator;
  
  @BeforeEach
  public void setup() {
    testCalculator = new PostfixCalc();
  }
  
  @Test // test 1
  void testClass() {
    testCalculator = new PostfixCalc();
  }
  
  @Test // test 2
  void testBasicExpression() {
    String testExpression = "5 6 +";
    assertEquals(testCalculator.evaluate(testExpression), 11f, "5 6 + should return 11");
  }
  
  
  

}
