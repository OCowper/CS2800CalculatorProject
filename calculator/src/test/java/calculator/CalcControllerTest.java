package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    boolean curMethod = true;
    testController = new CalcController(testView, curMethod);
  }


  @Test // test 1
  void classTest() {
    testController = new CalcController();
  } // passed by creating the controller class

  @Test // test 2
  void testConstruction() {
    boolean curMethod = true;
    testController = new CalcController(testView, curMethod);
  } // the controller should be instanstiated with the view it is controlling

  @Test // test 3
  void testGetExpression() {
    assertEquals(testController.getExpression(), "5 * 7",
        "getExp should return the expression as a suitable string");
  } // the controller should have a method for collecting the current expression
  // currently faked but later will collect from the view.
  
  @Test // test 4
  void testReturnAnswer() {
    testController.setAnswer("56.8");
    assertEquals(testView.getAnswer(), "56.8", "setting answer to 56.8 should set it in view");
  }

}
