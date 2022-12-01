import java.util.HashSet;

import static java.lang.Math.max;
import static java.lang.Math.min;


class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet set = new HashSet();
        for (int num : nums) {
            set.add(num);
        }
        return nums.length != set.size();
    }
}