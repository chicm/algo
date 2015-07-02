package chicm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

  public static void main(String[] args) {
    // TODO Implement FourSum.main
    int[] num = {-492,-479,-468,-447,-432,-428,-418,-406,-388,-369,-300,-275,-238,-231,-228,-225,-224,-221,-220,-219,-189,-186,-180,-144,-130,-73,-67,-66,-55,-54,-53,-19,-6,13,28,36,47,57,80,82,87,97,97,120,132,142,148,174,176,176,205,225,232,238,245,247,264,268,268,275,319,334,387,392,412,413,426,434,442,451,475,478,485,490};
    int[] num2 = {1, 2, 3, 4, 4, 5};
    List<List<Integer>> res = fourSum(num2, 10);
    System.out.println(res.toString());
  }
  public static List<List<Integer>> fourSum(int[] num, int target) {
    List<List<Integer>> res = new ArrayList<>();
    if(num == null || num.length < 4) {
        return res;
    }
    Arrays.sort(num);
    fourSum(num, 1, 0, target, new ArrayList<Integer>(), res);
    return res;
}

private static void fourSum(int[] num, int level, int start, int target, List<Integer> pre, List<List<Integer>> res) {
    if(level == 5) {
        if(target == 0) {
            List<Integer> tmp = new ArrayList<>(pre);
            res.add(tmp);
        }
        return;
    }
    for(int i = start; i < num.length; i++) {
       pre.add(num[i]);
       fourSum(num, level+1, i+1, target-num[i], pre, res);
       pre.remove(pre.size()-1);
    }
}
}
