class Solution {
    public int countStudents(int[] students, int[] sandwiches) {

        Deque<Integer> qStudents = new ArrayDeque<>();
        for (int i = 0; i < students.length; i++) {
            qStudents.addLast(students[i]);
        }

        Deque<Integer> qSandwiches = new ArrayDeque<>();
        for (int i = 0; i < sandwiches.length; i++) {
            qSandwiches.addLast(sandwiches[i]);
        }

        int numStudents = students.length;

        for (int i = 0; i < qStudents.size(); i++) {
            // For debugging:
            // String str = "Students: ";
            // for (Integer student : qStudents) {
            //     str = str + student + " ,";
            // }
            // String str2 = "Sandwiches: ";
            // for (Integer sandwich : qSandwiches) {
            //     str2 = str2 + sandwich + " ,";
            // }
            // System.out.println("i: " + i + " | length: " + qStudents.size());
            // System.out.println(str);
            // System.out.println(str2);


            int prefers = qStudents.removeFirst();

            if (prefers == qSandwiches.peek()) {
                qSandwiches.pop();
                i = -1;      // new pattern!??
            }
            else {
                qStudents.addLast(prefers);
            }

            
        }

        return qStudents.size();
    }
}