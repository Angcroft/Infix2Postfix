import java.util.Scanner;

public class CLI {

    private InfixToPostfixConverter converter;

    public CLI() {
        this.converter = new InfixToPostfixConverter();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Infix to Postfix conversor");
        System.out.println("Write 'Exit' to finish program");

        while (true) {
            System.out.print("\nInput an expression in infix notation: ");
            String expression = scanner.nextLine();

            if (expression.equalsIgnoreCase("Exit")) {
                System.out.println("Exiting program...");
                break;
            }

            try {
                String result = converter.convertToPostfix(expression);
                System.out.println("Postfix notation: " + result);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        CLI cli = new CLI();
        cli.start();
    }
}