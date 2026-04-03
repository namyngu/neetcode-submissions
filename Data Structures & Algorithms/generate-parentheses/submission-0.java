class Solution {
    public List<String> generateParenthesis(int n) {
        Stack<String> stack = new Stack<>();
        int openParenthCount = 0;
        int closeParenthCount = 0;
        List<String> solution = new ArrayList<>();

        nextMove(stack, openParenthCount, closeParenthCount, n, solution);
        
        return solution;
    }

    // Method to determine the next possible moves and execute it
    public void nextMove(Stack<String> stack, int openParenthCount, int closeParenthCount, int n, List<String> solution) {

        // 3. No more possible moves - add well-formed parenthesis to solution list
        if (openParenthCount >= n && closeParenthCount >= openParenthCount) {
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            sb.reverse();
            solution.add(sb.toString());
        }

        // If you can add open and close parenthesis
        else if ((openParenthCount < n) && (closeParenthCount < openParenthCount) ) {
            Stack<String> addOpen = new Stack<>();
            addOpen.addAll(stack);
            Stack<String> addClose = new Stack<>();
            addClose.addAll(stack);


            // add open parenthesis and go to next move
            addOpen.push("(");
            nextMove(addOpen, openParenthCount + 1, closeParenthCount, n, solution);

            // add close parenthesis and go to next move
            addClose.push(")");
            nextMove(addClose, openParenthCount, closeParenthCount + 1, n, solution);
        }

        // If you can add only open parenthesis
        else if ((openParenthCount < n) && (closeParenthCount >= openParenthCount)) {
            stack.push("(");

            // Go to next move - recursive function
            nextMove(stack, openParenthCount + 1, closeParenthCount, n, solution);
        }

        // Can only add close parenthesis
        else if ((openParenthCount >= n) && (closeParenthCount < openParenthCount)) {
            stack.push(")");

            // Go to next move - recursive function
            nextMove(stack, openParenthCount, closeParenthCount + 1, n, solution);
        }
    }
}
