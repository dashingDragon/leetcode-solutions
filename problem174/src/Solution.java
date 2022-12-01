import static java.lang.Math.max;
import static java.lang.Math.min;

class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] V = new int[m][n];
        V[m - 1][n - 1] = max(1 - dungeon[m - 1][n - 1], 1);
        for (int i = m - 2; i >= 0 ; i--) {
            // last column of the dungeon
            V[i][n - 1] = max(V[i + 1][n - 1] - dungeon[i][n - 1], 1);
        }
        for (int j = n - 2; j >= 0 ; j--) {
            // last row of the dungeon
            V[m - 1][j] = max(V[m - 1][j + 1] - dungeon[m - 1][j], 1);
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0 ; j--) {
                V[i][j] = max(min(V[i + 1][j], V[i][j + 1]) - dungeon[i][j], 1);
            }
        }
        return V[0][0];
    }

    public int calculateMinimumHPCA(int[][] dungeon, int Kc, int Kl) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] V = new int[m][n];
        V[m - 1][n - 1] = max(1 - dungeon[m - 1][n - 1], 1);
        for (int I = m - 1; I >= 0; I -= Kl) {
            for (int J = n - 1; J >= 0; J -= Kc) {
                int I_end = max(0, I - Kl);
                int J_end = max(0, J - Kc);
                computeBlock(dungeon, V, I, I_end, J, J_end);
            }
        }
        return V[0][0];
    }

    public int calculateMinimumHPCO(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] V = new int[m][n];
        V[m - 1][n - 1] = max(1 - dungeon[m - 1][n - 1], 1);
        blockingRec(dungeon, V, 0, m - 1, 0, n - 1);
        return V[0][0];
    }

    public void blockingRec(int[][] dungeon, int[][] V, int I_start, int I_end, int J_start, int J_end) {
        int threshold = 5;
        if ((I_end - I_start) < threshold && (J_end - J_start) < threshold) {
            computeBlock(dungeon, V, I_start, I_end, J_start, J_end);
        } else {
            if ((I_end - I_start) < (J_end - J_start)) {
                // width is the largest dimension
                // always compute the right block first
                blockingRec(dungeon, V, I_start, I_end, ((J_end + J_start) >>> 1) + 1, J_end);
                blockingRec(dungeon, V, I_start, I_end, J_start, (J_end + J_start) >>> 1);
            } else {
                // height is the largest dimension
                // always compute the bottom block first
                blockingRec(dungeon, V, ((I_end + I_start) >>> 1) + 1, I_end, J_start, J_end);
                blockingRec(dungeon, V, I_start, (I_end + I_start) >>> 1, J_start, J_end);
            }
        }
    }

    public void computeBlock(int[][] dungeon, int[][] V, int I, int I_end, int J, int J_end) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        for (int i = I; i >= I_end; i--) {
            for (int j = J; j >= J_end ; j--) {
                if (i == m - 1 && j == n - 1) continue;
                V[i][j] = (i == m-1) ? max(V[m-1][j+1] - dungeon[m-1][j], 1)
                        : (j == n-1) ? max(V[i+1][n-1] - dungeon[i][n-1], 1)
                        : max(min(V[i+1][j], V[i][j+1]) - dungeon[i][j], 1);
            }
        }
    }

}