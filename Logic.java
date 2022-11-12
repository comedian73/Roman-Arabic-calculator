public class Logic {
    public static String IntToRom (int Arabian) {
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

    public static int RomToInt (String Rom) {
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
