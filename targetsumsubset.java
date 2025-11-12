public class targetsumsubset {
    public static boolean targetSum(int arr[], int target) {
        boolean dp[][] = new boolean[arr.length + 1][target + 1];

        
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

   
        for (int i = 1; i < arr.length + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                int v = arr[i - 1];

                if (v <= j && dp[i - 1][j - v]) {
                    dp[i][j] = true;
                }

                if (dp[i - 1][j]) {
                    dp[i][j] = true;
                }
            }
        }
        print2DArray(dp);

     
        return dp[arr.length][target];
    }

    public static void print2DArray(boolean dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int val[] = {4, 2, 7, 1, 3};
        int target = 10;
        System.out.println(targetSum(val, target));  
        
    }
}
