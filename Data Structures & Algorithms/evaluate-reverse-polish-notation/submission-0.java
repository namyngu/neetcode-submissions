class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        Set<String> operations = new HashSet<>();
        operations.add("+");
        operations.add("-");
        operations.add("*");
        operations.add("/");

        for (int i = 0; i < tokens.length; i++) {

            int sum = 0;
            String str = tokens[i];

            if (!operations.contains(str)) {
                stack.push(str);
            }
            else {
                try {
                    int operand2 = Integer.parseInt(stack.pop());
                    int operand1 = Integer.parseInt(stack.pop());

                    switch (str) {
                        case "+":
                            sum = operand1 + operand2;
                            break;

                        case "-":
                            sum = operand1 - operand2;
                            break;

                        case "*":
                            sum = operand1 * operand2;
                            break;

                        case "/":
                            sum = operand1 / operand2;
                            break;

                        default:
                            System.out.println("Error: this should never happen");
                            break;
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Error: Failed to parse string into integer");
                }

                String strSum = String.valueOf(sum);
                stack.push(strSum);
            }
        }

        return Integer.parseInt(stack.pop());
    }
}
