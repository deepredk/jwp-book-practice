package next.step.stringcalc;

public class StringCalculator {
    private final String DEFAULT_DELIMETERS = ",|:";

    public int calculate(String formula) throws RuntimeException{
        String delimiters = DEFAULT_DELIMETERS;
        if (hasCustomDelimeter(formula)) {
            delimiters = extractCustomDelimeter(formula);
            formula = extractFormula(formula);
        }

        String[] numbersInStr = formula.split(delimiters);
        int result = calcSumOfNumbersInStr(numbersInStr);

        return result;
    }

    private int calcSumOfNumbersInStr(String[] numbersInStr) throws RuntimeException {
        int sum = 0;

        for (String numberInStr : numbersInStr) {
            int number = Integer.valueOf(numberInStr);
            if (number < 0) {
                throw new RuntimeException("계산식에 음수는 포함될 수 없습니다");
            }

            sum += number;
        }

        return sum;
    }

    private String extractFormula(String formulaWithCustomDelimeter) {
        return formulaWithCustomDelimeter.split("\n")[1];
    }

    private String extractCustomDelimeter(String formulaWithCustomDelimeter) {
        return formulaWithCustomDelimeter.split("\n")[0].substring(1);
    }

    private boolean hasCustomDelimeter(String formula) {
        return formula.contains("\n");
    }
}
