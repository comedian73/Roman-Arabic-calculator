import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String start_input, input;
        Scanner in = new Scanner(System.in);
        System.out.println("Input: ");
        start_input = in.nextLine();
        input = start_input.replaceAll("\\s","");
        Calculate calc = new Calculate(input);
        calc.Run();
    }
}