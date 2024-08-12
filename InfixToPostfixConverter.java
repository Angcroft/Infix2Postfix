import java.util.Stack;

public class InfixToPostfixConverter {

    public String convertToPostfix(String expression) throws IllegalArgumentException {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        expression = expression.replaceAll("\\s+", ""); // Delete white spaces

        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);

            if (Character.isLetterOrDigit(currentChar)) {
                postfix.append(currentChar);
            } else if (currentChar == '(') {
                stack.push(currentChar);
            } else if (currentChar == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                if (stack.isEmpty() || stack.peek() != '(') {
                    throw new IllegalArgumentException("Disbalanced parenthesis in expression.");
                }
                stack.pop(); // Delete '('
            } else if (OperatorUtils.isOperator(currentChar)) {
                while (!stack.isEmpty() && OperatorUtils.precedence(currentChar) <= OperatorUtils.precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(currentChar);
            } else {
                throw new IllegalArgumentException("Character not valid in expression: " + currentChar);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                throw new IllegalArgumentException("Disbalanced parenthesis in expression.");
            }
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }
}