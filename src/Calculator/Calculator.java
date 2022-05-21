package Calculator;

public class Calculator {
    public static double calculate(int number1, int number2, String operation) {
        if ((number1 > 10 || number1 < 0) || (number2 > 10 || number2 < 0)) {
            throw new IllegalArgumentException("Калькулятор работает только с числами от 0 до 10 либо от I до X");
        }
        double result = 0;
        switch (operation) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                result = number1 / number2;
                break;
            default:
                throw new IllegalArgumentException("Не верный знак операции");
        }
        return result;
    }

}
