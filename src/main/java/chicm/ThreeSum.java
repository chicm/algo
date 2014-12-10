package chicm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ¡Ü b ¡Ü c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
    
 * @author chicm
 *
 */

public class ThreeSum {
  public List<List<Integer>> threeSum(int[] num) {
    List<List<Integer>> resultList = new ArrayList<>();
    Arrays.sort(num);
    for(int i = 0; i < num.length; i ++){
        if(i > 0 && num[i] == num[i-1])
            continue;
        if(num[i] > 0){
            break;
        }else{
            for(int j = i+1, k = num.length - 1; k > j;){
                if(j > i+1 && num[j] == num[j-1]){
                    j++;
                    continue;
                }
                if(num[j]+ num[i] > 0){
                    break;
                }
                if(num[j]+ num[i] + num[k] < 0)
                    j++;
                else if(num[j]+ num[i] + num[k] > 0)
                    k--;
                else{
                    List<Integer> ll = new ArrayList<>();
                    ll.add(num[i]);
                    ll.add(num[j]);
                    ll.add(num[k]);
                    resultList.add(ll);
                    j++;
                }
            }
        }

    }
    return resultList;
}
}
