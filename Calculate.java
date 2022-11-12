public class Calculate {
    private String input;
    private int result;
    Calculate (String input) {
        this.input = input;
    }
    void Run() {

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
            if (Logic.doubleOP(input,op) || counter > 1 ) {
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
                if (Logic.RomToInt(v1) < 0 & Logic.RomToInt(v2) < 0) {
                    value1 = Integer.parseInt(v1);
                    value2 = Integer.parseInt(v2);
                    if (Logic.limit(value1,value2)) {
                        throw new Exception("throws Exception //т.к. выражение не удовлетворяет заданию - операнды должны быть в диапазоне от 1 до 10 включительно");
                    }
                    result = Logic.Calculat(value1, value2, op);
                    System.out.println("Output:");
                    System.out.println(result);
                } else if (Logic.RomToInt(v1) > 0 & Logic.RomToInt(v2) > 0) {
                    value1 = Logic.RomToInt(v1);
                    value2 = Logic.RomToInt(v2);
                    result = Logic.Calculat(value1, value2, op);
                    try {
                        if (result > 0) {
                            String res = Logic.IntToRom(result);
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

}
