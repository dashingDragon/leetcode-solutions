class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid = 0;
        while (lo < hi) {
            mid = (lo + hi) >>> 1;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo == nums.length - 1 ? (target <= nums[lo] ? lo : lo + 1) : lo;
    }
}