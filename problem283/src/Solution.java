class Solution {
    public void moveZeroes(int[] nums) {
        int no_zeroes_found = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                no_zeroes_found++;
            } else {
                nums[i - no_zeroes_found] = nums[i];
            }
        }

        for (int i = 0; i < no_zeroes_found; i++) {
            nums[nums.length - 1 - i] = 0;
        }
    }
}