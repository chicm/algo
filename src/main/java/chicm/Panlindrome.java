package chicm;

import java.util.Scanner;

public class Panlindrome {

  public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for(int i = 0; i < t; i++) {
        System.out.println(pal(in.next()));
    }
   // System.out.println(pal("aaab"));
   // System.out.println(pal("baa"));
   // System.out.println(pal("aaa"));
}

public static boolean isPal(String s) {
  int left = 0; 
  int right = s.length()-1;
  for(; left <= right && s.charAt(left) == s.charAt(right); right--, left++) {
  }
  return left > right;
}

public static int pal(String s) {
    if(isPal(s)) {
        return -1;
    }
    int left = 0;
    int right = s.length()-1;
    while(left <= right) {
        if(s.charAt(left) != s.charAt(right)) {
           String s1 = s.substring(0, left) + s.substring(left+1);
           if(isPal(s1)) {
               return left;
           } else {
               return right;
           }
        }
        left++;
        right--;
    }
    return -1;
}
}
