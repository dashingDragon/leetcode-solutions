import java.util.HashSet;

public class Solution {

    public static void main(String[] args) {
        System.out.println(syracuseMemo(100));
    }

    public static boolean syracuseMemo(int N) {
        HashSet<Integer> mem = new HashSet<Integer>();
        for (int i = 1; i < N; i++) {
            syracuse(i, mem);
        }
        return true;
    }

    public static boolean syracuse(int n, HashSet<Integer> mem) {
        while (n != 1) {
            if (mem.contains(n)) break;
            n = (n % 2 == 0) ? n / 2 : 3 * n + 1;
            mem.add(n);
        }
        return true;
    }

}
