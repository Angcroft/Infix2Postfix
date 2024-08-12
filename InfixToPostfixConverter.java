import java.util.Stack;

public class InfixToPostfixConverter {
    
    //  Convert infix to postfix
    public String convertToPostfix(String expression) throws IllegalArgumentException {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        //  Delete white spaces on expression
        expression = expression.replaceAll("\\s", "");

        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);

            if (Character.isLetterOrDigit(currentChar)) {
                postfix.append(currentChar);
            } else if (currentChar == '(') {
                stack.push(currentChar);
            } else if (currentChar == ')') {
                while(!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                if (stack.isEmpty() || stack.peek() != '(') {
                    throw new IllegalArgumentException("Disbalanced parenthesis in expression.");
                } 
                stack.pop();
            } else if (isOperator(currentChar)) {
                while (!stack.isEmpty() && precedence(currentChar) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(currentChar);
            } else {
                throw new IllegalArgumentException("Character not valid in expression: " + currentChar);
            }
        }

        //  Empty the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                throw new IllegalArgumentException("Disbalanced parenthesis in expression.");
            }
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    //  Determine precedence of operators
    private int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    //  Verify if character is an operator
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    //  Main method for test execution
    public static void main(String[] args) {
        InfixToPostfixConverter converter = new InfixToPostfixConverter();

        String[] expressions = {
            "a + b * (c ^ d - e) ^ (f + g * h) - i",
            "(a+b)*(c-d)",
            "a + b * c",
            "a + (b * c ^ (d - e))",
            "a + b - c + (d * e)"
        };

        for (String expression : expressions) {
            try {
                String result = converter.convertToPostfix(expression);
                System.out.println("Infix: " + expression);
                System.out.println("Postfix: " + result);
                System.out.println();
            } catch (IllegalArgumentException e) {
                System.out.println("Error in expression: " + expression);
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }
}