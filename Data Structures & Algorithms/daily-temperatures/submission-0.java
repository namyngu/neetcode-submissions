class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        // Edge case
        if (temperatures.length == 0) {
            return new int[]{0};
        }

        int[] solution = new int[temperatures.length];
        Stack<Integer> index = new Stack<>();
        Stack<Integer> temp = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {

            // if stack is empty
            if (temp.isEmpty()) {
                index.push(i);
                temp.push(temperatures[i]);
                continue;
            }

            // if next temp is colder add temp to both stack.
            if (temperatures[i] <= temp.peek()) {
                index.push(i);
                temp.push(temperatures[i]);
                continue;
            }

            // if next temp is warmer
            // Check all previous temps - remove them as you go
            // Add new temp into stack once checking is done.
            boolean pass = false;
            while (!pass) {
                // If stack is no empty
                if (temp.isEmpty()) {
                    index.push(i);
                    temp.push(temperatures[i]);
                    pass = true;
                }
                else if (temperatures[i] > temp.peek()) {
                    solution[index.peek()] = i - index.peek();     // add data to solution array
                    index.pop();        // remove element from stack
                    temp.pop();         // remove element from stack
                }
                else {
                    index.push(i);
                    temp.push(temperatures[i]);
                    pass = true;
                }
            }
        }

        // Any temps remaining in the stack means there's no warmer days - set all values to zero
        while (!temp.isEmpty()) {
            solution[index.peek()] = 0;
            index.pop();
            temp.pop();
        }

        return solution;
    }
}
