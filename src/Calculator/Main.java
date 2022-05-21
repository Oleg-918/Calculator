package Calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Добро пожаловать в Калькулятор 1.1, он работает только с арабскими и римскими (\"I\",\"V\",\"X\") цифрами от 1 до 10\n" +
                "Обладает довольно скудным фукционалом и может предложить только следующие операции:\n" +
                "Сложение(+), Вычитание(-), Умножение(*), Деление(/)\n" +
                "Если Вы хотите покинуть программу, введите 'exit'\n" +
                "Введите два числа,разделяя каждый символ пробелом (Пример: \"2 + 4\"): ");

        Scanner in = new Scanner(System.in);
        //Цикл для предотвращения закрыти консоли
        boolean isExit = false;
        while (!isExit) {
            //Получаем строку с консоли. Разделяем по пробелу
            String inputString = in.nextLine();
            String[] splitInputString = inputString.split(" ");
            if (splitInputString.length != 3) {
                throw new IllegalArgumentException("Неверный формат данных");
            }
            int number1 = 0;
            int number2 = 0;

            boolean key;
            //Преобразуем Арабские и Римские числа из строки в Int тип
            try {
                number1 = Integer.parseInt(splitInputString[0]);
                number2 = Integer.parseInt(splitInputString[2]);
                key = false;
            } catch (NumberFormatException e) {
                number1 = NumberService.romanToArabic(splitInputString[0]);
                number2 = NumberService.romanToArabic(splitInputString[2]);
                key = true;
            }
            //Получаем знак операции из строки
            String operation = splitInputString[1];

            //Считаем операцию с помощбю класса Test_1.Calculator
            double result_arabic = Calculator.calculate(number1, number2, operation);

            //В зависимости от значения key выводим результат
            if (key) {
                String result_roman = NumberConvertManager.transform_number_to_roman_numeral(result_arabic);
                System.out.println("ИТОГ = " + result_roman);
            } else {
                System.out.println("ИТОГ = " + (int)result_arabic);
            }
            System.out.print("Введите следующее выражение (Пример: \"V + III\"): ");
            //Выход из калькулятора
            isExit = inputString.equals("close");
        }
    }

}

