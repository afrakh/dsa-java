public class mountainRanges {
    public static int mountRanges(int n){
        int dp[] = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i=2; i<=n; i++){
            // i pairs -> mountain ranges -> Ci
            for (int j=0; j<i; j++){
                int inside = dp[j];
                int outside = dp[i-j-1];

                dp[i] += inside * outside; // Ci = Cj * Ci-j-1
            }
        }
        return dp[n];
    }
    public static void main(String args[]){
        int n = 5;

        System.out.println(mountRanges(n));
    }
}
