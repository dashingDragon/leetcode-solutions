class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int index1 = 0;
        int lo, hi, mid;
        while (index1 < numbers.length - 1) {
            hi = numbers.length - 1;
            lo = index1 + 1;
            while (lo < hi) {
                mid = (lo + hi) >>> 1;
                if (numbers[index1] + numbers[mid] < target) {
                    lo = mid + 1;
                } else if (numbers[index1] + numbers[mid] >= target) {
                    hi = mid;
                }
            }
            if (numbers[index1] + numbers[lo] == target) {
                int[] res = {index1 + 1, lo + 1};
                return res;
            }
            index1++;
        }
        return null;
    }

    public int[] twoSumBest(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;

        while (numbers[l] + numbers[r] != target) {
            if (numbers[l] + numbers[r] < target) l++;
            else r--;
        }
        return new int[] {l + 1, r + 1};
    }


    public int[] twoSumNaive(int[] numbers, int target) {
        int index1 = 0;
        int index2 = 1;
        while (index1 < numbers.length) {
            while (index2 < numbers.length && numbers[index1] + numbers[index2] <= target) {
                if (numbers[index1] + numbers[index2] == target) {
                    int[] res = {index1 + 1, index2 + 1};
                    return res;
                }
                index2++;
            }
            index1++;
            index2 = index1 + 1;
        }
        return null;
    }
}