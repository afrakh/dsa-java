// Memoization is the top - down approach
// Tabulation is the bottom up approach
// After optimized and dvanced recursion, the recursion tree is now skewed
// Before dynamic programming the recursive code gave exponential time complexity (2^n)
// After memoization the time complexity is linear O(n + 1)
// DC is optimized recursion in which our time complexity is better
// For identifying as a DP problem, first condition is that the problem should be optimal and secondly some choice is given (ultiple branches in recursion tree)
// Dynamic Programming is a technique in computer programming that helps to efficiently solve a class of problems that have overlapping subproblems and optimal substructure property
// There are some problems in which memoization cannot be used due to stack overflow problem
// In those cases we ought to use tabulation
// Tabulation is more efficient than memoization
// In memoization the larger problem is broken down to smaller problems and and we have a storage so we reuse already stored during our problem
// In tabulation, the code is iteration based and we make a table, set or storage.

public class fibonacci{
    public static int fibMemoization(int n, int dp[]){
        if (n == 0 || n == 1){
            return n;
        }
        if (dp[n] != 0){
            return dp[n];
        }
        dp[n] = fibMemoization(n - 1, dp) + fibMemoization(n - 2, dp);
        return dp[n];
    }

    public static int fibTabulation(int n){
        int dp[] = new int[n + 1];
        dp[0] = 0; dp[1] = 1;

        for (int i = 2; i <=n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 6;
        int dp[] = new int[n + 1];
        System.out.println(fibMemoization(n, dp));
        System.out.println(fibTabulation(n));
    }

}
