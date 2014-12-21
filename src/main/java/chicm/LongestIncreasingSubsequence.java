package chicm;

import java.util.Random;

public class LongestIncreasingSubsequence {

  public static void main(String[] args) {
    int[] a = {1, 2, 300, 500, 3, 100, 20, 500, 6, 7, 8, 200, 1000};
    int LEN = 10;
    int[] b= new int[LEN];
    Random r = new Random();
    for(int i = 0; i < LEN; i++) {
      b[i] = r.nextInt(100);
    }
    System.out.println("b:" + b.toString());
    for(int n: b) {
      System.out.print(" "+ n);
    }
    System.out.println("");
    
    System.out.println("LIS len:" + naiveLIS(b));
    
    System.out.println("faster LIS len:" + fasterLIS(b));
  }
  
  public static int naiveLIS(int[] array) {
    if(array.length == 0 )
      return 0;
    if(array.length == 1)
      return 1;
    int maxLIS = 1;
    int[] b = new int[array.length];
    b[0] = 1;
    for(int i =1 ; i < array.length; i++) {
      int maxLen = 1;
      for(int j = 0; j < i; j++) {
        if(array[i] > array[j] ) {
          int len = b[j] + 1;
          maxLen = Math.max(len, maxLen);
        }
      }
      b[i] = maxLen;
      maxLIS = Math.max(maxLIS, maxLen);
    }
    
    return maxLIS;
  }
  
  public static int fasterLIS(int[] array) {
    if(array.length == 0 )
      return 0;
    if(array.length == 1)
      return 1;
    
    int[] b = new int[array.length];
    b[0] = array[0];
    b[1] = array[0];
    int len = 1;
    for(int i = 1; i < array.length; i++ ) {
      if(array[i] > b[len-1] ) {
        b[++len] = array[i];
      } else {
        int pos = findPos(b, 0, len, array[i]);
        if(pos >=0) {
          b[pos] = array[i];
        }
      }
    }
    
    System.out.println("b:" + b.toString());
    for(int n: b) {
      System.out.print(" "+ n);
    }
    
    return len;
  }
  
  private static int findPos(int[] a, int start,  int len, int n) {
    if(len == 0 || len == 1)
      return len;
    
    int pos = (start + len) /2;
    
    if(n == a[pos])
        return -1;
    if( n > a[pos-1] && n < a[pos])
      return pos;
    
    if(n > a[pos]) {
      return findPos(a, pos, len, n);
    }
    
    if(n < a[pos-1]) {
      return findPos(a, start, pos, n);
    }
    
    
    return -1;
  }

}
