import java.util.*;
public class matrixChainMultiplication {
    public static int mcm(int arr[], int i, int j){
        if (i == j){
            return 0;  //single matrix case
        }

        int ans = Integer.MAX_VALUE;
        for (int k=i; k<=j-1; k++){
            int cost1 = mcm(arr, i, k);   //Ai...Ak => arr[i-1] x arr[k]
            int cost2 = mcm(arr, k+1, j);  //Ak+1...Aj => arr[k] x arr[j]
            int cost3 = arr[i-1] * arr[k] * arr[j]; // a x b x d operations

            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalCost);
        }

        return ans;  //mincost
    }

    public static int mcmMemo(int arr[], int i, int j, int dp[][]){
        if (i == j){
            return 0;  //single matrix case
        }

        if (dp[i][j] != -1){
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;
        for (int k=i; k<=j-1; k++){
            int cost1 = mcm(arr, i, k);   //Ai...Ak => arr[i-1] x arr[k]
            int cost2 = mcm(arr, k+1, j);  //Ak+1...Aj => arr[k] x arr[j]
            int cost3 = arr[i-1] * arr[k] * arr[j]; // a x b x d operations

            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalCost);
        }

        return dp[i][j] = ans;  //mincost

    }

    public static int mcmTab(int arr[]){
        int n = arr.length;
        int dp[][] = new int[n][n];

        // initialization
        for (int i = 0; i < n; i++){
                dp[i][i] = 0;
        }

        // bottom up
        for (int len=2; len<=n-1; len++){
            for (int i=1; i<=n-len;i++){
                int j = i+len-1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k=i; k<=j-1; k++){
                    int cost1 = dp[i][k];   //Ai...Ak => arr[i-1] x arr[k]
                    int cost2 = dp[k+1][j];  //Ak+1...Aj => arr[k] x arr[j]
                    int cost3 = arr[i-1] * arr[k] * arr[j]; // a x b x d operations

                    int finalCost = cost1 + cost2 + cost3;
                    dp[i][j] = Math.min(dp[i][j], finalCost);
                }
            }
        }

        return dp[1][n-1];
    }

    public static void main(String args[]){
        int arr[] = {1, 2, 3, 4, 3}; // n = 5
        int n = arr.length;

        System.out.println(mcm(arr, 1, n-1));

        int dp[][] = new int[n][n];
        for (int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }

        System.out.println(mcmMemo(arr, 1, n-1, dp));

        System.out.println(mcmTab(arr));
    }
}
