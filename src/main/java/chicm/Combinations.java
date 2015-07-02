package chicm;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

  public static void main(String[] args) {
    // TODO Implement Combinations.main
    List<List<Integer>> res = combine(6,3);
    System.out.println(res.toString());
  }
  
  public static List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> com = new ArrayList<>();
    if(n < 1) {
        return res;
    }
    
    combine(n, com, 1, 1, k, res);
    return res;
}
private static void combine(int n, List<Integer> pre, int start, int level, int k, List<List<Integer>> res) {
    if(level > k) {
        List<Integer> temp = new ArrayList<Integer>(pre);
        res.add(temp);
        return;
    }
    
    for(int i = start; i <= n; i++ ) {
        pre.add(i);
        combine(n, pre, i+1, level+1, k, res);
        pre.remove(pre.size()-1);
        /*
        List<Integer> com = new ArrayList<>();
        com.addAll(pre);
        com.add(i);
        combine(n, com, i+1, level+1, k, res);*/
    }
}
}
