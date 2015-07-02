package chicm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreakI {

  public static void main(String[] args) {
    String s1 = "leetcode";
    String s2 = "leetcode2";
    Set<String> dict = new HashSet<String>();
    //dict.add("leet");
    //dict.add("code");
    String s3 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaba";
    dict.addAll(Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"));
    
    //System.out.println(wordBreak(s1, dict));
    //System.out.println(wordBreak(s2, dict));
    //System.out.println(wordBreak(s3, dict));
    System.out.println(wordBreakDP(s3, dict, new HashMap<Integer, Boolean>(), 0));
    //System.out.println(wordBreak("", dict));

  }
  
  public static boolean wordBreak(String s, Set<String> dict) {
    if( s == null || s.length() < 1) {
        return true;
    } 
    for(int i = 1; i <= s.length(); i++) {
        if(dict.contains(s.substring(0,i)) && wordBreak(s.substring(i), dict)) {
            return true;
        }
    }
    return false;
  }
  
  public static boolean wordBreakDP(String s, Set<String> dict, Map<Integer, Boolean> map, int index) {
    if(s == null || s.length() < 1 || index >= s.length()) {
      return true;
    }
    if(map.get(index) != null) {
      return map.get(index);
    }
    
    for(int i = index+1; i <= s.length(); i++) {
      if(dict.contains(s.substring(index,i))) {
        if(wordBreakDP(s, dict, map, i)) {
          map.put(i, true);
          return true;
        } else {
          map.put(i, false);
        }
      }
    }
    
    return false;
  }
}