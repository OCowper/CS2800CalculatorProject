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
    testController = new CalcController();
  }


  @Test // test 1
  void classTest() {
    testController = new CalcController();
  } // passed by creating the controller class

  @Test // test 2
  void testConstruction() {
    CalView testView = new CalView();
    boolean curMethod = true;
    testController = new CalcController(testView, curMethod);
  } // the controller should be instanstiated with the view it is controlling

}
