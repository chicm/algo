package chicm;

import java.util.Arrays;
import java.util.Scanner;

public class BiggerIsGreater {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = Integer.parseInt(in.nextLine());
    for(int i = 0; i < t; i++) {
        System.out.println(solve(in.nextLine()));
    }
}

public static String solve(String s) {
    char[] chs = s.toCharArray();
    int i = chs.length-1;
    for(; i>0; i--) {
        if(chs[i] > chs[i-1]) {
            break;
        }
    }
    if( i == 0) {
        return "no answer";
    }
    char tmp = chs[i];
    chs[i] = chs[i-1];
    chs[i-1] = tmp;
    
    StringBuilder sb = new StringBuilder();
    for(int j = 0; j <= i-1; j++) {
        sb.append(chs[j]);
    }
    char[] suffix = new char[chs.length-i];
    System.arraycopy(chs, i, suffix, 0, chs.length-i);
    Arrays.sort(suffix);
    for(int k = 0; k < suffix.length; k++) {
        sb.append(suffix[k]);
    }
    
    return sb.toString();
}
}
