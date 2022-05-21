package Calculator;

public class NumberConvertManager {
    public static String transform_number_to_roman_numeral(double number) {
        if (number<1){
            throw new IllegalArgumentException("Результат операции с римскими числами не может быть отрицательным");
        }
        int[] roman_value_list = new int[]{100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman_char_list = new String[]{"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < roman_value_list.length; i += 1) {
            while (number >= roman_value_list[i]) {
                number -= roman_value_list[i];
                res.append(roman_char_list[i]);
            }
        }
        return res.toString();
    }
}
