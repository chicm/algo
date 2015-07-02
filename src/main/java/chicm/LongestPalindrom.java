package chicm;

public class LongestPalindrom {

  public static void main(String[] args) {
    // TODO Implement LongestPalindrom.main
    System.out.println(dp("abcccccccbeffffffffffffffffeffaaaffffffffffffffffxfffffff"));
  }
  
  public static String dp(String s) {
    if(s.length() < 2) {
      return s;
    }
    int maxbegin = 0;
    int maxlen = 1;
    boolean[][] dp = new boolean[s.length()][s.length()];
    int len = s.length();
    for(int i = 0; i < len; i++) {
      dp[i][i] = true;
      
      if(i < len -1 && s.charAt(i) == s.charAt(i+1)) {
        dp[i][i+1] = true;
        maxbegin = i;
        maxlen = 2;
      }
    }
    
    for(int i = len-3; i>= 0; i--) {
      for(int j = i+2; j < len; j++ ) {
        if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
          dp[i][j] = true;
          if(j-i+1>maxlen) {
          maxbegin = i;
          maxlen = j-i+1;
          }
        }
      }
    }
    
    return s.substring(maxbegin, maxbegin+maxlen);
  }
  
  public static String longestPalindrome(String s) {
    char[] chars = s.toCharArray();
    int length = chars.length;
    String maxRes = "";
    for (int i=0; i<length; i++) {
        // find longest odd palindrome
        String odd = findPalindrome(chars, length, i, 0);
        if(odd.length() > maxRes.length()) {
            maxRes = odd;
        }
        // find longest even palindrome
        String even = findPalindrome(chars, length, i, 1);
        if(even.length() > maxRes.length()) {
            maxRes = even;
        }
    }
    return maxRes;
}

private static String findPalindrome(char[] chars, int length, int i, int shift) {
    int left = i;
    int right= i+shift;
    while (left >= 0 && right < length && chars[left] == chars[right]){
        left--; right++;
    }
    String maxString = "";
    if ((right-left-1) > 0) {
        //maxLength = right-left-1;
        maxString = new String(chars, left+1, right-left-1);
    }
    return maxString;
}
}
