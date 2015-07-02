package chicm;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

  public static void main(String[] args) {
    // TODO Implement Permutations.main
    int[] num = {-1, -1, 3, -1};
    List<List<Integer>> res = permuteUnique(num);
    System.out.println(res.toString());
  }
  public static List<List<Integer>> permuteUnique(int[] num) {
    List<List<Integer>> result = new ArrayList<>();
    if(num.length == 0) {
        return result;
    }
    
    permute(num, 0, result);
    return result;
}
private static void permute(int[] num, int start, List<List<Integer>> result) {
    List<Integer> curResult = new ArrayList<>();
    if(start == num.length -1) {
        for(int n: num) {
            curResult.add(n);
        }
        result.add(curResult);
        return;
    }
    
    for(int i = start; i <= num.length-1; i++) {
        int tmp = num[start];
        num[start] = num[i];
        num[i] = tmp;
        
        permute(num, start+1, result);
        
        tmp = num[i];
        num[i] = num[start];
        num[start] = tmp;
    }
}
}
