class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int res = 1;
        int l = 0;
        char signFlag = '=';

        // Edge case
        if (arr.length == 1) {
            return 1;
        }

        for (int r = 1; r < arr.length; r++) {
            int diff = arr[r] - arr[r - 1];
            
            if(diff == 0) {
                signFlag = '=';
                l = r;
            }
            // still turbulent
            else if ((diff > 0 && signFlag == '>') || (diff < 0 && signFlag == '<') || signFlag == '=') {
                signFlag = (diff > 0) ? '<' : '>';
                res = Math.max(res, r - l + 1);
            }
            // not turbulent
            else {
                signFlag = (diff > 0) ? '<' : '>';
                l = r - 1;
            }
        }
        return res;
    }
}