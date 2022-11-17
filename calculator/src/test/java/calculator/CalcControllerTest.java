package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testing for the Calculator Controller class.
 *
 * @author zkac355
 */
public class CalcControllerTest {

  private CalcController testController;
  private CalView testView;

  /**
   * Setups the tests by creating a controller instance before each one.
   */
  @BeforeEach
  public void setup() {
    testView = new CalView();
    Notation curMethod = Notation.POSTFIX;
    testController = new CalcController(testView, curMethod);
  } // refactored to support enum notation rather than boolean


  @Test // test 1
  void classTest() {
    testController = new CalcController();
  } // passed by creating the controller class

  @Test // test 2
  void testConstruction() {
    Notation curMethod = Notation.POSTFIX;
    testController = new CalcController(testView, curMethod);
  } // the controller should be instanstiated with the view it is controlling
  // refactored to support enum notation rather than boolean

}
