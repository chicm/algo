package chicm;

import java.util.Scanner;

public class ManasaStone {
  public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    for(int i = 0; i < T; i++) {
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int[] arr = new int[n];
        solve(n, Math.min(a, b), Math.max(a, b), arr);
        if(a == b) {
            System.out.println(arr[0]);
            continue;
        }
        System.out.print(arr[0]);
        if(n > 1) {
            for(int j = 1; j < n; j++) {
                System.out.print(" " + arr[j]);
            }
        }
        System.out.println(); 
    }
}

public static void solve(int n, int a, int b, int[] arr) {
    for(int i = 0; i < n; i++) {
        arr[i] = (n-1-i)*a + i*b;
    }
}
}
