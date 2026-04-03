class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> records = new Stack<>();

        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("+")) {
                int num2 = records.pop();
                int num1 = records.pop();
                int sum = num1 + num2;
                records.push(num1);
                records.push(num2);
                records.push(sum);
            }
            else if(operations[i].equals("D")) {
                int num = records.pop();
                int num2 = num*2;
                records.push(num);
                records.push(num2);
            }
            else if(operations[i].equals("C")) {
                records.pop();
            }
            else {
                records.push(Integer.parseInt(operations[i]));
            }
        }

        int sum = 0;
        while (!records.empty()) {
            sum += records.pop();
        }
        return sum;
    }
}