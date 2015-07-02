package chicm;

public class LCS {

  public static void main(String[] args) {
    // TODO Implement LCS.main
    int[] s1 = {1, 2, 3, 4, 1};
    int[] s2 = {3, 4, 1, 2, 1, 3};
    
    System.out.println(lcs(s1, s2));
  }
  private static String lcs(int[] s1, int[] s2) {
    int len1 = s1.length;
    int len2 = s2.length;
    int[][] directions = new int[len1+1][len2+1];
    int[][] dp = new int[len1+1][len2+1];
    for(int i = 1; i <= len1; i++) {
        for(int j = 1; j <= len2; j++) {
            if(s1[i-1] == s2[j-1]) {
                dp[i][j] = dp[i-1][j-1] + 1;
                directions[i][j] = 1;
            } else if(dp[i-1][j] >= dp[i][j-1]) {
                dp[i][j] = dp[i-1][j];
                directions[i][j] = 2;
            } else {
                dp[i][j] = dp[i][j-1];
                directions[i][j] = 3;
            }
        }
    }
    StringBuilder sb = new StringBuilder();
    int i = len1, j = len2;
    while(i > 0 && j > 0) {
        if(s1[i-1] == s2[j-1]) {
            sb.insert(0, " "+s1[i-1]);
            i--;
            j--;
        } else if(directions[i][j] == 2) {
            i--;
        } else {
            j--;
        }
    }
    return sb.toString().trim();
}
}
