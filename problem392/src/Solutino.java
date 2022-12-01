class Solution {
    public boolean isSubsequence(String s, String t) {
        int j = 0;
        int i = 0;
        if (s.length() == 0) return true;
        while (j < t.length()) {
            if (t.charAt(j) == s.charAt(i)) i++;
            if (i == s.length()) return true;
            j++;
        }
        return false;
    }
}