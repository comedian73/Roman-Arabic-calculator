import java.util.Scanner;

class Calculator {
    String input;
    int result;

    void Input() {
        Scanner in = new Scanner(System.in);
        System.out.println("Input: ");
        input = in.nextLine();
        input = input.replaceAll("\\s","");
    }

    void Operation() {

        char[] in_char = new char[20];
        char op=0;
        for (int i = 0; i < input.length(); i++) {
            in_char[i] = input.charAt(i);
            if (in_char[i] == '*'){
                op = '*';
                break;
            }
            if (in_char[i] == '/'){
                op = '/';
                break;
            }
            if (in_char[i] == '-'){
                op = '-';
                break;
            }
            if (in_char[i] == '+'){
                op = '+';
                break;
            }
        }
        String[] operation = {"+","-","/","*"};
        String[] d = {",","."};
        int counter = 0;
        for (int i=0; i<=operation.length - 1; i++) {
            if (input.contains(operation[i])) {
                counter++;
            }
        }
        try {
            if (doubleOP(input,op) || counter > 1 ) {
                throw new Exception("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            } else if (counter == 0) {
                throw new Exception("throws Exception //т.к. строка не является математической операцией");
            } else if (input.contains(d[0]) || input.contains(d[1])) {
                throw new Exception("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два целых операнда и один оператор (+, -, /, *)");
            }

            String[] value = input.split("[+-/*]");
            String v1 = value[0];
            String v2 = value[1];
            int value1, value2;
            try {
                if (RomToInt(v1) < 0 & RomToInt(v2) < 0) {
                    value1 = Integer.parseInt(v1);
                    value2 = Integer.parseInt(v2);
                    if (limit(value1,value2)) {
                        throw new Exception("throws Exception //т.к. выражение не удовлетворяет заданию - операнды должны быть в диапазоне от 1 до 10 включительно");
                    }
                    result = Calculat(value1, value2, op);
                    System.out.println("Output:");
                    System.out.println(result);
                } else if (RomToInt(v1) > 0 & RomToInt(v2) > 0) {
                    value1 = RomToInt(v1);
                    value2 = RomToInt(v2);
                    result = Calculat(value1, value2, op);
                    try {
                        if (result > 0) {
                            String res = IntToRom(result);
                            System.out.println("Output:");
                            System.out.println(res);
                        } else
                            throw new Exception("throws Exception //т.к. в римской системе нет отрицательных чисел и 0");
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                } else
                    throw new Exception("throws Exception //т.к. используются одновременно разные системы счисления");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
    static String IntToRom (int Arabian) {
        String[] rom={"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV",
                "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII",
                "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV",
                "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII",
                "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        return rom[Arabian];
    }

    static int RomToInt (String Rom) {
        return switch (Rom) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> -1;
        };
    }

    public static int Calculat(int v1, int v2, char op) {
        int result = 0;
        switch (op){
            case '-':
                result = v1 - v2;
                break;
            case '+':
                result = v1 + v2;
                break;
            case '*':
                result = v1 * v2;
                break;
            case '/':
                result = v1 / v2;
                break;
        }
        return result;
    }

    public static boolean doubleOP(String input, char operation) {
        char[] c = new char [20];
        int count =0;
        for (int i=0; i<input.length();i++) {
            c[i] = input.charAt(i);
            if (c[i] == operation) {
                count++;
            }
        }
        if (count>1) {
            return true;
        } else
            return false;
    }

    public static boolean limit(int val1, int val2) {
        if ((val1>0 & val2>0) & (val1<=10 & val2<=10)){
            return false;
        } else
            return true;
    }
}