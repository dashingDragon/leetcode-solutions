class Solution {
    public String reverseWords(String s) {
        StringBuffer res = new StringBuffer();
        int lastNonBlank = 0, reverseIndex;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (lastNonBlank == i - 1) {
                    reverseIndex = lastNonBlank;
                    while (reverseIndex >= 0 && s.charAt(reverseIndex) != ' ') {
                        res.append(s.charAt(reverseIndex--));
                    }
                }
                res.append(' ');
            } else {
                lastNonBlank = i;
            }
        }
        if (lastNonBlank == s.length() - 1) {
            reverseIndex = lastNonBlank;
            while (reverseIndex >= 0 && s.charAt(reverseIndex) != ' ') {
                res.append(s.charAt(reverseIndex--));
            }
        }
        return res.toString();
    }
}