package chicm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakII {

  public static void main(String[] args) {
    // TODO Implement WordBreakII.main
    List<String> dict = Arrays.asList("a");
    //List<String> result = new ArrayList<>();
    
    System.out.println(wordBreakRecursive("a",  
      dict));

    
  }
  
  public static List<String> wordBreakDP(String s, List<String> dict) {
    
    Map<Integer, List<String>> validMap = new HashMap<Integer, List<String>>();

    // initialize the valid values
    List<String> l = new ArrayList<String>();
    l.add("");
    validMap.put(s.length(), l);

    // generate solutions from the end
    for(int i = s.length() - 1; i >= 0; i--) {
        List<String> values = new ArrayList<String>();
        for(int j = i + 1; j <= s.length(); j++) {
            if (dict.contains(s.substring(i, j))) {
                for(String word : validMap.get(j)) {
                    values.add(s.substring(i, j) + (word.isEmpty() ? "" : " ") + word);
                }
            }
        }
        validMap.put(i, values);
    }
    return validMap.get(0);
}
  
  static Map<String, List<String>> results = new HashMap<String, List<String>>();

  public static List<String> wordBreak2(String s, List<String> dict) {
      List<String> words = new ArrayList<String>();

      int len = s.length();
      for (int i = 1; i <= len; i++) {
          String front = s.substring(0, i);
          if (dict.contains(front)) {
              if (i == len) {
                  words.add(front);
              } else {
                  String remain = s.substring(i, len);
                  List<String> remainSet = results.containsKey(remain) ? 
                          results.get(remain) : wordBreak2(remain, dict);
                  if (remainSet != null) {
                      for (String item : remainSet) {
                          words.add(front + " " + item);
                      }
                      results.put(remain, remainSet);
                  }  

              }
          }
      }
      return words;
  }
  
  
  public static List<String> wordBreakRecursive(String s, List<String> dict) {
    return workBreakHelper(s, dict, new HashMap<String, List<String>>());
}

public static List<String> workBreakHelper(String str, List<String> dict, Map<String, List<String>> dp) {
    List<String> res = new ArrayList<>();
    if(str.length() < 1) {
        return res;
    }
    
    if(dp.containsKey(str)) {
        return dp.get(str);
    }
    
    for(int i =1; i <= str.length(); i++) {
        String word = str.substring(0, i);
        if(dict.contains(word)) {
            List<String> sub = workBreakHelper(str.substring(i), dict, dp );
            if(sub.size() > 0) {
                for(String s : sub) {
                    res.add(word + " " + s);
                }
            }else {
                res.add(word);
            }
        }
    }
    dp.put(str, res);
    return res;
}
  /*
  public static void workBreak(String str, int start, String pre, List<String> result, List<String> dict) {
    if(start >= str.length()) {
      result.add(pre);
      return;
    }
    
    for(int i = start+1; i <= str.length(); i++) {
      String word = str.substring(start, i);
      if(dict.contains(word)) {
        workBreak(str, i, pre+ " " + word, result, dict );
      }
    }
  }*/

}
