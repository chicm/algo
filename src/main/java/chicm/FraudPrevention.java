package chicm;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class FraudPrevention {
  public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner in = new Scanner(System.in);
    int N = Integer.parseInt(in.nextLine());
    
    String[][] orders = new String[N][8];
    for(int i = 0; i < N; i++) {
        orders[i] = in.nextLine().split(",");
        norm(orders[i]);
    }
    Queue<Integer>  q = new PriorityQueue<>();
    for(int i = 0; i < N; i++) {
        for(int j = i+1; j < N; j++) {
            if(orders[i][2].equals(orders[j][2]) && orders[i][1].trim().equals(orders[j][1].trim()) 
              && !orders[i][7].equals(orders[j][7])) {
                int order1 = Integer.parseInt(orders[i][0]);
                int order2 = Integer.parseInt(orders[j][0]);
                //System.out.println("" + Math.min(order1, order2) + "," + Math.max(order1, order2));
                q.add(order1);
                q.add(order2);
            }
            if(orders[i][3].trim().equals(orders[j][3].trim()) 
               && orders[i][4].trim().equals(orders[j][4].trim()) 
               && orders[i][5].trim().equals(orders[j][5].trim()) 
               && orders[i][6].trim().equals(orders[j][6].trim()) 
               && orders[i][1].trim().equals(orders[j][1].trim())
               && !orders[i][7].equals(orders[j][7])) {
                int order1 = Integer.parseInt(orders[i][0]);
                int order2 = Integer.parseInt(orders[j][0]);
                //System.out.println("" + Math.min(order1, order2) + "," + Math.max(order1, order2));
                q.add(order1);
                q.add(order2);
            }
        }
    }
    if(!q.isEmpty()) {
      System.out.print(q.poll());
    }
    while(!q.isEmpty()) {
      System.out.print("," + q.poll());
    }
    System.out.println();
}
public static void norm(String[] order) {
    String email = order[2].toLowerCase();
    String pre = email.substring(0, email.indexOf('@'));
    String sufix = email.substring(email.indexOf('@'));
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < pre.length(); i++) {
        if(pre.charAt(i) == '.') {
            continue;
        } else if(pre.charAt(i) == '+') {
            break;
        } else {
            sb.append(pre.charAt(i));
        }
    }
    order[2] = sb.toString() + sufix;
    
    order[3] = normAddress(order[3]);
    order[4] = normAddress(order[4]);
    order[5] = normAddress(order[5]);
    order[6] = order[6].replaceAll("-", "");
    
    for(int i =0; i < 8; i++) {
      System.out.print(order[i] + "|");
    }
    System.out.println("");
}
public static String normAddress(String addr) {
    String result = addr.toUpperCase();
    result = result.replaceAll("NEW YORK", "NY");
    result = result.replaceAll("CALIFORNIA", "CA");
    result = result.replaceAll("ILLINOIS", "IL");
    result = result.replaceAll("STREET", "ST.");
    result = result.replaceAll("ROAD", "RD.");
    return result;
}
}
