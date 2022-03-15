package next.step.calculator;

import org.junit.Test;

public class CalculatorTest {
    @Test
    public void add() {
        Calculator cal = new Calculator();
        System.out.println(cal.add(6, 3));
    }
}
