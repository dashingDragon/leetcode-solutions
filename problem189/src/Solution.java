import java.util.*;

class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length == 1) return;
        k = k % nums.length;
        int[] to_put_first = new int[k];
        for (int i = 0; i < k; i++) {
            to_put_first[i] = nums[nums.length - k + i];
        }
        for (int i = nums.length - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = to_put_first[i];
        }
    }

    public void rotateSol1(int[] nums, int k) {
        List<Integer> nums_list = new ArrayList<Integer>();
        for (int i = 0; i <nums.length; i++) {
            nums_list.add(nums[i]);
        }
        Collections.rotate(nums_list, k);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums_list.get(i);
        }
    }
}