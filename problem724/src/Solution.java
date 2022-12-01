class Solution {
    public int pivotIndex(int[] nums) {
        if (nums.length == 1) return 0;
        int[] runningSum = new int[nums.length + 1];
        runningSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum[i + 1] = nums[i] + runningSum[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if ((runningSum[i] * 2 + nums[i]) == runningSum[nums.length]) {
                return i;
            }
        }
        return -1;
    }
}