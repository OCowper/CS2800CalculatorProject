package calculator;

/**
 * The model, for the calculator, which takes expressions passed along to it and sends them for
 * calculation. Loosely based off the MVC demo.
 *
 * @author zkac355
 */
public class CalcModel implements Subject {
  
  private Float answer;
  
  private Observer obs;

  public void evaluate(String expression, boolean infix) {
    answer = 11f; 
  }

  @Override
  public void addObserver(Observer obs) {
    this.obs = obs;
    
  }

  @Override
  public void notifyObserver(Observer obs) {
    obs.update(answer);
    
  }

  public Float getAnswer() {
    return answer;
  }

}
