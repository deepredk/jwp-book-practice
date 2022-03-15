package next.step.stringcalc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {
    private StringCalculator strCalculator;

    @Before
    public void setUp() {
        strCalculator = new StringCalculator();
    }

    @Test
    public void 기본_구분자_계산_테스트() {
        assertEquals(8, strCalculator.calculate("1,3,4"));
        assertEquals(8, strCalculator.calculate("1:3:4"));
    }

    @Test
    public void 커스텀_구분자_계산_테스트() {
        assertEquals(8, strCalculator.calculate("\\;\n1;3;4"));
    }

    @Test
    public void 음수_예외발생_테스트() {
        assertThrows(RuntimeException.class, () -> strCalculator.calculate("-11:3:4"));
    }

    @Test
    public void 비었거나_null이라면_0_반환_테스트() {
        assertEquals(0, strCalculator.calculate(""));
        assertEquals(0, strCalculator.calculate("  "));
        assertEquals(0, strCalculator.calculate(null));
    }
}
