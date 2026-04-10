class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = new int[m];
        for (int i = 0; i < m; i++) {
            tmp[i] = nums1[i];
        }

        int ptr1 = 0;   // pointer for nums1
        int ptr2 = 0;   // pointer for nums2
        int ptr3 = 0;   // pointer for tmp
        while (ptr1 < nums1.length) {
            if (ptr3 >= m) {
                nums1[ptr1] = nums2[ptr2];
                ptr2++;
            }
            else if (ptr2 >= n) {
                nums1[ptr1] = tmp[ptr3];
                ptr3++;
            }
            else {
                // compare which is lower
                if (tmp[ptr3] <= nums2[ptr2]) {
                    nums1[ptr1] = tmp[ptr3];
                    ptr3++;
                }
                else {
                    nums1[ptr1] = nums2[ptr2];
                    ptr2++;
                }
            }

            ptr1++;
        }
    }
}