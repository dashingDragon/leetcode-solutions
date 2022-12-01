class Solution {
    public int[] sortedSquares(int[] nums) {
        if (nums.length == 1) {
            int[] res = new int[1];
            res[0] = nums[0] * nums[0];
            return res;
        }
        int pos = 0;
        int neg;
        int i = 0;
        int[] res = new int[nums.length];
        while (pos < nums.length && nums[pos] < 0) {
            pos++;
        }
        if (pos == nums.length) {
            neg = nums.length - 1;
        } else if (pos == 0) {
            neg = -1;
        } else {
            neg = pos - 1;
        }
        while(pos < nums.length && neg >= 0) {
            int sq1 = nums[neg] * nums[neg];
            int sq2 = nums[pos] * nums[pos];
            if (sq1 <= sq2) {
                res[i] = sq1;
                neg--;
            } else {
                res[i] = sq2;
                pos++;
            }
            i++;
        }
        if (pos == nums.length) {
            while(neg >= 0) {
                res[i] = nums[neg] * nums[neg];
                i++;
                neg--;
            }
        } else {
            while (pos < nums.length) {
                res[i] = nums[pos] * nums[pos];
                i++;
                pos++;
            }
        }
        return res;
    }
}