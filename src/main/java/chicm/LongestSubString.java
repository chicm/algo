package chicm;

import java.util.Arrays;

public class LongestSubString {

  public static void main(String[] args) {
    // TODO Implement LongestSubString.main
    lengthOfLongestSubstring("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco");
  }
  public static int lengthOfLongestSubstring(String s) {
    if(s == null || s.length() < 1) {
        return 0;
    }
    if(s.length() == 1) {
        return 1;
    }
    //Set<Character> repeat = new HashSet<>();
    
    int[] index = new int[256];
    Arrays.fill(index, -1);
    int max = 0;
    int curMax = 0;
    int start = 0;
    for(int i = 0; i < s.length(); i++) {
      String str = s.substring(start, i);
      System.out.println(str + ": " + str.length());
        if(index[s.charAt(i)] < 0 || (i - index[s.charAt(i)]) > curMax ) {
            curMax ++;
        } else {
            max = Math.max(max, curMax);
            curMax = i - index[s.charAt(i)];
            start = index[s.charAt(i)]+1;
        }
        index[s.charAt(i)] = i;
    }
    return Math.max(max, curMax); 
}
}
