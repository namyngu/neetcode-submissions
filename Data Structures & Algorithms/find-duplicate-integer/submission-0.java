class Solution {
     // Strategy 2:
    // Using fast and slow pointers
    // Treat the array like a linked list, where each index points to the next index given by its value.
    // Because one number is duplicated, two indices will point into the same chain, creating a cycle — exactly like a linked list with a loop.
    // Using Floyd’s Fast & Slow Pointer technique:
    //
    // The slow pointer moves one step at a time.
    // The fast pointer moves two steps at a time.
    // If there’s a cycle, they will eventually meet.
    // Once they meet, we start a new pointer from the beginning:
    //
    // Move both pointers (slow ptr & new ptr) one step at a time.
    // The point where they meet again is the duplicate number (the entry point of the cycle)
   public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        // initial move
        slow = nums[slow];
        fast = nums[nums[fast]];

        while (fast != slow) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        // start new ptr
        int newPTR = 0;

        while (newPTR != slow) {
            slow = nums[slow];
            newPTR = nums[newPTR];
        }

        return slow;
    }
}
